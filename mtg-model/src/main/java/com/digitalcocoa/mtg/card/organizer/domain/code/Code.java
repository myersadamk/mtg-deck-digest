package com.digitalcocoa.mtg.card.organizer.domain.code;

public record Code(int id, CardProperty meaning, String value) {
  public Code(int id, String meaning, String value) {
    this(id, CardProperty.valueOf(meaning.toUpperCase()), value);
  }
}
