package com.digitalcocoa.mtg.deck.organizer.repository;

import com.digitalcocoa.mtg.deck.organizer.repository.entity.ImmutableCodifiedValue;
import com.digitalcocoa.mtg.deck.organizer.service.Code;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CodeSetRepository {

  private static final String INSERT_CODE_SETS =
      """
      INSERT IGNORE INTO CODE_SET(MEANING) VALUES (:meanings)
      """;

  private static final String INSERT_CODE_VALUES =
      """
      INSERT IGNORE INTO CODE_VALUE(CODE_SET_ID, VALUE) VALUES (:codeSetId, :value);
      """;

  private static final String SELECT_CODE_VALUE_IDS =
      """
      SELECT * FROM CODE_VALUE
      WHERE CODE_SET_ID IN (:meanings)
      """;

  private static final String SELECT_CODE_SETS =
      """
      SELECT VALUE, MEANING, CODE_VALUE.ID FROM CODE_SET, CODE_VALUE
      WHERE MEANING IN (:meanings) AND CODE_SET.ID = CODE_VALUE.CODE_SET_ID
      """;

  private static final String SELECT_CODE_SET_IDS =
      """
      SELECT * FROM CODE_SET
      WHERE MEANING IN (:meanings)
      """;

  private static final String GET_CODE_SETS =
      """
      SELECT * FROM ENTITY_ATTRIBUTE_CODE c
      WHERE c.CODE IN (:codes)
      LEFT JOIN ENTITY_ATTRIBUTE_VALUE v on c.CODE_ID = v.CODE_ID
      """;

  private final NamedParameterJdbcTemplate jdbc;

  public CodeSetRepository(NamedParameterJdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public Mono<Integer> insertCodeSets(Set<String> meanings) {
    return Mono.fromCallable(
        () ->
            jdbc.batchUpdate(
                    INSERT_CODE_SETS,
                    batch(meanings.stream().map(meaning -> Map.of("meanings", meaning))))
                .length);
  }

  public Mono<Integer> insertCodeValues(Collection<Code> entities) {
    return Mono.fromCallable(
        () ->
            jdbc.batchUpdate(
                    INSERT_CODE_VALUES,
                    batch(
                        entities.stream()
                            .map(v -> Map.of("codeSetId", v.codeSetID(), "value", v.value()))))
                .length);
  }

  private static SqlParameterSource[] batch(Stream<Map<String, ?>> arguments) {
    return SqlParameterSourceUtils.createBatch(arguments.toArray());
  }

  public Map<String, Integer> getCodeSetIds(Set<String> codeSets) {
    if (codeSets.isEmpty()) {
      return Map.of();
    }

    return jdbc
        .query(
            SELECT_CODE_SET_IDS,
            new MapSqlParameterSource("meanings", codeSets),
            (rs, rowNum) -> ImmutableCodeSetEntity.of(rs.getInt("ID"), rs.getString("MEANING")))
        .stream()
        .collect(Collectors.toMap(CodeSetEntity::getMeaning, CodeSetEntity::getID));
  }

  public Map<String, Integer> selectCodeValueIDs(Set<Integer> codeSetID) {
    return null;
  }

  @Immutable(builder = false)
  interface CodeSetEntity {
    @Parameter
    Integer getID();

    @Parameter
    String getMeaning();
  }

  public Map<String, List<CodifiedValue>> loadCodeSetAndValues(Set<String> codeSets) {
    if (codeSets.isEmpty()) {
      return Map.of();
    }
    return jdbc
        .query(
            SELECT_CODE_SETS,
            new MapSqlParameterSource("meanings", codeSets),
            (rs, rowNum) ->
                ImmutableCodifiedValue.builder()
                    .id(rs.getInt("ID"))
                    .value(rs.getString("VALUE"))
                    .build())
        .stream()
        .collect(Collectors.groupingBy(CodifiedValue::meaning));
  }
}
