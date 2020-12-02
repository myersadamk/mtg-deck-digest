package com.digitalcocoa.mtg.deck.organizer.service;

import com.digitalcocoa.mtg.deck.organizer.client.mtgio.RawCard;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface CodeValueExtractor {
  Flux<Code> extractCode(RawCard card);
}
