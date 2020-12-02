package com.digitalcocoa.mtg.card.organizer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepository {

  private static final String INSERT_CARD =
      """
      INSERT IGNORE INTO CARD(NAME, TYPE, COLOR_IDENTITY, MANA_COST, CMC) VALUES (:name, :type:, :colorIdentity, :manaCost, :cmc)
      """;

  private final NamedParameterJdbcTemplate jdbc;

  @Autowired
  public CardRepository(NamedParameterJdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }
}
