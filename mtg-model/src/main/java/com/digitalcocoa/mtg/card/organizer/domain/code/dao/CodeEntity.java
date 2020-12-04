package com.digitalcocoa.mtg.card.organizer.domain.code.dao;

import com.digitalcocoa.mtg.card.organizer.domain.code.Code;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public record CodeEntity(int codeValueId, String value, int codeSetId, String meaning) {
  public static CodeEntity fromResultSet(ResultSet resultSet, int rowNumber) throws SQLException {
    return new CodeEntity(
        resultSet.getInt("CODE_VALUE_ID"),
        resultSet.getString("VALUE"),
        resultSet.getInt("CODE_SET_ID"),
        resultSet.getString("MEANING"));
  }

  public static Set<Code> toCodes(Collection<CodeEntity> entities) {
    return entities.stream()
        .filter(entity -> entity.value() != null && entity.codeSetId() > 0)
        .map(
            entity ->
                new Code(
                    entity.value(), entity.codeValueId(), entity.meaning(), entity.codeSetId()))
        .collect(Collectors.toSet());
  }
}
