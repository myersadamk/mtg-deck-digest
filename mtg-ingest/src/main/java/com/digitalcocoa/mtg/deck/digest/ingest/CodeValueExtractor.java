package com.digitalcocoa.mtg.deck.digest.ingest;

import com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.MagicCard;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface CodeValueExtractor {
  Flux<Code> extractCode(MagicCard card);
}
