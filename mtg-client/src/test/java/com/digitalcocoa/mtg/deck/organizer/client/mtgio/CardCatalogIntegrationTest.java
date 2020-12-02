package com.digitalcocoa.mtg.client.organizer.client.mtgio;

import static java.lang.System.out;

import com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.MagicCardClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

;

// TODO: Figure out if StepVerifier will work for this (my initial attempts were producing false
// positives).
//  Printing stuff is pretty hands-on.
@SpringBootTest
@SpringJUnitConfig({CardCatalog.class, MagicCardClient.class})
@ImportAutoConfiguration(CardCatalogAutoConfiguration.class)
// @EnabledIfEnvironmentVariable(named = "test.integration.enabled", matches = "true")
class CardCatalogIntegrationTest {

  @Autowired private CardCatalog cardCatalog;
  private final int n;

  @Autowired
  CardCatalogIntegrationTest(CardCatalog cardCatalog, @Value("${test.integration.take-n}") int n) {
    this.cardCatalog = cardCatalog;
    this.n = n;
  }

  @Test
  void printCards() {
    cardCatalog.getCards(Filters.NONE).take(4).doOnEach(out::println).blockLast();
  }

  @Test
  void countCards() {
    out.println(
        String.format(
            "Counted %d Magic: The Gathering cards (taking n: %d)",
            cardCatalog.getCards(Filters.NONE).take(n).count().block(), n));
  }

  //  @Test
  //  void printCardsWithGreenColorIdentity() {
  //    cardCatalog
  //        .matchCards(ImmutableCardCriteria.builder().colorIdentity(Set.of(Color.GREEN)).build())
  //        .take(n / 4)
  //        .doOnEach(out::println)
  //        .blockLast();
  //  }
  //
  //  @Test
  //  void printUniqueCard() {
  //    cardCatalog
  //        .matchCards(ImmutableCardCriteria.builder().nameContains("Nekrataal").build())
  //        .take(1)
  //        .doOnEach(System.out::println)
  //        .blockLast();
  //  }
  //
  //  @Test
  //  void printCardsWithTheInName() {
  //    cardCatalog
  //        .matchCards(ImmutableCardCriteria.builder().nameContains("the").build())
  //        .take(n / 4)
  //        .doOnEach(System.out::println)
  //        .blockLast();
  //  }
}
