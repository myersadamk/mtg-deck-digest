package com.digitalcocoa.mtg.card.organizer.repository;

import com.digitalcocoa.mtg.card.organizer.domain.card.Card;
import com.digitalcocoa.mtg.card.organizer.domain.card.NewCard;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CardRepository {

  private static final TypeReference<Map<String, Object>> PARAM_MAP_TYPE = new TypeReference<>() {};

  private <T> Map<String, Object> toParameters(T input) {
    return objectMapper.convertValue(input, PARAM_MAP_TYPE);
  }

  private static final String INSERT_CARD =
      """
      INSERT INTO CARD(NAME, TYPE, MANA_COST, CMC) VALUES (:name, :type, :manaCost, :cmc)
      """;

  private static final String SELECT_CARD_BY_NAME =
      """
      SELECT * FROM CARD WHERE NAME in (:cardNames)
      """;

  private final NamedParameterJdbcTemplate jdbc;
  private final ObjectMapper objectMapper;

  @Autowired
  public CardRepository(NamedParameterJdbcTemplate jdbc, ObjectMapper objectMapper) {
    this.jdbc = jdbc;
    this.objectMapper = objectMapper;
  }

  public Mono<Integer> insertCards(NewCard... cards) {
    return Flux.fromArray(cards)
        .map(this::toParameters)
        .collectList()
        .map(parameters -> jdbc.batchUpdate(INSERT_CARD, batch(parameters.stream())).length);
  }

  public Optional<Card> getCardByName(String cardName) {
    enum Column {
      ID,
      NAME,
      TYPE,
      MANA_COST,
      CMC;
    }
    return
                jdbc
                    .queryForList(SELECT_CARD_BY_NAME, Map.of("cardNames", cardName), Card.class)
                    .stream()
                    .findAny();
    //      return new Card(
    //          resultSet.getInt(Column.ID.name()),
    //          resultSet.getString(Column.NAME.name()),
    //          resultSet.getString(Column.TYPE.name()),
    //          resultSet.getString(Column.MANA_COST.name()),
    //          resultSet.getInt(Column.CMC.name())
    //        );
    //    }));
  }

  private static SqlParameterSource[] batch(Stream<Map<String, Object>> arguments) {
    return SqlParameterSourceUtils.createBatch(arguments.toArray());
  }
}
