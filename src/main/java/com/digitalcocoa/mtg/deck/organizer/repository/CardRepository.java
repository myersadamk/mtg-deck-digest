package com.digitalcocoa.mtg.deck.organizer.repository;

import com.digitalcocoa.mtg.deck.organizer.client.mtgio.RawCard;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepository {

  private final JdbcTemplate template;

  public CardRepository(JdbcTemplate template) {
    this.template = template;
  }

  private static final String BATCH_INSERT_CARDS =
      """
      INSERT INTO CARD(NAME, MANA_COST, CMC) values(?, ?, ?)
      """;

  public void batchInsert(List<RawCard> cards) {
    template.batchUpdate(
        BATCH_INSERT_CARDS,
        cards,
        cards.size(),
        (statement, card) -> {
          statement.setString(1, card.name());
          statement.setString(2, card.manaCost().orElse(null));
          statement.setInt(3, card.cmc().orElse(0));
        });
  }
}
