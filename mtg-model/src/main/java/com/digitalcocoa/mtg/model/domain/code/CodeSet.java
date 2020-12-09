package com.digitalcocoa.mtg.model.domain.code;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public record CodeSet(int id, CardProperty meaning, Set<Code> codes) {

  // TODO: implement a map

  public Optional<Code> getCode(String value) {
    return codes.stream().filter(code -> code.value().equals(value)).findAny();
  }

  public Set<String> getCodeValues() {
    return codes.stream().map(Code::value).collect(Collectors.toSet());
  }

  public boolean containsValue(String value) {
    return codes.stream().map(Code::value).anyMatch(value::equals);
  }
}
