package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JdbcBatchItemWriterFactory {

  private final NamedParameterJdbcTemplate jdbc;
  private final DataSource dataSource;

  public <T> JdbcBatchItemWriter<T> create(String sql) {
    return new JdbcBatchItemWriterBuilder<T>()
        .namedParametersJdbcTemplate(jdbc)
        .dataSource(dataSource)
        .beanMapped()
        .sql(sql)
//        .itemSqlParameterSourceProvider(
//            item ->
//                new BeanPropertyItemSqlParameterSourceProvider<>().createSqlParameterSource(item))
        .build();
  }
}
