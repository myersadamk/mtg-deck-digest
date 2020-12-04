package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CardAttributeRepository {

  private static final TypeReference<Map<String, Object>> PARAM_MAP_TYPE = new TypeReference<>() {};

  private <T> Map<String, Object> toParameters(T input) {
    return objectMapper.convertValue(input, PARAM_MAP_TYPE);
  }

  private static final String INSERT_CARD_ATTRIBUTES =
      """
      INSERT INTO CARD_ATTRIBUTES(CARD_ID, CODE_SET_ID, CODE_VALUE_ID) VALUES (:cardId, :codeSetId, :codeValueId)
      """;

  private static final String SELECT_CARD_BY_NAME = """
      """;

  private final NamedParameterJdbcTemplate jdbc;
  private final ObjectMapper objectMapper;

  @Autowired
  public CardAttributeRepository(NamedParameterJdbcTemplate jdbc, ObjectMapper objectMapper) {
    this.jdbc = jdbc;
    this.objectMapper = objectMapper;
  }

  public Mono<Integer> insertCardAttributes(Set<CardAttributeEntity> attributes) {
    return Flux.fromIterable(attributes)
        .map(this::toParameters)
        .collectList()
        .map(
            parameters ->
                jdbc.batchUpdate(INSERT_CARD_ATTRIBUTES, batch(parameters.stream())).length);
  }

  private static SqlParameterSource[] batch(Stream<Map<String, Object>> arguments) {
    return SqlParameterSourceUtils.createBatch(arguments.toArray());
  }
}
