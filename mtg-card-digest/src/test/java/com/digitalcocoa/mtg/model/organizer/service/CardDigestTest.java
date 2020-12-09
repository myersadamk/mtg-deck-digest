package com.digitalcocoa.mtg.model.organizer.service;

import com.digitalcocoa.mtg.model.digest.CardDigest;
import com.digitalcocoa.mtg.model.digest.DigestApplication;
import com.digitalcocoa.mtg.model.domain.MagicRegistryAutoConfiguration;
import com.digitalcocoa.mtg.model.domain.card.dao.CardAttributeRepository;
import com.digitalcocoa.mtg.model.domain.card.dao.CardRepository;
import com.digitalcocoa.mtg.model.domain.code.CodeRegistryService;
import com.digitalcocoa.mtg.model.domain.code.dao.CodeRepository;
import com.digitalcocoa.mtg.catalog.CardCatalog;
import com.digitalcocoa.mtg.catalog.CardCatalogAutoConfiguration;
import com.digitalcocoa.mtg.catalog.client.mtgio.ImmutableFilters;
import com.digitalcocoa.mtg.catalog.client.mtgio.rest.MagicCardClient;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import reactor.core.publisher.Hooks;
import reactor.util.Loggers;

@SpringBootTest(classes = DigestApplication.class)
@SpringJUnitConfig(
    classes = {
      CardDigest.class,
      CardCatalog.class,
      MagicCardClient.class,
      CodeRegistryService.class,
      CodeRepository.class,
      CardRepository.class,
      CardAttributeRepository.class
    })
@ImportAutoConfiguration(
    classes = {
      CardCatalogAutoConfiguration.class,
      MagicRegistryAutoConfiguration.class,
      JdbcTemplateAutoConfiguration.class
    })
@Slf4j
class CardDigestTest {

  private final CardDigest cardIngester;
  private final CardCatalog catalog;
  private final CardRepository cardRepository;

  @Autowired
  CardDigestTest(CardDigest cardIngester, CardCatalog catalog, CardRepository cardRepository) {
    this.cardIngester = cardIngester;
    this.catalog = catalog;
    this.cardRepository = cardRepository;
  }

  @Test
  void lol() {
    Hooks.onOperatorDebug();
    cardIngester.run().log(Loggers.getLogger("test")).block();
  }

  @Test
  void flol() {
    cardIngester
        .digestCards(
            catalog.getCards(ImmutableFilters.builder().addSets("KTK").build()).take(100).cache())
        .log()
        .block();
  }

  @Test
  void blah() {
    System.out.println(cardRepository.selectCardsByTitle(Set.of("Academy Researchers", "Afflict")));
  }

  @Test
  void get() {
    //    codeSetRepository.getCodeSets(Set.of("types"));
  }
}
