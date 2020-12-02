package com.digitalcocoa.mtg.card.organizer.message.consumer;

import java.util.List;
import org.immutables.value.Value.Immutable;

@Immutable
public interface DeckPayload {
  DeckAttributes attributes();

  List<CardNode> mainboard();

  List<CardNode> sideboard();
}