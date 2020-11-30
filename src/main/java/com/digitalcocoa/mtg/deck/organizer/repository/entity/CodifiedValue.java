package com.digitalcocoa.mtg.deck.organizer.repository.entity;

import org.immutables.value.Value.Immutable;

@Immutable
public interface CodifiedValue {
  int codeId();
  int valueId();
  String code();
  String value();
}
