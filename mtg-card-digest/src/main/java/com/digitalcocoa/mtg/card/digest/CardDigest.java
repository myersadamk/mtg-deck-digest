package com.digitalcocoa.mtg.card.digest;

import com.digitalcocoa.mtg.card.digest.codes.CodeValueExtractor;
import com.digitalcocoa.mtg.card.organizer.domain.card.CardRegistryService;
import com.digitalcocoa.mtg.card.organizer.domain.card.ImmutableNewCard;
import com.digitalcocoa.mtg.card.organizer.domain.code.CodeRegistryService;
import com.digitalcocoa.mtg.client.organizer.client.mtgio.CardCatalog;
import com.digitalcocoa.mtg.client.organizer.client.mtgio.ImmutableFilters;
import com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.MagicCard;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CardDigest {

  private final CardCatalog catalog;
  private final Set<CodeValueExtractor> extractors;
  private final CodeRegistryService codeRegistry;
  private final CardRegistryService cardRegistry;

  @Autowired
  public CardDigest(
      CardCatalog catalog,
      Set<CodeValueExtractor> extractors,
      CodeRegistryService codeRegistry,
      CardRegistryService cardRegistry) {
    this.catalog = catalog;
    this.extractors = extractors;
    this.codeRegistry = codeRegistry;
    this.cardRegistry = cardRegistry;
  }

  public Mono<Void> run() {
    final Flux<MagicCard> cards =
        catalog.getCards(ImmutableFilters.builder().addSets("KTK").build()).take(100).cache();

    return Flux.fromIterable(extractors)
        .map(CodeValueExtractor::codifies)
        .collect(Collectors.toSet())
        .flatMap(codeRegistry::registerCodeSets)
        .thenMany(Flux.fromIterable(extractors))
        .flatMap(extractor -> saveNewCodeValues(extractor, cards))
        .thenMany(cards)
        .flatMap(this::saveNewCard)
        .then();
  }

  private Mono<Integer> saveNewCodeValues(CodeValueExtractor extractor, Flux<MagicCard> cards) {
    return codeRegistry
        .getCodeSet(extractor.codifies())
        .flatMap(
            codeSet -> {
              final Set<String> existingCodeValues = codeSet.getCodeValues();

              return cards
                  .flatMap(extractor::extract)
                  .filter(extractedValue -> !existingCodeValues.contains(extractedValue))
                  .collectList()
                  .map(Set::copyOf);
            })
        .flatMap(newValues -> codeRegistry.registerCodeValues(extractor.codifies(), newValues));
  }

  private Mono<Integer> saveNewCard(MagicCard magicCard) {
    return cardRegistry
        .getCard(magicCard.name())
        .map(existingCard -> 0)
        .switchIfEmpty(
            Mono.just(magicCard)
                .map(
                    card ->
                        ImmutableNewCard.builder()
                            .name(card.name())
                            .type(card.type())
                            .manaCost(card.manaCost().orElse(""))
                            .cmc(card.cmc().orElse(0))
                            .build())
                .flatMap(cardRegistry::registerCard));
  }
}
