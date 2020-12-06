package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@RequiredArgsConstructor
public class JdbcBatchItemWriterFactory {

  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private final DataSource dataSource;

  public <T> JdbcBatchItemWriter<T> create(String sql) {
    return new JdbcBatchItemWriterBuilder<T>()
        .dataSource(dataSource)
        .namedParametersJdbcTemplate(namedParameterJdbcTemplate)
        .sql(sql)
        .itemSqlParameterSourceProvider(
            item ->
                new BeanPropertyItemSqlParameterSourceProvider<>().createSqlParameterSource(item))
        .build();
  }
}
