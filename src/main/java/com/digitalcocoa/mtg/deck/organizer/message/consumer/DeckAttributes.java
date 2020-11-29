package com.digitalcocoa.mtg.deck.organizer.message.consumer;

import com.digitalcocoa.mtg.deck.organizer.domain.game.Format;
import java.util.Set;
import org.immutables.value.Value.Immutable;

@Immutable
public interface DeckAttributes {
  Set<Format> format();
}
