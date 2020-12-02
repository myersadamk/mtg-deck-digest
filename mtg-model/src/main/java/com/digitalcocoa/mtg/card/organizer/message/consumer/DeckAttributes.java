package com.digitalcocoa.mtg.card.organizer.message.consumer;

import com.digitalcocoa.mtg.card.organizer.domain.game.Format;
import java.util.Set;
import org.immutables.value.Value.Immutable;

@Immutable
public interface DeckAttributes {
  Set<Format> formats();
}
