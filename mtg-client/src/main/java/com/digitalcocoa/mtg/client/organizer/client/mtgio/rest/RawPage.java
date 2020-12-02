package com.digitalcocoa.mtg.client.organizer.client.mtgio.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;
import org.immutables.value.Value.Style;

@Style(jdkOnly = true)
@Immutable(builder = true, singleton = true)
@JsonDeserialize(as = ImmutableRawPage.class)
interface RawPage {

  @Parameter
  List<RawCard> cards();

  static RawPage empty() {
    return ImmutableRawPage.of();
  }
}
