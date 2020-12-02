package com.digitalcocoa.mtg.client.organizer.client.mtgio.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link MagicCard}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableMagicCard.builder()}.
 */
@Generated(from = "MagicCard", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableMagicCard
    implements MagicCard {
  private final @Nullable Long multiverseid;
  private final String name;
  private final ImmutableList<String> names;
  private final String rarity;
  private final String set;
  private final String type;
  private final @Nullable String manaCost;
  private final @Nullable Integer cmc;
  private final ImmutableSet<String> colorIdentity;
  private final ImmutableSet<String> colors;
  private final ImmutableSet<String> types;
  private final ImmutableSet<String> supertypes;
  private final ImmutableSet<String> subtypes;
  private final @Nullable String text;

  private ImmutableMagicCard(
      @Nullable Long multiverseid,
      String name,
      ImmutableList<String> names,
      String rarity,
      String set,
      String type,
      @Nullable String manaCost,
      @Nullable Integer cmc,
      ImmutableSet<String> colorIdentity,
      ImmutableSet<String> colors,
      ImmutableSet<String> types,
      ImmutableSet<String> supertypes,
      ImmutableSet<String> subtypes,
      @Nullable String text) {
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
  public ImmutableList<String> names() {
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
  public ImmutableSet<String> colorIdentity() {
    return colorIdentity;
  }

  /**
   * @return The value of the {@code colors} attribute
   */
  @JsonProperty("colors")
  @Override
  public ImmutableSet<String> colors() {
    return colors;
  }

  /**
   * @return The value of the {@code types} attribute
   */
  @JsonProperty("types")
  @Override
  public ImmutableSet<String> types() {
    return types;
  }

  /**
   * @return The value of the {@code supertypes} attribute
   */
  @JsonProperty("supertypes")
  @Override
  public ImmutableSet<String> supertypes() {
    return supertypes;
  }

  /**
   * @return The value of the {@code subtypes} attribute
   */
  @JsonProperty("subtypes")
  @Override
  public ImmutableSet<String> subtypes() {
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
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link MagicCard#multiverseid() multiverseid} attribute.
   * @param value The value for multiverseid
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withMultiverseid(long value) {
    @Nullable Long newValue = value;
    if (Objects.equals(this.multiverseid, newValue)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting an optional value for the {@link MagicCard#multiverseid() multiverseid} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for multiverseid
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withMultiverseid(Optional<Long> optional) {
    @Nullable Long value = optional.orElse(null);
    if (Objects.equals(this.multiverseid, value)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting a value for the {@link MagicCard#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMagicCard withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#names() names}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withNames(String... elements) {
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#names() names}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of names elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withNames(Iterable<String> elements) {
    if (this.names == elements) return this;
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting a value for the {@link MagicCard#rarity() rarity} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for rarity
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMagicCard withRarity(String value) {
    String newValue = Objects.requireNonNull(value, "rarity");
    if (this.rarity.equals(newValue)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting a value for the {@link MagicCard#set() set} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for set
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMagicCard withSet(String value) {
    String newValue = Objects.requireNonNull(value, "set");
    if (this.set.equals(newValue)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting a value for the {@link MagicCard#type() type} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableMagicCard withType(String value) {
    String newValue = Objects.requireNonNull(value, "type");
    if (this.type.equals(newValue)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link MagicCard#manaCost() manaCost} attribute.
   * @param value The value for manaCost
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withManaCost(String value) {
    @Nullable String newValue = Objects.requireNonNull(value, "manaCost");
    if (Objects.equals(this.manaCost, newValue)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting an optional value for the {@link MagicCard#manaCost() manaCost} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for manaCost
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withManaCost(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equals(this.manaCost, value)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link MagicCard#cmc() cmc} attribute.
   * @param value The value for cmc
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withCmc(int value) {
    @Nullable Integer newValue = value;
    if (Objects.equals(this.cmc, newValue)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting an optional value for the {@link MagicCard#cmc() cmc} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for cmc
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withCmc(Optional<Integer> optional) {
    @Nullable Integer value = optional.orElse(null);
    if (Objects.equals(this.cmc, value)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#colorIdentity() colorIdentity}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withColorIdentity(String... elements) {
    ImmutableSet<String> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#colorIdentity() colorIdentity}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of colorIdentity elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withColorIdentity(Iterable<String> elements) {
    if (this.colorIdentity == elements) return this;
    ImmutableSet<String> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#colors() colors}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withColors(String... elements) {
    ImmutableSet<String> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#colors() colors}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of colors elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withColors(Iterable<String> elements) {
    if (this.colors == elements) return this;
    ImmutableSet<String> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#types() types}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withTypes(String... elements) {
    ImmutableSet<String> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#types() types}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of types elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withTypes(Iterable<String> elements) {
    if (this.types == elements) return this;
    ImmutableSet<String> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#supertypes() supertypes}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withSupertypes(String... elements) {
    ImmutableSet<String> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#supertypes() supertypes}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of supertypes elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withSupertypes(Iterable<String> elements) {
    if (this.supertypes == elements) return this;
    ImmutableSet<String> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#subtypes() subtypes}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withSubtypes(String... elements) {
    ImmutableSet<String> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object with elements that replace the content of {@link MagicCard#subtypes() subtypes}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of subtypes elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withSubtypes(Iterable<String> elements) {
    if (this.subtypes == elements) return this;
    ImmutableSet<String> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link MagicCard#text() text} attribute.
   * @param value The value for text
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withText(String value) {
    @Nullable String newValue = Objects.requireNonNull(value, "text");
    if (Objects.equals(this.text, newValue)) return this;
    return new ImmutableMagicCard(
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
   * Copy the current immutable object by setting an optional value for the {@link MagicCard#text() text} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for text
   * @return A modified copy of {@code this} object
   */
  public final ImmutableMagicCard withText(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equals(this.text, value)) return this;
    return new ImmutableMagicCard(
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
   * This instance is equal to all instances of {@code ImmutableMagicCard} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableMagicCard
        && equalTo((ImmutableMagicCard) another);
  }

  private boolean equalTo(ImmutableMagicCard another) {
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
    @Var int h = 5381;
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
   * Prints the immutable value {@code MagicCard} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("MagicCard")
        .omitNullValues()
        .add("multiverseid", multiverseid)
        .add("name", name)
        .add("names", names)
        .add("rarity", rarity)
        .add("set", set)
        .add("type", type)
        .add("manaCost", manaCost)
        .add("cmc", cmc)
        .add("colorIdentity", colorIdentity)
        .add("colors", colors)
        .add("types", types)
        .add("supertypes", supertypes)
        .add("subtypes", subtypes)
        .add("text", text)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "MagicCard", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements MagicCard {
    @Nullable Optional<Long> multiverseid = Optional.empty();
    @Nullable String name;
    @Nullable List<String> names = ImmutableList.of();
    @Nullable String rarity;
    @Nullable String set;
    @Nullable String type;
    @Nullable Optional<String> manaCost = Optional.empty();
    @Nullable Optional<Integer> cmc = Optional.empty();
    @Nullable Set<String> colorIdentity = ImmutableSet.of();
    @Nullable Set<String> colors = ImmutableSet.of();
    @Nullable Set<String> types = ImmutableSet.of();
    @Nullable Set<String> supertypes = ImmutableSet.of();
    @Nullable Set<String> subtypes = ImmutableSet.of();
    @Nullable Optional<String> text = Optional.empty();
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
  static ImmutableMagicCard fromJson(Json json) {
    ImmutableMagicCard.Builder builder = ImmutableMagicCard.builder();
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
   * Creates an immutable copy of a {@link MagicCard} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable MagicCard instance
   */
  public static ImmutableMagicCard copyOf(MagicCard instance) {
    if (instance instanceof ImmutableMagicCard) {
      return (ImmutableMagicCard) instance;
    }
    return ImmutableMagicCard.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableMagicCard ImmutableMagicCard}.
   * <pre>
   * ImmutableMagicCard.builder()
   *    .multiverseid(Long) // optional {@link MagicCard#multiverseid() multiverseid}
   *    .name(String) // required {@link MagicCard#name() name}
   *    .addNames|addAllNames(String) // {@link MagicCard#names() names} elements
   *    .rarity(String) // required {@link MagicCard#rarity() rarity}
   *    .set(String) // required {@link MagicCard#set() set}
   *    .type(String) // required {@link MagicCard#type() type}
   *    .manaCost(String) // optional {@link MagicCard#manaCost() manaCost}
   *    .cmc(Integer) // optional {@link MagicCard#cmc() cmc}
   *    .addColorIdentity|addAllColorIdentity(String) // {@link MagicCard#colorIdentity() colorIdentity} elements
   *    .addColors|addAllColors(String) // {@link MagicCard#colors() colors} elements
   *    .addTypes|addAllTypes(String) // {@link MagicCard#types() types} elements
   *    .addSupertypes|addAllSupertypes(String) // {@link MagicCard#supertypes() supertypes} elements
   *    .addSubtypes|addAllSubtypes(String) // {@link MagicCard#subtypes() subtypes} elements
   *    .text(String) // optional {@link MagicCard#text() text}
   *    .build();
   * </pre>
   * @return A new ImmutableMagicCard builder
   */
  public static ImmutableMagicCard.Builder builder() {
    return new ImmutableMagicCard.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableMagicCard ImmutableMagicCard}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "MagicCard", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_RARITY = 0x2L;
    private static final long INIT_BIT_SET = 0x4L;
    private static final long INIT_BIT_TYPE = 0x8L;
    private long initBits = 0xfL;

    private @Nullable Long multiverseid;
    private @Nullable String name;
    private ImmutableList.Builder<String> names = ImmutableList.builder();
    private @Nullable String rarity;
    private @Nullable String set;
    private @Nullable String type;
    private @Nullable String manaCost;
    private @Nullable Integer cmc;
    private ImmutableSet.Builder<String> colorIdentity = ImmutableSet.builder();
    private ImmutableSet.Builder<String> colors = ImmutableSet.builder();
    private ImmutableSet.Builder<String> types = ImmutableSet.builder();
    private ImmutableSet.Builder<String> supertypes = ImmutableSet.builder();
    private ImmutableSet.Builder<String> subtypes = ImmutableSet.builder();
    private @Nullable String text;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code MagicCard} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(MagicCard instance) {
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
     * Initializes the optional value {@link MagicCard#multiverseid() multiverseid} to multiverseid.
     * @param multiverseid The value for multiverseid
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder multiverseid(long multiverseid) {
      this.multiverseid = multiverseid;
      return this;
    }

    /**
     * Initializes the optional value {@link MagicCard#multiverseid() multiverseid} to multiverseid.
     * @param multiverseid The value for multiverseid
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("multiverseid")
    public final Builder multiverseid(Optional<Long> multiverseid) {
      this.multiverseid = multiverseid.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link MagicCard#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("name")
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Adds one element to {@link MagicCard#names() names} list.
     * @param element A names element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addNames(String element) {
      this.names.add(element);
      return this;
    }

    /**
     * Adds elements to {@link MagicCard#names() names} list.
     * @param elements An array of names elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addNames(String... elements) {
      this.names.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link MagicCard#names() names} list.
     * @param elements An iterable of names elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("names")
    public final Builder names(Iterable<String> elements) {
      this.names = ImmutableList.builder();
      return addAllNames(elements);
    }

    /**
     * Adds elements to {@link MagicCard#names() names} list.
     * @param elements An iterable of names elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllNames(Iterable<String> elements) {
      this.names.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link MagicCard#rarity() rarity} attribute.
     * @param rarity The value for rarity 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("rarity")
    public final Builder rarity(String rarity) {
      this.rarity = Objects.requireNonNull(rarity, "rarity");
      initBits &= ~INIT_BIT_RARITY;
      return this;
    }

    /**
     * Initializes the value for the {@link MagicCard#set() set} attribute.
     * @param set The value for set 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("set")
    public final Builder set(String set) {
      this.set = Objects.requireNonNull(set, "set");
      initBits &= ~INIT_BIT_SET;
      return this;
    }

    /**
     * Initializes the value for the {@link MagicCard#type() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("type")
    public final Builder type(String type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the optional value {@link MagicCard#manaCost() manaCost} to manaCost.
     * @param manaCost The value for manaCost
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder manaCost(String manaCost) {
      this.manaCost = Objects.requireNonNull(manaCost, "manaCost");
      return this;
    }

    /**
     * Initializes the optional value {@link MagicCard#manaCost() manaCost} to manaCost.
     * @param manaCost The value for manaCost
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("manaCost")
    public final Builder manaCost(Optional<String> manaCost) {
      this.manaCost = manaCost.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link MagicCard#cmc() cmc} to cmc.
     * @param cmc The value for cmc
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder cmc(int cmc) {
      this.cmc = cmc;
      return this;
    }

    /**
     * Initializes the optional value {@link MagicCard#cmc() cmc} to cmc.
     * @param cmc The value for cmc
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("cmc")
    public final Builder cmc(Optional<Integer> cmc) {
      this.cmc = cmc.orElse(null);
      return this;
    }

    /**
     * Adds one element to {@link MagicCard#colorIdentity() colorIdentity} set.
     * @param element A colorIdentity element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addColorIdentity(String element) {
      this.colorIdentity.add(element);
      return this;
    }

    /**
     * Adds elements to {@link MagicCard#colorIdentity() colorIdentity} set.
     * @param elements An array of colorIdentity elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addColorIdentity(String... elements) {
      this.colorIdentity.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link MagicCard#colorIdentity() colorIdentity} set.
     * @param elements An iterable of colorIdentity elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("colorIdentity")
    public final Builder colorIdentity(Iterable<String> elements) {
      this.colorIdentity = ImmutableSet.builder();
      return addAllColorIdentity(elements);
    }

    /**
     * Adds elements to {@link MagicCard#colorIdentity() colorIdentity} set.
     * @param elements An iterable of colorIdentity elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllColorIdentity(Iterable<String> elements) {
      this.colorIdentity.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link MagicCard#colors() colors} set.
     * @param element A colors element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addColors(String element) {
      this.colors.add(element);
      return this;
    }

    /**
     * Adds elements to {@link MagicCard#colors() colors} set.
     * @param elements An array of colors elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addColors(String... elements) {
      this.colors.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link MagicCard#colors() colors} set.
     * @param elements An iterable of colors elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("colors")
    public final Builder colors(Iterable<String> elements) {
      this.colors = ImmutableSet.builder();
      return addAllColors(elements);
    }

    /**
     * Adds elements to {@link MagicCard#colors() colors} set.
     * @param elements An iterable of colors elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllColors(Iterable<String> elements) {
      this.colors.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link MagicCard#types() types} set.
     * @param element A types element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addTypes(String element) {
      this.types.add(element);
      return this;
    }

    /**
     * Adds elements to {@link MagicCard#types() types} set.
     * @param elements An array of types elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addTypes(String... elements) {
      this.types.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link MagicCard#types() types} set.
     * @param elements An iterable of types elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("types")
    public final Builder types(Iterable<String> elements) {
      this.types = ImmutableSet.builder();
      return addAllTypes(elements);
    }

    /**
     * Adds elements to {@link MagicCard#types() types} set.
     * @param elements An iterable of types elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllTypes(Iterable<String> elements) {
      this.types.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link MagicCard#supertypes() supertypes} set.
     * @param element A supertypes element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addSupertypes(String element) {
      this.supertypes.add(element);
      return this;
    }

    /**
     * Adds elements to {@link MagicCard#supertypes() supertypes} set.
     * @param elements An array of supertypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addSupertypes(String... elements) {
      this.supertypes.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link MagicCard#supertypes() supertypes} set.
     * @param elements An iterable of supertypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("supertypes")
    public final Builder supertypes(Iterable<String> elements) {
      this.supertypes = ImmutableSet.builder();
      return addAllSupertypes(elements);
    }

    /**
     * Adds elements to {@link MagicCard#supertypes() supertypes} set.
     * @param elements An iterable of supertypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllSupertypes(Iterable<String> elements) {
      this.supertypes.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link MagicCard#subtypes() subtypes} set.
     * @param element A subtypes element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addSubtypes(String element) {
      this.subtypes.add(element);
      return this;
    }

    /**
     * Adds elements to {@link MagicCard#subtypes() subtypes} set.
     * @param elements An array of subtypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addSubtypes(String... elements) {
      this.subtypes.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link MagicCard#subtypes() subtypes} set.
     * @param elements An iterable of subtypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("subtypes")
    public final Builder subtypes(Iterable<String> elements) {
      this.subtypes = ImmutableSet.builder();
      return addAllSubtypes(elements);
    }

    /**
     * Adds elements to {@link MagicCard#subtypes() subtypes} set.
     * @param elements An iterable of subtypes elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllSubtypes(Iterable<String> elements) {
      this.subtypes.addAll(elements);
      return this;
    }

    /**
     * Initializes the optional value {@link MagicCard#text() text} to text.
     * @param text The value for text
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder text(String text) {
      this.text = Objects.requireNonNull(text, "text");
      return this;
    }

    /**
     * Initializes the optional value {@link MagicCard#text() text} to text.
     * @param text The value for text
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("text")
    public final Builder text(Optional<String> text) {
      this.text = text.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableMagicCard ImmutableMagicCard}.
     * @return An immutable instance of MagicCard
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableMagicCard build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableMagicCard(
          multiverseid,
          name,
          names.build(),
          rarity,
          set,
          type,
          manaCost,
          cmc,
          colorIdentity.build(),
          colors.build(),
          types.build(),
          supertypes.build(),
          subtypes.build(),
          text);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_RARITY) != 0) attributes.add("rarity");
      if ((initBits & INIT_BIT_SET) != 0) attributes.add("set");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      return "Cannot build MagicCard, some of required attributes are not set " + attributes;
    }
  }
}
