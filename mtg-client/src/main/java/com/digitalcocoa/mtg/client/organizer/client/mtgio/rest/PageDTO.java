package com.digitalcocoa.mtg.client.organizer.client.mtgio.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;
import org.immutables.value.Value.Style;

@Style(jdkOnly = true)
@Immutable(builder = false, singleton = true)
@JsonDeserialize(as = ImmutablePageDTO.class)
interface PageDTO {

  @Parameter
  List<MagicCard> cards();

  static PageDTO empty() {
    return ImmutablePageDTO.of();
  }
}
