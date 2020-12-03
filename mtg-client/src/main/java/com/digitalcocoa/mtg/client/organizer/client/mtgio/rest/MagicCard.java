package com.digitalcocoa.mtg.client.organizer.client.mtgio.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.immutables.value.Value.Immutable;

@Immutable
@JsonDeserialize(builder = ImmutableMagicCard.Builder.class)
public interface MagicCard {
  Optional<Long> multiverseid();

  String name();

  List<String> names();

  String rarity();

  String set();

  String type();

  Optional<String> manaCost();

  Optional<Integer> cmc();

  Set<String> colorIdentity();

  Set<String> colors();

  Set<String> types();

  Set<String> supertypes();

  Set<String> subtypes();

  Optional<String> text();
}
