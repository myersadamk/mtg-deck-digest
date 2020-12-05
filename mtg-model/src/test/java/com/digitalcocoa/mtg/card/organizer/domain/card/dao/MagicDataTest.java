package com.digitalcocoa.mtg.card.organizer.domain.card.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.digitalcocoa.mtg.card.organizer.domain.card.dao.MagicDataTest.TestConfiguration;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ActiveProfiles("h2")
@AutoConfigureTestDatabase
@SpringJUnitConfig(classes = {
    CardRepository.class,
    CardAttributeRepository.class,
})
@ImportAutoConfiguration({JdbcTemplateAutoConfiguration.class, LiquibaseAutoConfiguration.class})
@Import(TestConfiguration.class)
class MagicDataTest {

  @Autowired private CardRepository cardRepository;
  @Autowired private CardAttributeRepository cardAttributeRepository;

  @Test
  void insertEmptyCardAttributes() {
    assertThat(cardAttributeRepository.insertCardAttributes(Set.of()).block()).isZero();
  }

  @Test
  void foreignKeyConstraints() {
    assertThatThrownBy(() -> cardAttributeRepository.insertCardAttributes(Set.of(new CardAttributeEntity(1, 1, 1))).block()).isInstanceOf(DataAccessException.class);
  }

  //  @Configuration
  //  @ComponentScan(basePackages = { "com.digitalcocoa.mtg.card.organizer.domain.card.dao" })
  @SpringBootConfiguration
  @AutoConfigurationPackage
  public static class TestConfiguration {
  }
}
