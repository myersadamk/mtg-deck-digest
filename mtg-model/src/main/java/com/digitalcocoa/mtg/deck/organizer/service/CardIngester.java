package com.digitalcocoa.mtg.deck.organizer.service;

import com.digitalcocoa.mtg.deck.organizer.client.mtgio.CardCatalog;
import com.digitalcocoa.mtg.deck.organizer.client.mtgio.ImmutableFilters;
import com.digitalcocoa.mtg.deck.organizer.client.mtgio.RawCard;
import com.digitalcocoa.mtg.deck.organizer.repository.CardRepository;
import com.digitalcocoa.mtg.deck.organizer.repository.CodeSetRepository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CardIngester {

  private final CardCatalog catalog;
  private final CodeSetRepository codeSetRepository;
  private final CardRepository cardRepository;
  private final Set<CodeValueExtractor> extractors = null;

  public CardIngester(
      CardCatalog catalog, CodeSetRepository codeSetRepository, CardRepository cardRepository) {
    this.catalog = catalog;
    this.codeSetRepository = codeSetRepository;
    this.cardRepository = cardRepository;
  }

  private Set<Code> mapCodeValues(Collection<String> values, Integer codeSetID) {
    return values.stream().map(value -> new Code(value, meaning)).collect(Collectors.toSet());
  }

  public Mono<Void> run() {
    final Set<String> meanings = Set.of("types", "subtypes", "supertypes");

    final Flux<RawCard> cards =
        catalog.getCards(ImmutableFilters.builder().addSets("KTK").build()).take(100).cache();

    final Map<String, Integer> codeSetIDs = new HashMap<>();
    final Map<String, Integer> codeValues = new HashMap<>();

    return codeSetRepository
        .insertCodeSets(meanings)
        .doOnNext(encounteredCodes -> codeSetIDs.putAll(codeSetRepository.getCodeSetIds(meanings)))
        .thenMany(cards)
        .flatMap(
            card ->
                Flux.concat(
                        Flux.just(mapCodeValues(card.types(), codeSetIDs.get("types"))),
                        Flux.just(mapCodeValues(card.subtypes(), codeSetIDs.get("subtypes"))),
                        Flux.just(mapCodeValues(card.supertypes(), codeSetIDs.get("supertypes"))))
                    .flatMap(Flux::fromIterable)
                    .collectList()
                    .flatMap(codeSetRepository::insertCodeValues)
                    .doOnNext(
                        results -> {
                          // log osmething
                        })
                    .thenMany(cards)
                    .collectList()
                    .doOnNext(
                        lol -> {
                          System.out.println("lol");
                        }))
        .then();
  }
}
