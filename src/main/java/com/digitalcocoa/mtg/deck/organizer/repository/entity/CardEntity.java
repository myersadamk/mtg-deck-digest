package com.digitalcocoa.mtg.deck.organizer.repository.entity;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Modifiable;

@Immutable
@Modifiable
public interface CardEntity {
  int id();
  String name();
  String rarity();
  String colorIdentity();
}
