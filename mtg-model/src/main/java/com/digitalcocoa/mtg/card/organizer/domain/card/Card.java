package com.digitalcocoa.mtg.card.organizer.domain.card;

import com.digitalcocoa.mtg.card.organizer.domain.code.Codifiable;
import java.util.Set;
import liquibase.pro.packaged.T;

public record Card(
    Integer id,
    String name,
    String type,
    String manaCost,
    int cmc,
    Set<Attribute<T>> cardAttribute) {
  public record Attribute<T>(Codifiable<T> meaning, T value) {}
}
