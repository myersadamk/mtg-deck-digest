package com.digitalcocoa.mtg.deck.organizer.service;

import com.digitalcocoa.mtg.deck.organizer.domain.deck.Deck;
import com.digitalcocoa.mtg.deck.organizer.domain.deck.ImmutableDeck;
import com.digitalcocoa.mtg.deck.organizer.message.consumer.DeckPayload;

public class DeckProcessingService {

  public Deck processList(DeckPayload deckPayload) {
    return ImmutableDeck.builder().build();
  }
}
