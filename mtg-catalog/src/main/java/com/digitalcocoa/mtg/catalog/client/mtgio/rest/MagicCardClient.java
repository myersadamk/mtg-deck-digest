package com.digitalcocoa.mtg.catalog.client.mtgio.rest;

import com.digitalcocoa.mtg.catalog.Filters;
import java.net.URI;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import reactor.core.publisher.Mono;

@Component
public final class MagicCardClient {

  private final WebClient client;

  @Autowired
  public MagicCardClient(WebClient mtgApiWebClient) {
    this.client = mtgApiWebClient;
  }

  public Mono<Integer> getLastPageNumber() {
    return getPage(1, Filters.NONE).map(Page::lastPageNumber);
  }

  public Mono<Page> getPage(int pageNumber) {
    return getPage(pageNumber, Filters.NONE);
  }

  public Mono<Page> getPage(int pageNumber, Filters filters) {
    assert pageNumber > 0 : "pageNumber must be > 0 (the mtgio API is 1-based).";
    final var pageBuilder = ImmutablePage.builder();

    return client
        .get()
        .uri(uriBuilder -> appendParameters(uriBuilder.path("/cards"), pageNumber, filters))
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .toEntity(PageDTO.class)
        .doOnNext(response -> populatePagingProtocol(pageNumber, response, pageBuilder))
        .map(response -> PageDTO.nullToEmpty(response.getBody()))
        .flatMapIterable(PageDTO::cards)
//        .filter(card -> card.multiverseid().isPresent()) // Consider logging
        .collectList()
        .doOnNext(System.out::println)
        .map(pageBuilder::cards)
        .map(ImmutablePage.Builder::build);
  }

  private static void populatePagingProtocol(
      int currentPage, ResponseEntity<?> entity, ImmutablePage.Builder pageBuilder) {
    final var headers = entity.getHeaders();

    PagingProtocol.getNextPageUri(headers)
        .map(MagicCardClient::stripPageNumberFromUri)
        .ifPresent(pageBuilder::nextPageNumber);

    PagingProtocol.getLastPageUri(headers)
        .map(MagicCardClient::stripPageNumberFromUri)
        .ifPresentOrElse(
            pageBuilder::lastPageNumber, () -> pageBuilder.lastPageNumber(currentPage));
  }

  private static String anyMatching(Collection<String> parameters) {
    return String.join("|", parameters);
  }

  private static String onlyMatching(Collection<String> parameters) {
    return String.join(",", parameters);
  }

  private URI appendParameters(UriBuilder uriBuilder, final int pageNumber, Filters filters) {
    uriBuilder.queryParam("page", pageNumber);
    if (!filters.sets().isEmpty()) {
      uriBuilder.queryParam("sets", anyMatching(filters.sets()));
    }
    return uriBuilder.build();
  }

  private static Integer stripPageNumberFromUri(UriComponents uriComponents) {
    return Integer.valueOf(uriComponents.getQueryParams().get("page").get(0));
  }
}
