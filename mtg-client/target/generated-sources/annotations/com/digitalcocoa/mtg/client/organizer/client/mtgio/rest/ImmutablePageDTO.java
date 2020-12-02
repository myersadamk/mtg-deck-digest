package com.digitalcocoa.mtg.client.organizer.client.mtgio.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PageDTO}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableRawPage.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ImmutableRawPage.of()}.
 * Use the static factory method to get the default singleton instance:
 * {@code ImmutableRawPage.of()}.
 */
@Generated(from = "RawPage", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
final class ImmutablePageDTO implements PageDTO {
  private final List<MagicCard> cards;

  private ImmutablePageDTO() {
    this.cards = Collections.emptyList();
  }

  private ImmutablePageDTO(Iterable<? extends MagicCard> cards) {
    this.cards = createUnmodifiableList(false, createSafeList(cards, true, false));
  }

  private ImmutablePageDTO(
      ImmutablePageDTO original,
      List<MagicCard> cards) {
    this.cards = cards;
  }

  /**
   * @return The value of the {@code cards} attribute
   */
  @JsonProperty("cards")
  @Override
  public List<MagicCard> cards() {
    return cards;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PageDTO#cards() cards}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePageDTO withCards(MagicCard... elements) {
    List<MagicCard> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return validate(new ImmutablePageDTO(this, newValue));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PageDTO#cards() cards}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of cards elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePageDTO withCards(Iterable<? extends MagicCard> elements) {
    if (this.cards == elements) return this;
    List<MagicCard> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return validate(new ImmutablePageDTO(this, newValue));
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRawPage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePageDTO
        && equalTo((ImmutablePageDTO) another);
  }

  private boolean equalTo(ImmutablePageDTO another) {
    return cards.equals(another.cards);
  }

  /**
   * Computes a hash code from attributes: {@code cards}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + cards.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code RawPage} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "RawPage{"
        + "cards=" + cards
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "RawPage", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements PageDTO {
    List<MagicCard> cards = Collections.emptyList();
    @JsonProperty("cards")
    public void setCards(List<MagicCard> cards) {
      this.cards = cards;
    }
    @Override
    public List<MagicCard> cards() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePageDTO fromJson(Json json) {
    ImmutablePageDTO.Builder builder = ImmutablePageDTO.builder();
    if (json.cards != null) {
      builder.addAllCards(json.cards);
    }
    return builder.build();
  }

  private static final ImmutablePageDTO INSTANCE = validate(new ImmutablePageDTO());

  /**
   * Returns the default immutable singleton value of {@code RawPage}
   * @return An immutable instance of RawPage
   */
  public static ImmutablePageDTO of() {
    return INSTANCE;
  }

  /**
   * Construct a new immutable {@code RawPage} instance.
   * @param cards The value for the {@code cards} attribute
   * @return An immutable RawPage instance
   */
  public static ImmutablePageDTO of(List<MagicCard> cards) {
    return of((Iterable<? extends MagicCard>) cards);
  }

  /**
   * Construct a new immutable {@code RawPage} instance.
   * @param cards The value for the {@code cards} attribute
   * @return An immutable RawPage instance
   */
  public static ImmutablePageDTO of(Iterable<? extends MagicCard> cards) {
    return validate(new ImmutablePageDTO(cards));
  }

  private static ImmutablePageDTO validate(ImmutablePageDTO instance) {
    return INSTANCE != null && INSTANCE.equalTo(instance) ? INSTANCE : instance;
  }

  /**
   * Creates an immutable copy of a {@link PageDTO} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RawPage instance
   */
  public static ImmutablePageDTO copyOf(PageDTO instance) {
    if (instance instanceof ImmutablePageDTO) {
      return (ImmutablePageDTO) instance;
    }
    return ImmutablePageDTO.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePageDTO ImmutableRawPage}.
   * <pre>
   * ImmutableRawPage.builder()
   *    .addCards|addAllCards(com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.RawCard) // {@link PageDTO#cards() cards} elements
   *    .build();
   * </pre>
   * @return A new ImmutableRawPage builder
   */
  public static ImmutablePageDTO.Builder builder() {
    return new ImmutablePageDTO.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePageDTO ImmutableRawPage}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "RawPage", generator = "Immutables")
  public static final class Builder {
    private List<MagicCard> cards = new ArrayList<MagicCard>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code RawPage} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PageDTO instance) {
      Objects.requireNonNull(instance, "instance");
      addAllCards(instance.cards());
      return this;
    }

    /**
     * Adds one element to {@link PageDTO#cards() cards} list.
     * @param element A cards element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCards(MagicCard element) {
      this.cards.add(Objects.requireNonNull(element, "cards element"));
      return this;
    }

    /**
     * Adds elements to {@link PageDTO#cards() cards} list.
     * @param elements An array of cards elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCards(MagicCard... elements) {
      for (MagicCard element : elements) {
        this.cards.add(Objects.requireNonNull(element, "cards element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link PageDTO#cards() cards} list.
     * @param elements An iterable of cards elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("cards")
    public final Builder cards(Iterable<? extends MagicCard> elements) {
      this.cards.clear();
      return addAllCards(elements);
    }

    /**
     * Adds elements to {@link PageDTO#cards() cards} list.
     * @param elements An iterable of cards elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllCards(Iterable<? extends MagicCard> elements) {
      for (MagicCard element : elements) {
        this.cards.add(Objects.requireNonNull(element, "cards element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutablePageDTO ImmutableRawPage}.
     * @return An immutable instance of RawPage
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePageDTO build() {
      return ImmutablePageDTO.validate(new ImmutablePageDTO(null, createUnmodifiableList(true, cards)));
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
