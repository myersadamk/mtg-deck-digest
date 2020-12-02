package com.digitalcocoa.mtg.client.organizer.client.mtgio.rest;

import java.util.List;
import java.util.Optional;
import org.immutables.value.Value.Immutable;

@Immutable
public interface Page {

  List<MagicCard> cards();

  Optional<Integer> nextPageNumber();

  Integer lastPageNumber();
}
