package com.digitalcocoa.mtg.card.organizer.domain.code;

public record Code(String value, int valueId, CardProperty meaning, int meaningId) {
  public Code(String value, int valueId, String meaning, int meaningId) {
    this(value, valueId, CardProperty.valueOf(meaning.toUpperCase()), meaningId);
  }
}
