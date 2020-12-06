package com.digitalcocoa.mtg.card.organizer.domain.code.dao;

import com.digitalcocoa.mtg.card.organizer.domain.code.Codifiable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
public class CodeRepository {

  private static final String INSERT_CODE_SETS =
      """
      INSERT INTO CODE_SET(MEANING) VALUES (:meanings)
      """;

  private static final String INSERT_CODE_VALUES =
      """
      INSERT INTO CODE_VALUE(CODE_SET_ID, VALUE) VALUES (:codeSetId, :value);
      """;

  private static final String SELECT_ALL_CODES =
      """
      SELECT VALUE, MEANING, CODE_VALUE.ID as CODE_VALUE_ID, CODE_SET.ID as CODE_SET_ID FROM CODE_SET
      LEFT OUTER JOIN CODE_VALUE ON CODE_VALUE.CODE_SET_ID = CODE_SET.ID
      """;

  private static final String SELECT_ALL_CODES_WITH_MEANING =
      SELECT_ALL_CODES + """
      WHERE MEANING IN (:meanings)
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

  public CodeRepository(NamedParameterJdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  @Transactional
  public Mono<Integer> insertCodeSets(Set<String> meanings) {
    return Mono.fromCallable(
        () ->
            jdbc.batchUpdate(
                    INSERT_CODE_SETS,
                    batch(meanings.stream().map(meaning -> Map.of("meanings", meaning))))
                .length);
  }

  @Transactional
  public Mono<Integer> insertCodeValues(int codeSetID, Set<String> values) {
    return Mono.fromCallable(
        () ->
            jdbc.batchUpdate(
                    INSERT_CODE_VALUES,
                    batch(values.stream().map(v -> Map.of("codeSetId", codeSetID, "value", v))))
                .length);
  }

  private static SqlParameterSource[] batch(Stream<Map<String, ?>> arguments) {
    return SqlParameterSourceUtils.createBatch(arguments.toArray());
  }

  public List<CodeEntity> selectCodesByMeaning(Codifiable codeMeaning) {
    return selectCodesByMeaning(Set.of(codeMeaning));
  }

  public List<CodeEntity> selectCodesByMeaning(Set<Codifiable> meanings) {
    return jdbc.query(
        SELECT_ALL_CODES_WITH_MEANING,
        new MapSqlParameterSource(
            "meanings", meanings.stream().map(Codifiable::getMeaning).collect(Collectors.toSet())),
        CodeEntity::fromResultSet);
  }
}
