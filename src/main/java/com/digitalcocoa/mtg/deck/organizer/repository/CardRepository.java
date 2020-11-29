package com.digitalcocoa.mtg.deck.organizer.repository;

import com.digitalcocoa.mtg.deck.organizer.repository.entity.CardEntity;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepository {

  public Map<String, CardEntity> getCardsByName(Set<String> names) {
    return null;
  }
}
