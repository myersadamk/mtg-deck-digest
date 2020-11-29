package com.digitalcocoa.mtg.deck.organizer.message.consumer;

import org.immutables.value.Value.Immutable;

@Immutable
public interface DeckPayload {
  DeckAttributes attributes();
}
