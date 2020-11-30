package com.digitalcocoa.mtg.deck.organizer.client.mtgio;

import static java.lang.System.out;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// TODO: Figure out if StepVerifier will work for this (my initial attempts were producing false
// positives).
//  Printing stuff is pretty hands-on.
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MagicTheGatheringApiConfig.class)
// @EnabledIfEnvironmentVariable(named = "test.integration.enabled", matches = "true")
class CardCatalogIntegrationTest {

  private final CardCatalog cardCatalog;
  private final int n;

  @Autowired
  CardCatalogIntegrationTest(
      CardCatalog cardCatalog, @Value("${test.integration.take-n}") int n) {
    this.cardCatalog = cardCatalog;
    this.n = n;
  }

  @Test
  void printCards() {
    cardCatalog.getCards(Filters.NONE).take(n).doOnEach(out::println).blockLast();
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