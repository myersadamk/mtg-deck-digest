package com.digitalcocoa.mtg.deck.organizer.client.mtgio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MagicTheGatheringApiConfig.class)
final class MagicCardClientIntegrationTest {

  private final MagicCardClient cardsClient;

  @Autowired
  MagicCardClientIntegrationTest(MagicCardClient cardsClient) {
    this.cardsClient = cardsClient;
  }

  @Test
  void getLastPageNumber() {
    assertThat(cardsClient.getLastPageNumber().block())
        .isEqualTo(cardsClient.getPage(1).block().lastPageNumber());
  }

  @Test
  void printCardsOnFirstPage() {
    printCardsOnPage(cardsClient.getPage(1, ImmutableFilters.builder().addSets("10E").build()));
  }

  @Test
  void printCardsOnSecondPage() {
    printCardsOnPage(cardsClient.getPage(2));
  }

  @Test
  void printCardsOnLastPage() {
    printCardsOnPage(cardsClient.getPage(cardsClient.getLastPageNumber().block()));
  }

  private static void printCardsOnPage(Mono<Page> page) {
    page.block().cards().forEach(System.out::println);
  }
}
