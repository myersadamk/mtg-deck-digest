package com.digitalcocoa.mtg.deck.organizer.client.mtgio;

import com.digitalcocoa.mtg.deck.organizer.client.mtgio.ImmutablePage.Builder;
import java.net.URI;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Component
public final class MagicCardClient {

  private final URI baseUri;
  private final WebClient client;
  //  private final BodyParser parser;

  public MagicCardClient() {
    this.baseUri = URI.create("some URI");
    this.client = WebClient.builder().build();
    //    this.parser = new BodyParser(new ObjectMapper());
  }

  @Autowired
  public MagicCardClient(@Value("${api.mtgio.cards.uri}") String baseUri, WebClient client) {
    this.baseUri = URI.create(baseUri);
    this.client = client;
    //    this.parser = parser;
  }

  public Mono<Integer> getLastPageNumber() {
    return getPage(1, Filters.NONE).map(Page::lastPageNumber);
  }

  public Mono<Page> getPage(int pageNumber) {
    return getPage(pageNumber, Filters.NONE);
  }

  public Mono<Page> getPage(int pageNumber, Filters filters) {
    //    checkArgument(pageNumber > 0, "The given pageNumber must be > 0 (the mtgio API is
    // 1-based).");

    final var pageBuilder = ImmutablePage.builder();

    return client
        .get()
        .uri(constructUriForPage(pageNumber, filters))
        .retrieve()
        .toEntity(RawPage.class)
        .doOnNext(entity -> populatePagingProtocol(pageBuilder, pageNumber, entity))
        .map(entity -> entity.getBody() == null ? ImmutableRawPage.of() : entity.getBody())
        .flatMapIterable(RawPage::cards)
        .filter(card -> card.multiverseid().isPresent())
        .collectList()
        .map(pageBuilder::cards)
        .map(Builder::build);
  }

  private static void populatePagingProtocol(
      ImmutablePage.Builder pageBuilder, int currentPage, ResponseEntity<?> entity) {
    final var headers = entity.getHeaders();

    PagingProtocol.getNextPageUri(headers)
        .map(MagicCardClient::stripPageNumberFromUri)
        .ifPresent(pageBuilder::nextPageNumber);

    PagingProtocol.getLastPageUri(headers)
        .map(MagicCardClient::stripPageNumberFromUri)
        .ifPresentOrElse(
            pageBuilder::lastPageNumber, () -> pageBuilder.lastPageNumber(currentPage).build());
  }

  private static String anyMatching(Collection<String> parameters) {
    return String.join("|", parameters);
  }

  private static String onlyMatching(Collection<String> parameters) {
    return String.join(",", parameters);
  }

  private URI constructUriForPage(final int pageNumber, Filters filters) {
    final var builder = UriComponentsBuilder.fromUri(baseUri).queryParam("page", pageNumber);
    if (!filters.sets().isEmpty()) {
      builder.queryParam("sets", anyMatching(filters.sets()));
    }
    return builder.build().toUri();
  }

  private static Integer stripPageNumberFromUri(UriComponents uriComponents) {
    return Integer.valueOf(uriComponents.getQueryParams().get("page").get(0));
  }
}
