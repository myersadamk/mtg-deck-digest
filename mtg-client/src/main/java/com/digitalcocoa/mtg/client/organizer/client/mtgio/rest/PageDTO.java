package com.digitalcocoa.mtg.client.organizer.client.mtgio.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

record PageDTO(@JsonProperty("cards") List<MagicCard> cards) {
  private static final PageDTO EMPTY = new PageDTO(List.of());

  static PageDTO nullToEmpty(PageDTO pageDTO) {
    return pageDTO == null ? EMPTY : pageDTO;
  }
}
