package com.digitalcocoa.mtg.client.organizer.client.mtgio;

import com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.RawCard;
import com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.RawPage;
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
 * Immutable implementation of {@link RawPage}.
 * <p>
 * Use the static factory method to create immutable instances:
 * {@code ImmutableRawPage.of()}.
 * Use the static factory method to get the default singleton instance:
 * {@code ImmutableRawPage.of()}.
 */
@Generated(from = "RawPage", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableRawPage implements RawPage {
  private final List<RawCard> cards;

  private ImmutableRawPage() {
    this.cards = Collections.emptyList();
  }

  private ImmutableRawPage(Iterable<? extends RawCard> cards) {
    this.cards = createUnmodifiableList(false, createSafeList(cards, true, false));
  }

  private ImmutableRawPage(
      ImmutableRawPage original,
      List<RawCard> cards) {
    this.cards = cards;
  }

  /**
   * @return The value of the {@code cards} attribute
   */
  @JsonProperty("cards")
  @Override
  public List<RawCard> cards() {
    return cards;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawPage#cards() cards}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawPage withCards(RawCard... elements) {
    List<RawCard> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return validate(new ImmutableRawPage(this, newValue));
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawPage#cards() cards}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of cards elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawPage withCards(Iterable<? extends RawCard> elements) {
    if (this.cards == elements) return this;
    List<RawCard> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return validate(new ImmutableRawPage(this, newValue));
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRawPage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableRawPage
        && equalTo((ImmutableRawPage) another);
  }

  private boolean equalTo(ImmutableRawPage another) {
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
  static final class Json implements RawPage {
    List<RawCard> cards = Collections.emptyList();
    @JsonProperty("cards")
    public void setCards(List<RawCard> cards) {
      this.cards = cards;
    }
    @Override
    public List<RawCard> cards() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableRawPage fromJson(Json json) {
    ImmutableRawPage instance = ImmutableRawPage.of(json.cards);
    return instance;
  }

  private static final ImmutableRawPage INSTANCE = validate(new ImmutableRawPage());

  /**
   * Returns the default immutable singleton value of {@code RawPage}
   * @return An immutable instance of RawPage
   */
  public static ImmutableRawPage of() {
    return INSTANCE;
  }

  /**
   * Construct a new immutable {@code RawPage} instance.
   * @param cards The value for the {@code cards} attribute
   * @return An immutable RawPage instance
   */
  public static ImmutableRawPage of(List<RawCard> cards) {
    return of((Iterable<? extends RawCard>) cards);
  }

  /**
   * Construct a new immutable {@code RawPage} instance.
   * @param cards The value for the {@code cards} attribute
   * @return An immutable RawPage instance
   */
  public static ImmutableRawPage of(Iterable<? extends RawCard> cards) {
    return validate(new ImmutableRawPage(cards));
  }

  private static ImmutableRawPage validate(ImmutableRawPage instance) {
    return INSTANCE != null && INSTANCE.equalTo(instance) ? INSTANCE : instance;
  }

  /**
   * Creates an immutable copy of a {@link RawPage} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RawPage instance
   */
  public static ImmutableRawPage copyOf(RawPage instance) {
    if (instance instanceof ImmutableRawPage) {
      return (ImmutableRawPage) instance;
    }
    return ImmutableRawPage.of(instance.cards());
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
