package com.digitalcocoa.mtg.deck.organizer.message.consumer;

import com.digitalcocoa.mtg.deck.organizer.domain.card.Card;
import com.digitalcocoa.mtg.deck.organizer.domain.card.ImmutableCard;
import com.digitalcocoa.mtg.deck.organizer.domain.deck.Deck;
import com.digitalcocoa.mtg.deck.organizer.domain.deck.ImmutableDeck;
import com.digitalcocoa.mtg.deck.organizer.domain.game.Format;
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
    deckPayloads.map(deck -> ImmutableDeck.builder().build()).subscribe();
  }

  private class DeckProxy implements Deck {
    private final DeckPayload payload;

    private DeckProxy(DeckPayload payload) {
      this.payload = payload;
    }

    @Override
    public List<Card> mainboard() {
      return null;
    }

    @Override
    public List<Card> sideboard() {
      return null;
    }

    @Override
    public Format format() {
      return null;
    }
  }

  private Card mapCard(CardNode cardNode) {
    return ImmutableCard.builder().name(cardNode.name()).build();
  }
}
