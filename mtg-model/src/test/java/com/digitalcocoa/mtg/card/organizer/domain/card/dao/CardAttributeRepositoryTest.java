package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.digitalcocoa.mtg.card.organizer.domain.card.dao.CardAttributeRepositoryTest.TestConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@AutoConfigureTestDatabase
@SpringJUnitConfig(classes = {CardAttributeRepository.class})
@ImportAutoConfiguration({JdbcTemplateAutoConfiguration.class, LiquibaseAutoConfiguration.class})
@Import(TestConfiguration.class)
@ActiveProfiles("h2")
class CardAttributeRepositoryTest {

  @Autowired private CardAttributeRepository repository;

  @Test
  void insertEmptyCardAttributes() {
    assertThat(repository.insertCardAttributes(Set.of()).block()).isZero();
  }

  @Test
  void insertCardAttributes() {
    assertThat(repository.insertCardAttributes(Set.of(new CardAttributeEntity(1, 2, 3))).block())
        .isZero();
  }

  //  @Configuration
  //  @ComponentScan(basePackages = { "com.digitalcocoa.mtg.card.organizer.domain.card.dao" })
  @SpringBootConfiguration
  @AutoConfigurationPackage
  public static class TestConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
      return new ObjectMapper();
    }
  }
}
