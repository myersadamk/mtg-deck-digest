package com.digitalcocoa.mtg.client.organizer.client.mtgio.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link RawCard}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableRawCard.builder()}.
 */
@Generated(from = "RawCard", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableRawCard implements RawCard {
  private final Long multiverseid;
  private final String name;
  private final List<String> names;
  private final String rarity;
  private final String set;
  private final String type;
  private final String manaCost;
  private final Integer cmc;
  private final Set<String> colorIdentity;
  private final Set<String> colors;
  private final Set<String> types;
  private final Set<String> supertypes;
  private final Set<String> subtypes;
  private final String text;

  private ImmutableRawCard(
      Long multiverseid,
      String name,
      List<String> names,
      String rarity,
      String set,
      String type,
      String manaCost,
      Integer cmc,
      Set<String> colorIdentity,
      Set<String> colors,
      Set<String> types,
      Set<String> supertypes,
      Set<String> subtypes,
      String text) {
    this.multiverseid = multiverseid;
    this.name = name;
    this.names = names;
    this.rarity = rarity;
    this.set = set;
    this.type = type;
    this.manaCost = manaCost;
    this.cmc = cmc;
    this.colorIdentity = colorIdentity;
    this.colors = colors;
    this.types = types;
    this.supertypes = supertypes;
    this.subtypes = subtypes;
    this.text = text;
  }

  /**
   * @return The value of the {@code multiverseid} attribute
   */
  @JsonProperty("multiverseid")
  @Override
  public Optional<Long> multiverseid() {
    return Optional.ofNullable(multiverseid);
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code names} attribute
   */
  @JsonProperty("names")
  @Override
  public List<String> names() {
    return names;
  }

  /**
   * @return The value of the {@code rarity} attribute
   */
  @JsonProperty("rarity")
  @Override
  public String rarity() {
    return rarity;
  }

  /**
   * @return The value of the {@code set} attribute
   */
  @JsonProperty("set")
  @Override
  public String set() {
    return set;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @JsonProperty("type")
  @Override
  public String type() {
    return type;
  }

  /**
   * @return The value of the {@code manaCost} attribute
   */
  @JsonProperty("manaCost")
  @Override
  public Optional<String> manaCost() {
    return Optional.ofNullable(manaCost);
  }

  /**
   * @return The value of the {@code cmc} attribute
   */
  @JsonProperty("cmc")
  @Override
  public Optional<Integer> cmc() {
    return Optional.ofNullable(cmc);
  }

  /**
   * @return The value of the {@code colorIdentity} attribute
   */
  @JsonProperty("colorIdentity")
  @Override
  public Set<String> colorIdentity() {
    return colorIdentity;
  }

  /**
   * @return The value of the {@code colors} attribute
   */
  @JsonProperty("colors")
  @Override
  public Set<String> colors() {
    return colors;
  }

  /**
   * @return The value of the {@code types} attribute
   */
  @JsonProperty("types")
  @Override
  public Set<String> types() {
    return types;
  }

  /**
   * @return The value of the {@code supertypes} attribute
   */
  @JsonProperty("supertypes")
  @Override
  public Set<String> supertypes() {
    return supertypes;
  }

  /**
   * @return The value of the {@code subtypes} attribute
   */
  @JsonProperty("subtypes")
  @Override
  public Set<String> subtypes() {
    return subtypes;
  }

  /**
   * @return The value of the {@code text} attribute
   */
  @JsonProperty("text")
  @Override
  public Optional<String> text() {
    return Optional.ofNullable(text);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link RawCard#multiverseid() multiverseid} attribute.
   * @param value The value for multiverseid
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withMultiverseid(long value) {
    Long newValue = value;
    if (Objects.equals(this.multiverseid, newValue)) return this;
    return new ImmutableRawCard(
        newValue,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link RawCard#multiverseid() multiverseid} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for multiverseid
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withMultiverseid(Optional<Long> optional) {
    Long value = optional.orElse(null);
    if (Objects.equals(this.multiverseid, value)) return this;
    return new ImmutableRawCard(
        value,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RawCard#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRawCard withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableRawCard(
        this.multiverseid,
        newValue,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#names() names}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withNames(String... elements) {
    List<String> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        newValue,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#names() names}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of names elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withNames(Iterable<String> elements) {
    if (this.names == elements) return this;
    List<String> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        newValue,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RawCard#rarity() rarity} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for rarity
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRawCard withRarity(String value) {
    String newValue = Objects.requireNonNull(value, "rarity");
    if (this.rarity.equals(newValue)) return this;
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        newValue,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RawCard#set() set} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for set
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRawCard withSet(String value) {
    String newValue = Objects.requireNonNull(value, "set");
    if (this.set.equals(newValue)) return this;
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        newValue,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RawCard#type() type} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRawCard withType(String value) {
    String newValue = Objects.requireNonNull(value, "type");
    if (this.type.equals(newValue)) return this;
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        newValue,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link RawCard#manaCost() manaCost} attribute.
   * @param value The value for manaCost
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withManaCost(String value) {
    String newValue = Objects.requireNonNull(value, "manaCost");
    if (Objects.equals(this.manaCost, newValue)) return this;
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        newValue,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link RawCard#manaCost() manaCost} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for manaCost
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withManaCost(Optional<String> optional) {
    String value = optional.orElse(null);
    if (Objects.equals(this.manaCost, value)) return this;
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        value,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link RawCard#cmc() cmc} attribute.
   * @param value The value for cmc
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withCmc(int value) {
    Integer newValue = value;
    if (Objects.equals(this.cmc, newValue)) return this;
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        newValue,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link RawCard#cmc() cmc} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for cmc
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withCmc(Optional<Integer> optional) {
    Integer value = optional.orElse(null);
    if (Objects.equals(this.cmc, value)) return this;
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        value,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#colorIdentity() colorIdentity}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withColorIdentity(String... elements) {
    Set<String> newValue = createUnmodifiableSet(createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        newValue,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#colorIdentity() colorIdentity}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of colorIdentity elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withColorIdentity(Iterable<String> elements) {
    if (this.colorIdentity == elements) return this;
    Set<String> newValue = createUnmodifiableSet(createSafeList(elements, true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        newValue,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#colors() colors}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withColors(String... elements) {
    Set<String> newValue = createUnmodifiableSet(createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        newValue,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#colors() colors}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of colors elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withColors(Iterable<String> elements) {
    if (this.colors == elements) return this;
    Set<String> newValue = createUnmodifiableSet(createSafeList(elements, true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        newValue,
        this.types,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#types() types}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withTypes(String... elements) {
    Set<String> newValue = createUnmodifiableSet(createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        newValue,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#types() types}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of types elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withTypes(Iterable<String> elements) {
    if (this.types == elements) return this;
    Set<String> newValue = createUnmodifiableSet(createSafeList(elements, true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        newValue,
        this.supertypes,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#supertypes() supertypes}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withSupertypes(String... elements) {
    Set<String> newValue = createUnmodifiableSet(createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        newValue,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#supertypes() supertypes}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of supertypes elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withSupertypes(Iterable<String> elements) {
    if (this.supertypes == elements) return this;
    Set<String> newValue = createUnmodifiableSet(createSafeList(elements, true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        newValue,
        this.subtypes,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#subtypes() subtypes}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withSubtypes(String... elements) {
    Set<String> newValue = createUnmodifiableSet(createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        newValue,
        this.text);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RawCard#subtypes() subtypes}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of subtypes elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withSubtypes(Iterable<String> elements) {
    if (this.subtypes == elements) return this;
    Set<String> newValue = createUnmodifiableSet(createSafeList(elements, true, false));
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        newValue,
        this.text);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link RawCard#text() text} attribute.
   * @param value The value for text
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withText(String value) {
    String newValue = Objects.requireNonNull(value, "text");
    if (Objects.equals(this.text, newValue)) return this;
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link RawCard#text() text} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for text
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRawCard withText(Optional<String> optional) {
    String value = optional.orElse(null);
    if (Objects.equals(this.text, value)) return this;
    return new ImmutableRawCard(
        this.multiverseid,
        this.name,
        this.names,
        this.rarity,
        this.set,
        this.type,
        this.manaCost,
        this.cmc,
        this.colorIdentity,
        this.colors,
        this.types,
        this.supertypes,
        this.subtypes,
        value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRawCard} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableRawCard
        && equalTo((ImmutableRawCard) another);
  }

  private boolean equalTo(ImmutableRawCard another) {
    return Objects.equals(multiverseid, another.multiverseid)
        && name.equals(another.name)
        && names.equals(another.names)
        && rarity.equals(another.rarity)
        && set.equals(another.set)
        && type.equals(another.type)
        && Objects.equals(manaCost, another.manaCost)
        && Objects.equals(cmc, another.cmc)
        && colorIdentity.equals(another.colorIdentity)
        && colors.equals(another.colors)
        && types.equals(another.types)
        && supertypes.equals(another.supertypes)
        && subtypes.equals(another.subtypes)
        && Objects.equals(text, another.text);
  }

  /**
   * Computes a hash code from attributes: {@code multiverseid}, {@code name}, {@code names}, {@code rarity}, {@code set}, {@code type}, {@code manaCost}, {@code cmc}, {@code colorIdentity}, {@code colors}, {@code types}, {@code supertypes}, {@code subtypes}, {@code text}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(multiverseid);
    h += (h << 5) + name.hashCode();
    h += (h << 5) + names.hashCode();
    h += (h << 5) + rarity.hashCode();
    h += (h << 5) + set.hashCode();
    h += (h << 5) + type.hashCode();
    h += (h << 5) + Objects.hashCode(manaCost);
    h += (h << 5) + Objects.hashCode(cmc);
    h += (h << 5) + colorIdentity.hashCode();
    h += (h << 5) + colors.hashCode();
    h += (h << 5) + types.hashCode();
    h += (h << 5) + supertypes.hashCode();
    h += (h << 5) + subtypes.hashCode();
    h += (h << 5) + Objects.hashCode(text);
    return h;
  }

  /**
   * Prints the immutable value {@code RawCard} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("RawCard{");
    if (multiverseid != null) {
      builder.append("multiverseid=").append(multiverseid);
    }
    if (builder.length() > 8) builder.append(", ");
    builder.append("name=").append(name);
    builder.append(", ");
    builder.append("names=").append(names);
    builder.append(", ");
    builder.append("rarity=").append(rarity);
    builder.append(", ");
    builder.append("set=").append(set);
    builder.append(", ");
    builder.append("type=").append(type);
    if (manaCost != null) {
      builder.append(", ");
      builder.append("manaCost=").append(manaCost);
    }
    if (cmc != null) {
      builder.append(", ");
      builder.append("cmc=").append(cmc);
    }
    builder.append(", ");
    builder.append("colorIdentity=").append(colorIdentity);
    builder.append(", ");
    builder.append("colors=").append(colors);
    builder.append(", ");
    builder.append("types=").append(types);
    builder.append(", ");
    builder.append("supertypes=").append(supertypes);
    builder.append(", ");
    builder.append("subtypes=").append(subtypes);
    if (text != null) {
      builder.append(", ");
      builder.append("text=").append(text);
    }
    return builder.append("}").toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "RawCard", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements RawCard {
    Optional<Long> multiverseid = Optional.empty();
    String name;
    List<String> names = Collections.emptyList();
    String rarity;
    String set;
    String type;
    Optional<String> manaCost = Optional.empty();
    Optional<Integer> cmc = Optional.empty();
    Set<String> colorIdentity = Collections.emptySet();
    Set<String> colors = Collections.emptySet();
    Set<String> types = Collections.emptySet();
    Set<String> supertypes = Collections.emptySet();
    Set<String> subtypes = Collections.emptySet();
    Optional<String> text = Optional.empty();
    @JsonProperty("multiverseid")
    public void setMultiverseid(Optional<Long> multiverseid) {
      this.multiverseid = multiverseid;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("names")
    public void setNames(List<String> names) {
      this.names = names;
    }
    @JsonProperty("rarity")
    public void setRarity(String rarity) {
      this.rarity = rarity;
    }
    @JsonProperty("set")
    public void setSet(String set) {
      this.set = set;
    }
    @JsonProperty("type")
    public void setType(String type) {
      this.type = type;
    }
    @JsonProperty("manaCost")
    public void setManaCost(Optional<String> manaCost) {
      this.manaCost = manaCost;
    }
    @JsonProperty("cmc")
    public void setCmc(Optional<Integer> cmc) {
      this.cmc = cmc;
    }
    @JsonProperty("colorIdentity")
    public void setColorIdentity(Set<String> colorIdentity) {
      this.colorIdentity = colorIdentity;
    }
    @JsonProperty("colors")
    public void setColors(Set<String> colors) {
      this.colors = colors;
    }
    @JsonProperty("types")
    public void setTypes(Set<String> types) {
      this.types = types;
    }
    @JsonProperty("supertypes")
    public void setSupertypes(Set<String> supertypes) {
      this.supertypes = supertypes;
    }
    @JsonProperty("subtypes")
    public void setSubtypes(Set<String> subtypes) {
      this.subtypes = subtypes;
    }
    @JsonProperty("text")
    public void setText(Optional<String> text) {
      this.text = text;
    }
    @Override
    public Optional<Long> multiverseid() { throw new UnsupportedOperationException(); }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> names() { throw new UnsupportedOperationException(); }
    @Override
    public String rarity() { throw new UnsupportedOperationException(); }
    @Override
    public String set() { throw new UnsupportedOperationException(); }
    @Override
    public String type() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> manaCost() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Integer> cmc() { throw new UnsupportedOperationException(); }
    @Override
    public Set<String> colorIdentity() { throw new UnsupportedOperationException(); }
    @Override
    public Set<String> colors() { throw new UnsupportedOperationException(); }
    @Override
    public Set<String> types() { throw new UnsupportedOperationException(); }
    @Override
    public Set<String> supertypes() { throw new UnsupportedOperationException(); }
    @Override
    public Set<String> subtypes() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> text() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableRawCard fromJson(Json json) {
    ImmutableRawCard.Builder builder = ImmutableRawCard.builder();
    if (json.multiverseid != null) {
      builder.multiverseid(json.multiverseid);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.names != null) {
      builder.addAllNames(json.names);
    }
    if (json.rarity != null) {
      builder.rarity(json.rarity);
    }
    if (json.set != null) {
      builder.set(json.set);
    }
    if (json.type != null) {
      builder.type(json.type);
    }
    if (json.manaCost != null) {
      builder.manaCost(json.manaCost);
    }
    if (json.cmc != null) {
      builder.cmc(json.cmc);
    }
    if (json.colorIdentity != null) {
      builder.addAllColorIdentity(json.colorIdentity);
    }
    if (json.colors != null) {
      builder.addAllColors(json.colors);
    }
    if (json.types != null) {
      builder.addAllTypes(json.types);
    }
    if (json.supertypes != null) {
      builder.addAllSupertypes(json.supertypes);
    }
    if (json.subtypes != null) {
      builder.addAllSubtypes(json.subtypes);
    }
    if (json.text != null) {
      builder.text(json.text);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link RawCard} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RawCard instance
   */
  public static ImmutableRawCard copyOf(RawCard instance) {
    if (instance instanceof ImmutableRawCard) {
      return (ImmutableRawCard) instance;
    }
    return ImmutableRawCard.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableRawCard ImmutableRawCard}.
   * <pre>
   * ImmutableRawCard.builder()
   *    .multiverseid(Long) // optional {@link RawCard#multiverseid() multiverseid}
   *    .name(String) // required {@link RawCard#name() name}
   *    .addNames|addAllNames(String) // {@link RawCard#names() names} elements
   *    .rarity(String) // required {@link RawCard#rarity() rarity}
   *    .set(String) // required {@link RawCard#set() set}
   *    .type(String) // required {@link RawCard#type() type}
   *    .manaCost(String) // optional {@link RawCard#manaCost() manaCost}
   *    .cmc(Integer) // optional {@link RawCard#cmc() cmc}
   *    .addColorIdentity|addAllColorIdentity(String) // {@link RawCard#colorIdentity() colorIdentity} elements
   *    .addColors|addAllColors(String) // {@link RawCard#colors() colors} elements
   *    .addTypes|addAllTypes(String) // {@link RawCard#types() types} elements
   *    .addSupertypes|addAllSupertypes(String) // {@link RawCard#supertypes() supertypes} elements
   *    .addSubtypes|addAllSubtypes(String) // {@link RawCard#subtypes() subtypes} elements
   *    .text(String) // optional {@link RawCard#text() text}
   *    .build();
   * </pre>
   * @return A new ImmutableRawCard builder
   */
  public static ImmutableRawCard.Builder builder() {
    return new ImmutableRawCard.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableRawCard ImmutableRawCard}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "RawCard", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_RARITY = 0x2L;
    private static final long INIT_BIT_SET = 0x4L;
    private static final long INIT_BIT_TYPE = 0x8L;
    private long initBits = 0xfL;

    private Long multiverseid;
    private String name;
    private List<String> names = new ArrayList<String>();
    private String rarity;
    private String set;
    private String type;
    private String manaCost;
    private Integer cmc;
    private List<String> colorIdentity = new ArrayList<String>();
    private List<String> colors = new ArrayList<String>();
    private List<String> types = new ArrayList<String>();
    private List<String> supertypes = new ArrayList<String>();
    private List<String> subtypes = new ArrayList<String>();
    private String text;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code RawCard} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(RawCard instance) {
      Objects.requireNonNull(instance, "instance");
      Optional<Long> multiverseidOptional = instance.multiverseid();
      if (multiverseidOptional.isPresent()) {
        multiverseid(multiverseidOptional);
      }
      name(instance.name());
      addAllNames(instance.names());
      rarity(instance.rarity());
      set(instance.set());
      type(instance.type());
      Optional<String> manaCostOptional = instance.manaCost();
      if (manaCostOptional.isPresent()) {
        manaCost(manaCostOptional);
      }
      Optional<Integer> cmcOptional = instance.cmc();
      if (cmcOptional.isPresent()) {
        cmc(cmcOptional);
      }
      addAllColorIdentity(instance.colorIdentity());
      addAllColors(instance.colors());
      addAllTypes(instance.types());
      addAllSupertypes(instance.supertypes());
      addAllSubtypes(instance.subtypes());
      Optional<String> textOptional = instance.text();
      if (textOptional.isPresent()) {
        text(textOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link RawCard#multiverseid() multiverseid} to multiverseid.
     * @param multiverseid The value for multiverseid
     * @return {@code this} builder for chained invocation
     */
    public final Builder multiverseid(long multiverseid) {
      this.multiverseid = multiverseid;
      return this;
    }

    /**
     * Initializes the optional value {@link RawCard#multiverseid() multiverseid} to multiverseid.
     * @param multiverseid The value for multiverseid
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("multiverseid")
    public final Builder multiverseid(Optional<Long> multiverseid) {
      this.multiverseid = multiverseid.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link RawCard#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Adds one element to {@link RawCard#names() names} list.
     * @param element A names element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addNames(String element) {
      this.names.add(Objects.requireNonNull(element, "names element"));
      return this;
    }

    /**
     * Adds elements to {@link RawCard#names() names} list.
     * @param elements An array of names elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addNames(String... elements) {
      for (String element : elements) {
        this.names.add(Objects.requireNonNull(element, "names element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link RawCard#names() names} list.
     * @param elements An iterable of names elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("names")
    public final Builder names(Iterable<String> elements) {
      this.names.clear();
      return addAllNames(elements);
    }

    /**
     * Adds elements to {@link RawCard#names() names} list.
     * @param elements An iterable of names elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllNames(Iterable<String> elements) {
      for (String element : elements) {
        this.names.add(Objects.requireNonNull(element, "names element"));
      }
      return this;
    }

    /**
     * Initializes the value for the {@link RawCard#rarity() rarity} attribute.
     * @param rarity The value for rarity 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("rarity")
    public final Builder rarity(String rarity) {
      this.rarity = Objects.requireNonNull(rarity, "rarity");
      initBits &= ~INIT_BIT_RARITY;
      return this;
    }

    /**
     * Initializes the value for the {@link RawCard#set() set} attribute.
     * @param set The value for set 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("set")
    public final Builder set(String set) {
      this.set = Objects.requireNonNull(set, "set");
      initBits &= ~INIT_BIT_SET;
      return this;
    }

    /**
     * Initializes the value for the {@link RawCard#type() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("type")
    public final Builder type(String type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the optional value {@link RawCard#manaCost() manaCost} to manaCost.
     * @param manaCost The value for manaCost
     * @return {@code this} builder for chained invocation
     */
    public final Builder manaCost(String manaCost) {
      this.manaCost = Objects.requireNonNull(manaCost, "manaCost");
      return this;
    }

    /**
     * Initializes the optional value {@link RawCard#manaCost() manaCost} to manaCost.
     * @param manaCost The value for manaCost
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("manaCost")
    public final Builder manaCost(Optional<String> manaCost) {
      this.manaCost = manaCost.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link RawCard#cmc() cmc} to cmc.
     * @param cmc The value for cmc
     * @return {@code this} builder for chained invocation
     */
    public final Builder cmc(int cmc) {
      this.cmc = cmc;
      return this;
    }

    /**
     * Initializes the optional value {@link RawCard#cmc() cmc} to cmc.
     * @param cmc The value for cmc
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("cmc")
    public final Builder cmc(Optional<Integer> cmc) {
      this.cmc = cmc.orElse(null);
      return this;
    }

    /**
     * Adds one element to {@link RawCard#colorIdentity() colorIdentity} set.
     * @param element A colorIdentity element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addColorIdentity(String element) {
      this.colorIdentity.add(Objects.requireNonNull(element, "colorIdentity element"));
      return this;
    }

    /**
     * Adds elements to {@link RawCard#colorIdentity() colorIdentity} set.
     * @param elements An array of colorIdentity elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addColorIdentity(String... elements) {
      for (String element : elements) {
        this.colorIdentity.add(Objects.requireNonNull(element, "colorIdentity element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link RawCard#colorIdentity() colorIdentity} set.
     * @param elements An iterable of colorIdentity elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("colorIdentity")
    public final Builder colorIdentity(Iterable<String> elements) {
      this.colorIdentity.clear();
      return addAllColorIdentity(elements);
    }

    /**
     * Adds elements to {@link RawCard#colorIdentity() colorIdentity} set.
     * @param elements An iterable of colorIdentity elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllColorIdentity(Iterable<String> elements) {
      for (String element : elements) {
        this.colorIdentity.add(Objects.requireNonNull(element, "colorIdentity element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link RawCard#colors() colors} set.
     * @param element A colors element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addColors(String element) {
      this.colors.add(Objects.requireNonNull(element, "colors element"));
      return this;
    }

    /**
     * Adds elements to {@link RawCard#colors() colors} set.
     * @param elements An array of colors elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addColors(String... elements) {
      for (String element : elements) {
        this.colors.add(Objects.requireNonNull(element, "colors element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link RawCard#colors() colors} set.
     * @param elements An iterable of colors elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("colors")
    public final Builder colors(Iterable<String> elements) {
      this.colors.clear();
      return addAllColors(elements);
    }

    /**
     * Adds elements to {@link RawCard#colors() colors} set.
     * @param elements An iterable of colors elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllColors(Iterable<String> elements) {
      for (String element : elements) {
        this.colors.add(Objects.requireNonNull(element, "colors element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link RawCard#types() types} set.
     * @param element A types element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addTypes(String element) {
      this.types.add(Objects.requireNonNull(element, "types element"));
      return this;
    }

    /**
     * Adds elements to {@link RawCard#types() types} set.
     * @param elements An array of types elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addTypes(String... elements) {
      for (String element : elements) {
        this.types.add(Objects.requireNonNull(element, "types element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link RawCard#types() types} set.
     * @param elements An iterable of types elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("types")
    public final Builder types(Iterable<String> elements) {
      this.types.clear();
      return addAllTypes(elements);
    }

    /**
     * Adds elements to {@link RawCard#types() types} set.
     * @param elements An iterable of types elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllTypes(Iterable<String> elements) {
      for (String element : elements) {
        this.types.add(Objects.requireNonNull(element, "types element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link RawCard#supertypes() supertypes} set.
     * @param element A supertypes element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSupertypes(String element) {
      this.supertypes.add(Objects.requireNonNull(element, "supertypes element"));
      return this;
    }

    /**
     * Adds elements to {@link RawCard#supertypes() supertypes} set.
     * @param elements An array of supertypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSupertypes(String... elements) {
      for (String element : elements) {
        this.supertypes.add(Objects.requireNonNull(element, "supertypes element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link RawCard#supertypes() supertypes} set.
     * @param elements An iterable of supertypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("supertypes")
    public final Builder supertypes(Iterable<String> elements) {
      this.supertypes.clear();
      return addAllSupertypes(elements);
    }

    /**
     * Adds elements to {@link RawCard#supertypes() supertypes} set.
     * @param elements An iterable of supertypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSupertypes(Iterable<String> elements) {
      for (String element : elements) {
        this.supertypes.add(Objects.requireNonNull(element, "supertypes element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link RawCard#subtypes() subtypes} set.
     * @param element A subtypes element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSubtypes(String element) {
      this.subtypes.add(Objects.requireNonNull(element, "subtypes element"));
      return this;
    }

    /**
     * Adds elements to {@link RawCard#subtypes() subtypes} set.
     * @param elements An array of subtypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSubtypes(String... elements) {
      for (String element : elements) {
        this.subtypes.add(Objects.requireNonNull(element, "subtypes element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link RawCard#subtypes() subtypes} set.
     * @param elements An iterable of subtypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("subtypes")
    public final Builder subtypes(Iterable<String> elements) {
      this.subtypes.clear();
      return addAllSubtypes(elements);
    }

    /**
     * Adds elements to {@link RawCard#subtypes() subtypes} set.
     * @param elements An iterable of subtypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSubtypes(Iterable<String> elements) {
      for (String element : elements) {
        this.subtypes.add(Objects.requireNonNull(element, "subtypes element"));
      }
      return this;
    }

    /**
     * Initializes the optional value {@link RawCard#text() text} to text.
     * @param text The value for text
     * @return {@code this} builder for chained invocation
     */
    public final Builder text(String text) {
      this.text = Objects.requireNonNull(text, "text");
      return this;
    }

    /**
     * Initializes the optional value {@link RawCard#text() text} to text.
     * @param text The value for text
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("text")
    public final Builder text(Optional<String> text) {
      this.text = text.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableRawCard ImmutableRawCard}.
     * @return An immutable instance of RawCard
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableRawCard build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableRawCard(
          multiverseid,
          name,
          createUnmodifiableList(true, names),
          rarity,
          set,
          type,
          manaCost,
          cmc,
          createUnmodifiableSet(colorIdentity),
          createUnmodifiableSet(colors),
          createUnmodifiableSet(types),
          createUnmodifiableSet(supertypes),
          createUnmodifiableSet(subtypes),
          text);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_RARITY) != 0) attributes.add("rarity");
      if ((initBits & INIT_BIT_SET) != 0) attributes.add("set");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      return "Cannot build RawCard, some of required attributes are not set " + attributes;
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

  /** Unmodifiable set constructed from list to avoid rehashing. */
  private static <T> Set<T> createUnmodifiableSet(List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptySet();
    case 1: return Collections.singleton(list.get(0));
    default:
      Set<T> set = new LinkedHashSet<>(list.size());
      set.addAll(list);
      return Collections.unmodifiableSet(set);
    }
  }
}
