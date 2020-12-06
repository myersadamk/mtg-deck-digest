package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import com.digitalcocoa.mtg.card.organizer.domain.card.dao.CardRepository.CardEntity;
import com.digitalcocoa.mtg.card.organizer.domain.card.dao.CardRepositoryTest.TestConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
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

@ActiveProfiles("h2")
@AutoConfigureTestDatabase
@SpringJUnitConfig(
    classes = {
      CardRepository.class,
      CardAttributeRepository.class,
    })
@ImportAutoConfiguration({JdbcTemplateAutoConfiguration.class, LiquibaseAutoConfiguration.class})
@Import(TestConfiguration.class)
class CardRepositoryTest {

  @Autowired private CardRepository cardRepository;
  @Autowired private CardAttributeRepository fudge;

  @Test
  void insertAndSelectCards() {
    cardRepository.insertCards(
        List.of(new CardEntity(1, "Abundance", "Enchantment", "1{G}{G}", 1)));

    System.out.println(cardRepository.selectAllCards());
  }

  @SpringBootConfiguration
  @AutoConfigurationPackage
  public static class TestConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
      return new ObjectMapper();
    }
  }
}