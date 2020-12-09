package com.digitalcocoa.mtg.model.digest.codes;

import com.digitalcocoa.mtg.model.domain.code.CardProperty;
import com.digitalcocoa.mtg.model.domain.code.Codifiable;
import com.digitalcocoa.mtg.catalog.client.mtgio.rest.MagicCard;
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
