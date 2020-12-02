package com.digitalcocoa.mtg.card.organizer.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public record CodeEntity(int codeValueId, String value, int codeSetId, String meaning) {
  static CodeEntity fromResultSet(ResultSet resultSet, Integer rowNumber) throws SQLException {
    return new CodeEntity(
        resultSet.getInt("CODE_VALUE_ID"),
        resultSet.getString("VALUE"),
        resultSet.getInt("CODE_SET_ID"),
        resultSet.getString("MEANING"));
  }
}
