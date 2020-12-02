package com.digitalcocoa.mtg.deck.organizer.domain.deck;

import com.digitalcocoa.mtg.deck.organizer.domain.game.Format;
import java.util.List;
import org.immutables.value.Value.Immutable;

@Immutable
public interface Deck {
  List<Card> mainboard();

  List<Card> sideboard();

  Format format();
}
