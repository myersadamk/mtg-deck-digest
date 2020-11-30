package com.digitalcocoa.mtg.deck.organizer.service;

import com.digitalcocoa.mtg.deck.organizer.client.mtgio.CardCatalog;
import com.digitalcocoa.mtg.deck.organizer.client.mtgio.ImmutableFilters;
import com.digitalcocoa.mtg.deck.organizer.client.mtgio.RawCard;
import com.digitalcocoa.mtg.deck.organizer.repository.CardRepository;
import com.digitalcocoa.mtg.deck.organizer.repository.CodeSetRepository;
import com.digitalcocoa.mtg.deck.organizer.repository.entity.CodifiedValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

@Component
public class CardIngester {

  private final CardCatalog catalog;
  private final CodeSetRepository codeSetRepository;
  private final CardRepository cardRepository;

  public CardIngester(CardCatalog catalog, CodeSetRepository codeSetRepository, CardRepository cardRepository) {
    this.catalog = catalog;
    this.codeSetRepository = codeSetRepository;
    this.cardRepository = cardRepository;
  }

  public Mono<Void> run() {
    final Map<String, Set<String>> usedCodeValues = new HashMap<>();
    final Flux<RawCard> rawCards = catalog.getCards(ImmutableFilters.builder().addSets("10E").build()).take(2).cache();

    Mono<Map<String, List<CodifiedValue>>> codeValues = rawCards.doOnNext(card -> {
      usedCodeValues.put("types_display", card.types());
      usedCodeValues.put("types", card.types());
      usedCodeValues.put("supertypes", card.supertypes());
      usedCodeValues.put("subtypes", card.subtypes());
    }).collectList()
        .doOnNext(lol ->
            codeSetRepository.createCodeSets(usedCodeValues)
        ).then(Mono.fromCallable(() -> codeSetRepository.getCodeSets(usedCodeValues.keySet()))
    );

    return rawCards.zipWith(codeValues, Tuples::of).doOnNext(this::insertCardsAndCodes).then();
//

//        .flatMapIterable(List::copyOf).doOnEach(signal -> {
//      final ContextView codeContext = signal.getContextView();
//      final List<CodifiedValue> types = codeContext.get("types_display");
//      System.out.println(types);
//    }).collectList()
//        .doOnNext(cardRepository::batchInsert).then();
  }

  private void insertCardsAndCodes(Tuple2<RawCard, Map<String, List<CodifiedValue>>> cardAndCodes) {
      final RawCard card = cardAndCodes.getT1();
      final Map<String, List<CodifiedValue>> codez = cardAndCodes.getT2();
  }

  private Mono<Map<String, List<CodifiedValue>>> persistCodeTypes(Map<String, Set<String>> codeSets) {
    return Mono.fromRunnable(() -> codeSetRepository.createCodeSets(codeSets))
        .then(Mono.fromCallable(() -> codeSetRepository.getCodeSets(codeSets.keySet())));
  }

  private class CodeValue {

    String code;
    String value;
  }
}
