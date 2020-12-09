package com.digitalcocoa.mtg.model.domain.card.dao;

import com.digitalcocoa.mtg.model.domain.card.Card;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CardRepository {

  private static final String INSERT_CARD =
      "INSERT INTO CARD(TITLE, TYPE, MANA_COST, CMC) VALUES (:title, :type, :manaCost, :cmc)";

  private static final String SELECT_CARD_IDS =
      """
      select TITLE, ID from CARD where name in (:cardNames)
      """;

  private static final String SELECT_CARD_AND_ATTRIBUTES =
      """
      select * from CARD
      left outer join CARD_ATTRIBUTES on CARD.ID = CARD_ATTRIBUTES.CARD_ID
      left outer join CODE_SET on CARD_ATTRIBUTES.CODE_SET_ID = CODE_SET.ID
      left outer join CODE_VALUE on CODE_SET.ID = CODE_VALUE.CODE_SET_ID
      """;

  private static final String SELECT_ALL_BY_CARD_NAME =
      SELECT_CARD_AND_ATTRIBUTES + """
      where TITLE in (:cardNames)
      """;

  private final NamedParameterJdbcTemplate jdbc;
  private final DataSource dataSource;

  @Autowired
  public CardRepository(NamedParameterJdbcTemplate jdbc, DataSource dataSource) {
    this.jdbc = jdbc;
    this.dataSource = dataSource;
  }

  @Transactional
  public int insertCards(List<CardEntity> cardEntities) {
    if (cardEntities.isEmpty()) {
      return 0;
    }
    return jdbc.batchUpdate(
            INSERT_CARD, SqlParameterSourceUtils.createBatch(cardEntities.toArray()))
        .length;
  }

  public record CardEntity(Integer ID, String title, String type, String manaCost, int cmc) {}

  @Transactional
  public Map<String, Integer> selectCardIDs(Set<String> cardNames) {
    return jdbc
        .query(
            SELECT_CARD_IDS,
            new MapSqlParameterSource("cardNames", cardNames),
            DataClassRowMapper.newInstance(CardEntity.class))
        .stream()
        .collect(
            Collectors.toMap(
                CardEntity::title,
                card ->
                    Optional.ofNullable(card.ID)
                        .map(Object::toString)
                        .map(Integer::valueOf)
                        .orElse(-1)));
    //    return map
    //        .entrySet()
    //        .stream()
    //        .collect(
    //            Collectors.toMap(
    //                Entry::getKey,
    //                d ->
    //                    Optional.ofNullable(d.getValue())
    //                        .map(Object::toString)
    //                        .map(Integer::valueOf)
    //                        .orElse(-1)));
  }

  // TODO: this was the easiest thing for what was wanted, but more advanced filters will be needed
  public Optional<Card> selectCardByName(String cardName) {
    return selectCardsByTitle(Set.of(cardName)).stream().findAny();
  }

  public List<Card> selectCardsByTitle(Collection<String> cardNames) {
    if (cardNames.isEmpty()) {
      return List.of();
    }
    final var mapper = new BuildingCardQuery();
    jdbc.query(SELECT_ALL_BY_CARD_NAME, Map.of("cardNames", cardNames), mapper);
    return mapper.aggregateCards();
  }

  //  public List<Card> selectAllCards() {
  //    final var query = new BuildingCardQuery(dataSource, SELECT_CARD_AND_ATTRIBUTES);
  //    query.execute();
  //    return query.aggregateCards();
  //  }

  private static SqlParameterSource[] batch(Stream<Map<String, Object>> arguments) {
    return SqlParameterSourceUtils.createBatch(arguments.toArray());
  }
}
