package com.digitalcocoa.mtg.deck.organizer.service;

import com.digitalcocoa.mtg.deck.organizer.client.mtgio.CardCatalog;
import com.digitalcocoa.mtg.deck.organizer.client.mtgio.ImmutableFilters;
import com.digitalcocoa.mtg.deck.organizer.client.mtgio.RawCard;
import com.digitalcocoa.mtg.deck.organizer.repository.CardRepository;
import com.digitalcocoa.mtg.deck.organizer.repository.CodeSetRepository;
import com.digitalcocoa.mtg.deck.organizer.repository.CodeSetRepository.CodeValueEntity;
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

  private Set<Code> mapCodeValues(Collection<String> values, String meaning) {
    return values.stream().map(value -> new Code(value, meaning)).collect(Collectors.toSet());
  }

  public Mono<Void> run() {
    final Set<String> meanings = Set.of("types", "subtypes", "supertypes");

    final Flux<RawCard> cards = catalog.getCards(ImmutableFilters.builder().addSets("KTK").build()).take(100).cache();

    final Map<String, Integer> codeSetIDs = new HashMap<>();

    return codeSetRepository.insertCodeSets(meanings)
        .doOnNext(result -> {
          // log
        })
        .thenMany(cards)
        .flatMap(
            card ->
                Flux.concat(
                    Flux.just(mapCodeValues(card.types(), "types")),
                    Flux.just(mapCodeValues(card.subtypes(), "subtypes")),
                    Flux.just(mapCodeValues(card.supertypes(), "supertypes"))))
        .flatMap(Flux::fromIterable)
        .collectList()
        .doOnNext(encounteredCodes -> {
              codeSetIDs.putAll(codeSetRepository.getCodeSetIds(meanings));

              final Set<CodeSetRepository.CodeValueEntity> entities =
                  encounteredCodes.stream()
                      .map(
                          codeValue ->
                              new CodeValueEntity(
                                  codeValue.value(), codeSetIDs.get(codeValue.meaning())))
                      .collect(Collectors.toSet());

              codeSetRepository
                  .insertCodeValues(entities)
                  .subscribe(
                      updatedRows -> {
                        // log me!
                      });
            })
        .thenMany(cards)
        .collectList()
        .doOnNext(lol -> {
          codeSetIDs.
          System.out.println("lol");
        }).then();
  }
}
