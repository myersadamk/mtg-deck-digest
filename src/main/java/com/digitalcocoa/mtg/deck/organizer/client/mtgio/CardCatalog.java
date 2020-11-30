package com.digitalcocoa.mtg.deck.organizer.client.mtgio;

import static reactor.core.publisher.Flux.empty;
import static reactor.core.publisher.Flux.just;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public final class CardCatalog {

  private final MagicCardClient client;

  public CardCatalog() {
    this.client = new MagicCardClient();
  }

  @Autowired
  public CardCatalog(MagicCardClient client) {
    this.client = client;
  }

  public Flux<RawCard> getCards(Filters filters) {
    return client
        .getPage(1, filters)
        .flatMapMany(
            page -> {
              final Flux<Page> remainingPages =
                  page.nextPageNumber()
                      .map(
                          nextPageNumber -> {
                            final var lastPageNumber = page.lastPageNumber();

                            if (nextPageNumber.equals(lastPageNumber)) {
                              return client.getPage(lastPageNumber).flux();
                            }

                            return Flux.concat(
                                Flux.range(nextPageNumber, lastPageNumber).map(pageNumber -> client.getPage(pageNumber, filters)));
                          })
                      .orElse(empty());

              return Flux.merge(just(page), remainingPages)
                  .map(Page::cards)
                  .flatMap(Flux::fromIterable);
            });
  }
}
