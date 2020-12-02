package com.digitalcocoa.mtg.deck.organizer.repository.entity;

import java.util.Set;
import org.immutables.value.Value.Immutable;

@Immutable
public interface CodeSet {
  String type();

  Set<String> values();
}
