package com.digitalcocoa.mtg.deck.organizer.message.consumer;

import java.util.List;
import java.util.function.Consumer;
import reactor.core.publisher.Flux;

public class DeckConsumer implements Consumer<List<DeckPayload>> {

  @Override
  public void accept(List<DeckPayload> deckPayloads) {
    ingest(Flux.fromIterable(deckPayloads));
  }

  private void ingest(Flux<DeckPayload> deckPayloads) {
    // create deck type from format
    deckPayloads.map(deck -> deck.attributes().formats())
  }
}
