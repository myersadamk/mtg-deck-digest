package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CardAttributeRepository {

  private static final String INSERT_CARD_ATTRIBUTES =
      """
      INSERT INTO CARD_ATTRIBUTES(CARD_ID, CODE_SET_ID, CODE_VALUE_ID) VALUES (:cardId, :codeSetId, :codeValueId)
      """;

  private final JdbcBatchItemWriterFactory batchWriterFactory;

  public Mono<Integer> insertCardAttributes(Set<CardAttributeEntity> attributes) {
    return Flux.fromIterable(attributes)
        .collectList()
        .flatMap(
            parameters -> {
              final JdbcBatchItemWriter<CardAttributeEntity> writer = batchWriterFactory.create(INSERT_CARD_ATTRIBUTES);
              try {
                writer.write(parameters);
              } catch (Exception e) {
                return Mono.error(
                    new DataAccessException("Failed to insert card entity attributes", e) {});
              }
              return Mono.just(attributes.size());
            });
  }
}
