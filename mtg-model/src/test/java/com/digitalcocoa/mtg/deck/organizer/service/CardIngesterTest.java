package com.digitalcocoa.mtg.deck.organizer.service;

import com.digitalcocoa.mtg.deck.organizer.client.mtgio.MagicTheGatheringApiConfig;
import com.digitalcocoa.mtg.deck.organizer.repository.CodeSetRepository;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(
    classes = {CardIngester.class, CodeSetRepository.class, MagicTheGatheringApiConfig.class})
@SpringBootTest(classes = MtgDeckOrganizerApplication.class)
class CardIngesterTest {

  private final CardIngester cardIngester;
  private final CodeSetRepository codeSetRepository;
  //  private final Reposito codeSetRepository;

  @Autowired
  CardIngesterTest(CardIngester cardIngester, CodeSetRepository codeSetRepository) {
    this.cardIngester = cardIngester;
    this.codeSetRepository = codeSetRepository;
  }

  @Test
  void lol() {
    cardIngester.run().block();
  }

  @Test
  void blah() {
    int a = codeSetRepository.insertCodeSets(Set.of("5", "6", "7")).block();
    System.out.println(a);
  }

  @Test
  void get() {
    //    codeSetRepository.getCodeSets(Set.of("types"));
  }
}
