package com.digitalcocoa.mtg.card.digest.codes;

import com.digitalcocoa.mtg.card.organizer.domain.code.CardProperty;
import com.digitalcocoa.mtg.card.organizer.domain.code.Codifiable;
import com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.MagicCard;
import java.util.Collection;
import java.util.function.Function;
import reactor.core.publisher.Flux;

final class MultiValuedExtractor implements CodeValueExtractor {

  private final Function<MagicCard, Collection<String>> extractor;
  private final CardProperty codeSet;

  public MultiValuedExtractor(
      Function<MagicCard, Collection<String>> extractor, CardProperty codeSet) {
    this.extractor = extractor;
    this.codeSet = codeSet;
  }

  @Override
  public Flux<String> extract(MagicCard card) {
    return Flux.fromIterable(extractor.apply(card));
  }

  @Override
  public Codifiable codifies() {
    return () -> codeSet.name().toLowerCase();
  }
}
