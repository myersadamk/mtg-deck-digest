package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import com.digitalcocoa.mtg.card.organizer.domain.code.Code;
import com.digitalcocoa.mtg.card.organizer.domain.code.dao.CodeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

public record CardAttributeEntity(@JsonProperty int cardId, @JsonProperty int codeSetId, @JsonProperty int codeValueId) {

  public static CodeEntity fromResultSet(ResultSet resultSet, int rowNumber) throws SQLException {
    return new CodeEntity(
        resultSet.getInt("CODE_VALUE_ID"),
        resultSet.getString("VALUE"),
        resultSet.getInt("CODE_SET_ID"),
        resultSet.getString("MEANING"));
  }

  public static Set<CardAttributeEntity> fromAttributes(int cardId, Set<Code> attribute) {
    return attribute.stream()
        .map(a -> new CardAttributeEntity(cardId, a.meaningId(), a.valueId()))
        .collect(Collectors.toSet());
  }
}
