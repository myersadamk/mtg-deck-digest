package com.digitalcocoa.mtg.card.organizer.domain.card;

import com.digitalcocoa.mtg.card.organizer.domain.code.Code;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Set;
import org.immutables.value.Value.Immutable;

@Immutable
@JsonDeserialize(builder = ImmutableNewCard.Builder.class)
@JsonSerialize(as = ImmutableNewCard.class)
public interface NewCard {
  String name();

  String type();

  String manaCost();

  int cmc();

  Set<Code> attributes();
}
