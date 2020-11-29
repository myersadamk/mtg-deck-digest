package com.digitalcocoa.mtg.deck.organizer.service;

import com.digitalcocoa.mtg.deck.organizer.domain.card.Card;

@FunctionalInterface
public interface FormatFilter {
  boolean filter(Card card);
}
