package com.digitalcocoa.mtg.model.domain.card;

import com.digitalcocoa.mtg.catalog.client.mtgio.rest.MagicCard;
import com.digitalcocoa.mtg.model.domain.code.Code;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Set;
import org.immutables.value.Value.Immutable;

@Immutable
@JsonSerialize(as = ImmutableNewCard.class)
@JsonDeserialize(builder = ImmutableNewCard.Builder.class)
public interface NewCard {
  String name();

  String type();

  String manaCost();

  int cmc();

  Set<Code> attributes();

  static NewCard fromMagicCard(MagicCard card) {
    return ImmutableNewCard.builder()
        .name(card.name())
        .type(card.type())
        .manaCost(card.manaCost().orElse(""))
        .cmc(card.cmc().orElse(0))
        .build();
  }

  static Card fromCard(Card card) {
    return ImmutableCard.builder()
        .name(card.name())
        .type(card.type())
        .manaCost(card.manaCost())
        .cmc(card.cmc())
        .build();
  }
}
