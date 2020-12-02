package com.digitalcocoa.mtg.card.organizer.domain.code;

import java.util.Set;
import java.util.stream.Collectors;

public record CodeSet(int id, CardProperty meaning, Set<Code> codes) {

  public Set<String> getCodeValues() {
    return codes.stream().map(Code::value).collect(Collectors.toSet());
  }

  public boolean containsValue(String value) {
    return codes.stream().map(Code::value).anyMatch(value::equals);
  }
}
