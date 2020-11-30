package com.digitalcocoa.mtg.deck.organizer.client.mtgio;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable(builder = false, singleton = true)
@JsonDeserialize(as = ImmutableRawPage.class)
public interface RawPage {
  @Parameter
  List<RawCard> cards();
}
