package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardAttributeRepository {

  private static final String INSERT_CARD_ATTRIBUTES =
      """
      INSERT INTO CARD_ATTRIBUTES(CARD_ID, CODE_SET_ID, CODE_VALUE_ID) VALUES (:cardId, :codeSetId, :codeValueId)
      """;

  private final NamedParameterJdbcTemplate jdbc;

  public int insertCardAttributes(List<CardAttributeEntity> attributes) {
      return jdbc.batchUpdate(
          INSERT_CARD_ATTRIBUTES,
          SqlParameterSourceUtils.createBatch(attributes.toArray())).length;
  }
}
