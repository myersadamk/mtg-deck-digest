package com.digitalcocoa.mtg.model.domain.code;

public enum CardProperty implements Codifiable {
  TYPE,
  SUBTYPE,
  SUPERTYPE;

  @Override
  public String getMeaning() {
    return name().toLowerCase();
  }
}
