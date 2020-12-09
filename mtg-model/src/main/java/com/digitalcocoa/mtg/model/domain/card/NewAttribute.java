package com.digitalcocoa.mtg.model.domain.card;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewAttribute {
  private final String value;
  private final String meaning;
  private final int meaningId;
}
