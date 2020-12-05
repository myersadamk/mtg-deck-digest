package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import com.digitalcocoa.mtg.card.organizer.domain.card.Card;
import com.digitalcocoa.mtg.card.organizer.domain.card.ImmutableCard;
import com.digitalcocoa.mtg.card.organizer.domain.code.Code;
import com.google.common.collect.ImmutableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.object.MappingSqlQuery;

public class BuildingCardQuery extends MappingSqlQuery<Code> {

  private enum Column {
    ID,
    NAME,
    TYPE,
    CMC,
    MANA_COST,
    MEANING,
    VALUE;

    Integer readInteger(ResultSet rs) throws SQLException {
      return rs.getInt(name());
    }

    String readString(ResultSet rs) throws SQLException {
      return rs.getString(name());
    }
  }

  public BuildingCardQuery(DataSource ds, String sql) {
    super(ds, sql);
  }

  private final ImmutableList.Builder<Card> builtCards = ImmutableList.builder();
  private ImmutableCard.Builder cardBuilder = ImmutableCard.builder();

  private Integer lastID = -1;

  @Override
  protected Code mapRow(ResultSet rs, int rowNum) throws SQLException {
    final int currentID = Column.ID.readInteger(rs);
    final Code code =
        new Code(
            Column.VALUE.readString(rs),
            rs.getInt("CODE_VALUE.ID"),
            Column.MEANING.readString(rs),
            rs.getInt("CODE_SET.ID"));

    cardBuilder.addCardAttribute(code);

    if (lastID != currentID) {
      builtCards.add(
          cardBuilder
              .id(currentID)
              .name(Column.NAME.readString(rs))
              .type(Column.TYPE.readString(rs))
              .cmc(Column.CMC.readInteger(rs))
              .manaCost(Column.MANA_COST.readString(rs))
              .build());
      cardBuilder = ImmutableCard.builder();
    }
    lastID = currentID;

    return code;
  }

  List<Card> aggregateCards() {
    return builtCards.build();
  }
}