package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import com.digitalcocoa.mtg.card.organizer.domain.card.Card;
import com.digitalcocoa.mtg.card.organizer.domain.card.NewCard;
import com.digitalcocoa.mtg.card.organizer.domain.code.dao.CodeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
      INSERT IGNORE INTO CARD(NAME, TYPE, MANA_COST, CMC) VALUES (:name, :type, :manaCost, :cmc)
      """;

  private static final String SELECT_CARD_BY_NAME =
      """
      SELECT * FROM CARD WHERE NAME in (:cardNames)
      """;

  private static final String SELECT_CARD_IDS =
      """
      SELECT ID FROM CARD WHERE NAME in (:cardNames)
      """;

  private static final String SELECT_CARD_AND_ATTRIBUTES =
      """
      select * from CARD
      left outer join CARD_ATTRIBUTES on CARD.ID = CARD_ATTRIBUTES.CARD_ID
      left outer join CODE_SET on CARD_ATTRIBUTES.CODE_SET_ID = CODE_SET.ID
      left outer join CODE_VALUE on CODE_SET.ID = CODE_VALUE.CODE_SET_ID
      """;

  private static final String SELECT_ALL_BY_CARD_NAME = SELECT_CARD_AND_ATTRIBUTES +
      """
      where NAME in (:cardNames)
      """;

  private final NamedParameterJdbcTemplate jdbc;
  private final ObjectMapper objectMapper;
  private final CardAttributeRepository cardAttributeRepository;
  private final CodeRepository codeRepository;
  private final DataSource dataSource;

  @Autowired
  public CardRepository(
      NamedParameterJdbcTemplate jdbc,
      ObjectMapper objectMapper,
      CardAttributeRepository cardAttributeRepository,
      CodeRepository codeRepository, DataSource dataSource) {
    this.jdbc = jdbc;
    this.objectMapper = objectMapper;
    this.cardAttributeRepository = cardAttributeRepository;
    this.codeRepository = codeRepository;
    this.dataSource = dataSource;
  }

  public Mono<Integer> insertCards(NewCard... cards) {

    return Flux.fromArray(cards)
        .map(this::toParameters)
        .collectList()
        .map(parameters -> jdbc.batchUpdate(INSERT_CARD, batch(parameters.stream())))
        .thenMany(Flux.fromArray(cards))
        .flatMap(
            card -> {
              final Integer cardID = cardIDs.get(card.name());
              if (cardID == null || cardID < 0) {
                return Flux.error(RuntimeException::new);
              }

              return Flux.fromIterable(card.attributes())
                  .collect(Collectors.toUnmodifiableSet())
                  .map(attributes -> CardAttributeEntity.fromAttributes(cardID, attributes));
            })
        .flatMap(Flux::fromIterable)
        .collect(Collectors.toSet())
        .flatMap(cardAttributeRepository::insertCardAttributes);
  }

  private Map<String, Integer> selectCardIDs(Set<String> cardNames) {
    return jdbc
        .queryForMap(SELECT_CARD_IDS, new MapSqlParameterSource("cardNames", cardNames))
        .entrySet()
        .stream()
        .collect(
            Collectors.toMap(
                Entry::getKey,
                d ->
                    Optional.ofNullable(d.getValue())
                        .map(Object::toString)
                        .map(Integer::valueOf)
                        .orElse(-1)));
  }

  // TODO: this was the easiest thing for what was wanted, but more advanced filters will be needed
  public Optional<Card> getCardByName(String cardName) {
    final var query = new BuildingCardQuery(dataSource, SELECT_ALL_BY_CARD_NAME);
    query.declareParameter(new SqlParameterValue(Types.ARRAY, "cardNames"));
    query.executeByNamedParam(Map.of("cardNames", cardName));
    return query.aggregateCards().stream().findAny();
  }

  public List<Card> selectAllCards() {
    final var query = new BuildingCardQuery(dataSource, SELECT_CARD_AND_ATTRIBUTES);
    query.execute();
    return query.aggregateCards();
  }

  private static SqlParameterSource[] batch(Stream<Map<String, Object>> arguments) {
    return SqlParameterSourceUtils.createBatch(arguments.toArray());
  }
}
