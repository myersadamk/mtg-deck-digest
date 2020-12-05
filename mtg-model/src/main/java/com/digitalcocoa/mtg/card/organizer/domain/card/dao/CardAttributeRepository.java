package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import java.util.Set;
import javax.sql.DataSource;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CardAttributeRepository {

  private static final String INSERT_CARD_ATTRIBUTES =
      """
      INSERT INTO CARD_ATTRIBUTES(CARD_ID, CODE_SET_ID, CODE_VALUE_ID) VALUES (:cardId, :codeSetId, :codeValueId)
      """;

  private final NamedParameterJdbcTemplate jdbc;
  private final DataSource dataSource;

  @Autowired
  public CardAttributeRepository(NamedParameterJdbcTemplate jdbc, DataSource dataSource) {
    this.jdbc = jdbc;
    this.dataSource = dataSource;
  }

  public Mono<Integer> insertCardAttributes(Set<CardAttributeEntity> attributes) {
    return Flux.fromIterable(attributes)
        .collectList()
        .flatMap(
            parameters -> {
              JdbcBatchItemWriter<CardAttributeEntity> writer = new JdbcBatchItemWriter<>();
              writer.setDataSource(dataSource);
              writer.setJdbcTemplate(jdbc);
              writer.setSql(INSERT_CARD_ATTRIBUTES);
              writer.afterPropertiesSet();
              writer.setItemSqlParameterSourceProvider(item -> new BeanPropertyItemSqlParameterSourceProvider<>().createSqlParameterSource(item));
              try {
                writer.write(parameters);
              } catch (Exception e) {
                return Mono.error(new DataAccessException("Failed to insert card entity attributes", e) {});
              }
              return Mono.just(attributes.size());
            });
  }
}
