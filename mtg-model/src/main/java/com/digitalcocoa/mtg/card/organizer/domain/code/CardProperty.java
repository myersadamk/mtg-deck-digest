package com.digitalcocoa.mtg.card.organizer.domain.code;

public enum CardProperty implements Codifiable {
  TYPE,
  SUBTYPE,
  SUPERTYPE;

  @Override
  public String getMeaning() {
    return name().toLowerCase();
  }
}
