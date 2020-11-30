package com.digitalcocoa.mtg.deck.organizer.repository;

import com.digitalcocoa.mtg.deck.organizer.repository.entity.CodifiedValue;
import com.digitalcocoa.mtg.deck.organizer.repository.entity.ImmutableCodifiedValue;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CodeSetRepository {

  private static final String INSERT_CODE_SET = """
      INSERT IGNORE INTO ENTITY_ATTRIBUTE_CODE(CODE) VALUES (:code)
      """;

  private static final String SELECT_CODE_SETS = """
      SELECT * FROM ENTITY_ATTRIBUTE_CODE WHERE CODE IN (:codes)
      """;

  private static final String GET_CODE_SETS = """
      SELECT * FROM ENTITY_ATTRIBUTE_CODE c
      WHERE c.CODE IN (:codes) 
      LEFT JOIN ENTITY_ATTRIBUTE_VALUE v on c.CODE_ID = v.CODE_ID
      """;

  private final NamedParameterJdbcTemplate jdbc;

  public CodeSetRepository(NamedParameterJdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public Mono<Void> createCodeSets(Map<String, Set<String>> values) {
    return Mono.fromRunnable(() -> {
      final List<String> codes = List.copyOf(values.keySet());
      final MapSqlParameterSource[] parameterSource = new MapSqlParameterSource[codes.size()];
      for (int i = 0; i < values.size(); ++i) {
        parameterSource[i] = new MapSqlParameterSource("code", codes.get(i));
      }
      jdbc.batchUpdate(INSERT_CODE_SET, parameterSource);
    });
  }

  public Map<String, List<CodifiedValue>> getCodeSets(Set<String> codeSets) {
    if (codeSets.isEmpty()) {
      return Map.of();
    }
    return jdbc
        .query(SELECT_CODE_SETS, new MapSqlParameterSource("codes", codeSets), (rs, rowNum) ->
            ImmutableCodifiedValue.builder()
                .code(rs.getString("CODE"))
                .value(rs.getString("VALUE"))
                .codeId(rs.getInt("CODE_ID"))
                .valueId(rs.getInt("TYPE_ID"))
                .build())
        .stream().collect(
            Collectors.groupingBy(CodifiedValue::code));
  }
}

