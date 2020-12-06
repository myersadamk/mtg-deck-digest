package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.digitalcocoa.mtg.card.organizer.domain.card.dao.CardAttributeRepositoryTest.TestConfiguration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.List;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ActiveProfiles("h2")
@AutoConfigureTestDatabase
@SpringBootTest
@SpringJUnitConfig(
    classes = {
      CardAttributeRepository.class,
        JdbcBatchItemWriterFactory.class
    })
@Import(TestConfiguration.class)
@ImportAutoConfiguration({JdbcTemplateAutoConfiguration.class, LiquibaseAutoConfiguration.class, DataSourceAutoConfiguration.class})
class CardAttributeRepositoryTest {

  @Autowired private CardAttributeRepository cardAttributeRepository;

  @Test
  void insertNone() {
    assertThat(cardAttributeRepository.insertCardAttributes(List.of())).isZero();
  }

  @Test
  void canInsertTwo() {
    assertThat(
            cardAttributeRepository
                .insertCardAttributes(
                    List.of(new CardAttributeEntity(1, 1, 1), new CardAttributeEntity(1, 2, 2))))
        .isEqualTo(2);
  }

  @Test
  void foreignKeyConstraintsFail() {
    assertThatThrownBy(
            () ->
                cardAttributeRepository
                    .insertCardAttributes(List.of(new CardAttributeEntity(2, 1, 1))))
        .isInstanceOf(DataAccessException.class);
  }

  @SpringBootConfiguration
  @AutoConfigurationPackage
  public static class TestConfiguration {

    @Bean
    @Primary
    public DataSource dataSource(HikariConfig hikariConfig) {
      final var dataSource = new HikariDataSource(hikariConfig);
      dataSource.setSchema("AETHERBASE");
      return dataSource;
    }
  }
}
