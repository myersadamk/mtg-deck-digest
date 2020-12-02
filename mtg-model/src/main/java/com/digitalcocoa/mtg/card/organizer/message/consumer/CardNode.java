package com.digitalcocoa.mtg.card.organizer.message.consumer;

import java.util.Map;
import org.immutables.value.Value.Immutable;

@Immutable
public interface CardNode {
  String name();

  Map<String, String> properties();
}
