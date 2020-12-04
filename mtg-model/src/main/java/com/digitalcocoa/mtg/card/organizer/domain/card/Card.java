package com.digitalcocoa.mtg.card.organizer.domain.card;

import com.digitalcocoa.mtg.card.organizer.domain.code.Code;
import java.util.Set;
import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;

@Immutable
public interface Card {
  Integer id();

  String name();

  String type();

  @Default
  default String manaCost() {
    return "";
  }

  @Default
  default int cmc() {
    return 0;
  }

  Set<Code> cardAttribute();
}
