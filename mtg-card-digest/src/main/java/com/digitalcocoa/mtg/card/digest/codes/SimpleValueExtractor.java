package com.digitalcocoa.mtg.card.digest.codes;

import com.digitalcocoa.mtg.card.organizer.domain.code.CardProperty;
import com.digitalcocoa.mtg.card.organizer.domain.code.Codifiable;
import com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.MagicCard;
import java.util.function.Function;
import reactor.core.publisher.Flux;

final class SimpleValueExtractor implements CodeValueExtractor {

  private final Function<MagicCard, String> extractor;
  private final CardProperty codeSet;

  public SimpleValueExtractor(Function<MagicCard, String> extractor, CardProperty codeSet) {
    this.extractor = extractor;
    this.codeSet = codeSet;
  }

  @Override
  public Flux<String> extract(MagicCard card) {
    return Flux.just(extractor.apply(card));
  }

  @Override
  public Codifiable codifies() {
    return () -> codeSet.name().toLowerCase();
  }
}
