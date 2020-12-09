package com.digitalcocoa.mtg.model.digest;

import com.digitalcocoa.mtg.catalog.CardCatalog;
import com.digitalcocoa.mtg.catalog.ImmutableFilters;
import com.digitalcocoa.mtg.catalog.client.mtgio.rest.MagicCard;
import com.digitalcocoa.mtg.model.digest.codes.CodeValueExtractor;
import com.digitalcocoa.mtg.model.domain.card.Card;
import com.digitalcocoa.mtg.model.domain.card.CardRegistryService;
import com.digitalcocoa.mtg.model.domain.card.NewCard;
import com.digitalcocoa.mtg.model.domain.code.CardProperty;
import com.digitalcocoa.mtg.model.domain.code.Code;
import com.digitalcocoa.mtg.model.domain.code.CodeRegistryService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
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
        catalog.getCards(ImmutableFilters.builder().addSets("KTK").build()).take(1000);

    return registerBaseCodeSets(cards)
        .thenMany(digestCards(cards))
        .then();
  }

  private Mono<Void> registerBaseCodeSets(Flux<MagicCard> cardFlux) {
    return Flux.fromIterable(extractors)
        .map(CodeValueExtractor::codifies)
        .collect(Collectors.toSet())
        .flatMap(codeRegistry::registerCodeSets)
        .thenMany(Flux.fromIterable(extractors))
        .flatMap(extractor -> saveNewCodeValues(extractor, cardFlux))
        .checkpoint("Finished saving newly-encountered code value meanings")
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
        .flatMap(
            newValues ->
                codeRegistry
                    .registerCodeValues(extractor.codifies(), newValues)
                    .checkpoint("Registered new code set with meaning: " + extractor.codifies()));
  }

  public Mono<Void> digestCards(Flux<MagicCard> latestCardFlux) {
    final Flux<MagicCard> newCardFlux =
        latestCardFlux
            .map(MagicCard::name)
            .collectList()
            .flatMapMany(cardRegistry::getCards)
            .thenMany(latestCardFlux)
            .filter(card -> !cardRegistry.isLoaded(card.name()))
            .map(NewCard::fromMagicCard)
            .collectList()
            .flatMapMany(cardRegistry::registerNewCards)
            .map(NewCard::name)
            .collectList()
            .flatMapMany(cardRegistry::getCards)
            .thenMany(latestCardFlux)
            .filter(card -> cardRegistry.isLoaded(card.name()));

    return digestCardAttributes(newCardFlux).then();
  }

  private Mono<Void> digestCardAttributes(Flux<MagicCard> latestCardFlux) {
    return latestCardFlux
        .flatMap(
            latestCard ->
                cardRegistry
                    .getCard(latestCard.name())
                    .flatMapMany(
                        existingCard ->
                            extractCardAttributes(existingCard, latestCard)
                                .flatMap(
                                    codes -> cardRegistry.registerAttributes(existingCard, codes))))
        .then();
  }

  private Flux<List<Code>> extractCardAttributes(Card existingCard, MagicCard latestCard) {
    return Flux.fromIterable(extractors)
        .flatMap(
            extractor ->
                codeRegistry
                    .getCodeSet(extractor.codifies())
                    .filter(codeSet -> !hasCardAttribute(existingCard, codeSet.meaning().getMeaning()))
                    .flatMapMany(
                        codeSet ->
                            extractor
                                .extract(latestCard)
                                .map(
                                    value ->
                                        new Code(
                                            value,
                                            codeSet.getCode(value).orElseThrow().valueId(),
                                            codeSet.meaning(),
                                            codeSet.id())))
                    .filter(code -> existingCard.cardAttribute().contains(code))
                    .collectList()
                    .filter(attributes -> !attributes.isEmpty()));

  }

  private boolean hasCardAttribute(Card existingCard, String meaning) {
    return existingCard.cardAttribute().stream()
        .map(Code::meaning)
        .map(CardProperty::getMeaning)
        .anyMatch(meaning::equals);
  }
}
