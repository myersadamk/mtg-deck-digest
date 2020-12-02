package com.digitalcocoa.mtg.client.organizer.client.mtgio.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PageDTO}.
 * <p>
 * Use the static factory method to create immutable instances:
 * {@code ImmutablePageDTO.of()}.
 * Use the static factory method to get the default singleton instance:
 * {@code ImmutablePageDTO.of()}.
 */
@Generated(from = "PageDTO", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
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
   * This instance is equal to all instances of {@code ImmutablePageDTO} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
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
    @Var int h = 5381;
    h += (h << 5) + cards.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PageDTO} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PageDTO{"
        + "cards=" + cards
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PageDTO", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements PageDTO {
    @Nullable List<MagicCard> cards = Collections.emptyList();
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
    ImmutablePageDTO instance = ImmutablePageDTO.of(json.cards);
    return instance;
  }

  private static final ImmutablePageDTO INSTANCE = validate(new ImmutablePageDTO());

  /**
   * Returns the default immutable singleton value of {@code PageDTO}
   * @return An immutable instance of PageDTO
   */
  public static ImmutablePageDTO of() {
    return INSTANCE;
  }

  /**
   * Construct a new immutable {@code PageDTO} instance.
   * @param cards The value for the {@code cards} attribute
   * @return An immutable PageDTO instance
   */
  public static ImmutablePageDTO of(List<MagicCard> cards) {
    return of((Iterable<? extends MagicCard>) cards);
  }

  /**
   * Construct a new immutable {@code PageDTO} instance.
   * @param cards The value for the {@code cards} attribute
   * @return An immutable PageDTO instance
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
   * @return A copied immutable PageDTO instance
   */
  public static ImmutablePageDTO copyOf(PageDTO instance) {
    if (instance instanceof ImmutablePageDTO) {
      return (ImmutablePageDTO) instance;
    }
    return ImmutablePageDTO.of(instance.cards());
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
