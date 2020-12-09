package com.digitalcocoa.mtg.model.domain.card.dao;

import com.digitalcocoa.mtg.model.domain.card.Card;
import com.digitalcocoa.mtg.model.domain.card.ImmutableCard;
import com.digitalcocoa.mtg.model.domain.code.Code;
import com.google.common.collect.ImmutableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.RowMapper;

public class BuildingCardQuery implements RowMapper<ImmutableCard.Builder> {

  private enum Column {
    ID,
    TITLE,
    TYPE,
    CMC,
    MANA_COST,
    MEANING,
    CODE_SET,
    CODE_VALUE;

    Optional<Integer> readInteger(ResultSet rs) throws SQLException {
      return Optional.ofNullable(rs.getString(name())).map(Integer::valueOf);
    }

    String readString(ResultSet rs) throws SQLException {
      return rs.getString(name());
    }
  }

  public BuildingCardQuery() {}

  private final ImmutableList.Builder<Card> builtCards = ImmutableList.builder();
  private ImmutableCard.Builder cardBuilder = ImmutableCard.builder();

  private Integer lastID = -1;

  @Override
  public ImmutableCard.Builder mapRow(ResultSet rs, int rowNum) throws SQLException {
    final int currentID = Column.ID.readInteger(rs).orElseThrow();

    final var codeSetID = rs.getInt("CODE_SET.ID");
    final var codeValueID = rs.getInt("CODE_VALUE.ID");

    if (codeSetID > 0 && codeValueID > 0) {
      final Code code =
          new Code(
              rs.getString("CODE_VALUE.VALUE"),
              codeValueID,
              rs.getString("CODE_SET.MEANING"),
              codeSetID);

      cardBuilder.addCardAttribute(code);
    }

    if (lastID != currentID) {
      builtCards.add(
          cardBuilder
              .id(currentID)
              .name(Column.TITLE.readString(rs))
              .type(Column.TYPE.readString(rs))
              .cmc(Column.CMC.readInteger(rs).orElse(0))
              .manaCost(Column.MANA_COST.readString(rs))
              .build());
      cardBuilder = ImmutableCard.builder();
    }
    lastID = currentID;
    return cardBuilder;
  }

  List<Card> aggregateCards() {
    return builtCards.build();
  }
}
