package com.digitalcocoa.mtg.client.organizer.client.mtgio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Filters}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableFilters.builder()}.
 */
@Generated(from = "Filters", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableFilters implements Filters {
  private final List<String> sets;

  private ImmutableFilters(ImmutableFilters.Builder builder) {
    this.sets = builder.setsIsSet()
        ? createUnmodifiableList(true, builder.sets)
        : createUnmodifiableList(false, createSafeList(Filters.super.sets(), true, false));
  }

  private ImmutableFilters(List<String> sets) {
    this.sets = sets;
  }

  /**
   * @return The value of the {@code sets} attribute
   */
  @Override
  public List<String> sets() {
    return sets;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Filters#sets() sets}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFilters withSets(String... elements) {
    List<String> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableFilters(newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Filters#sets() sets}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of sets elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFilters withSets(Iterable<String> elements) {
    if (this.sets == elements) return this;
    List<String> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableFilters(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableFilters} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableFilters
        && equalTo((ImmutableFilters) another);
  }

  private boolean equalTo(ImmutableFilters another) {
    return sets.equals(another.sets);
  }

  /**
   * Computes a hash code from attributes: {@code sets}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + sets.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Filters} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Filters{"
        + "sets=" + sets
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Filters} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Filters instance
   */
  public static ImmutableFilters copyOf(Filters instance) {
    if (instance instanceof ImmutableFilters) {
      return (ImmutableFilters) instance;
    }
    return ImmutableFilters.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableFilters ImmutableFilters}.
   * <pre>
   * ImmutableFilters.builder()
   *    .addSets|addAllSets(String) // {@link Filters#sets() sets} elements
   *    .build();
   * </pre>
   * @return A new ImmutableFilters builder
   */
  public static ImmutableFilters.Builder builder() {
    return new ImmutableFilters.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableFilters ImmutableFilters}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Filters", generator = "Immutables")
  public static final class Builder {
    private static final long OPT_BIT_SETS = 0x1L;
    private long optBits;

    private List<String> sets = new ArrayList<String>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Filters} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Filters instance) {
      Objects.requireNonNull(instance, "instance");
      addAllSets(instance.sets());
      return this;
    }

    /**
     * Adds one element to {@link Filters#sets() sets} list.
     * @param element A sets element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSets(String element) {
      this.sets.add(Objects.requireNonNull(element, "sets element"));
      optBits |= OPT_BIT_SETS;
      return this;
    }

    /**
     * Adds elements to {@link Filters#sets() sets} list.
     * @param elements An array of sets elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSets(String... elements) {
      for (String element : elements) {
        this.sets.add(Objects.requireNonNull(element, "sets element"));
      }
      optBits |= OPT_BIT_SETS;
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Filters#sets() sets} list.
     * @param elements An iterable of sets elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder sets(Iterable<String> elements) {
      this.sets.clear();
      return addAllSets(elements);
    }

    /**
     * Adds elements to {@link Filters#sets() sets} list.
     * @param elements An iterable of sets elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSets(Iterable<String> elements) {
      for (String element : elements) {
        this.sets.add(Objects.requireNonNull(element, "sets element"));
      }
      optBits |= OPT_BIT_SETS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableFilters ImmutableFilters}.
     * @return An immutable instance of Filters
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableFilters build() {
      return new ImmutableFilters(this);
    }

    private boolean setsIsSet() {
      return (optBits & OPT_BIT_SETS) != 0;
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<>();
    } else {
      list = new ArrayList<>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }
}
