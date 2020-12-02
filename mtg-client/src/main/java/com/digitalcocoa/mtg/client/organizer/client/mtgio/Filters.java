package com.digitalcocoa.mtg.client.organizer.client.mtgio;

import java.util.List;
import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Style;

@Immutable
@Style(instance = "empty")
public interface Filters {

  Filters NONE = ImmutableFilters.builder().build();

  @Default
  default List<String> sets() {
    return List.of();
  }
}
