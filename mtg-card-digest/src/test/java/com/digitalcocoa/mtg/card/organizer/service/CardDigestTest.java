package com.digitalcocoa.mtg.card.organizer.service;

import com.digitalcocoa.mtg.card.digest.CardDigest;
import com.digitalcocoa.mtg.card.digest.DigestApplication;
import com.digitalcocoa.mtg.card.organizer.domain.MagicRegistryAutoConfiguration;
import com.digitalcocoa.mtg.card.organizer.domain.card.dao.CardRepository;
import com.digitalcocoa.mtg.card.organizer.domain.code.CodeRegistryService;
import com.digitalcocoa.mtg.card.organizer.domain.code.dao.CodeRepository;
import com.digitalcocoa.mtg.client.organizer.client.mtgio.CardCatalog;
import com.digitalcocoa.mtg.client.organizer.client.mtgio.CardCatalogAutoConfiguration;
import com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.MagicCardClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest(classes = DigestApplication.class)
@SpringJUnitConfig(
    classes = {
      CardDigest.class,
      CardCatalog.class,
      MagicCardClient.class,
      CodeRegistryService.class,
      CodeRepository.class,
      CardRepository.class
    })
@ImportAutoConfiguration(
    classes = {
      CardCatalogAutoConfiguration.class,
      MagicRegistryAutoConfiguration.class,
      JdbcTemplateAutoConfiguration.class
    })
class CardDigestTest {

  private final CardDigest cardIngester;
  private final CardRepository cardRepository;

  @Autowired
  CardDigestTest(CardDigest cardIngester, CardRepository cardRepository) {
    this.cardIngester = cardIngester;
    this.cardRepository = cardRepository;
  }

  @Test
  void lol() {
    cardIngester.run().block();
  }

  @Test
  void blah() {
//    System.out.println(cardRepository.getCardByName("Beacon of Destruction"));
    System.out.println(cardRepository.selectAllCards());
  }

  @Test
  void get() {
    //    codeSetRepository.getCodeSets(Set.of("types"));
  }
}
