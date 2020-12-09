package com.digitalcocoa.mtg.catalog;

import static reactor.core.publisher.Flux.empty;
import static reactor.core.publisher.Flux.just;

import com.digitalcocoa.mtg.catalog.client.mtgio.rest.MagicCard;
import com.digitalcocoa.mtg.catalog.client.mtgio.rest.MagicCardClient;
import com.digitalcocoa.mtg.catalog.client.mtgio.rest.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public final class CardCatalog {

  private final MagicCardClient client;

  @Autowired
  public CardCatalog(MagicCardClient client) {
    this.client = client;
  }

  public Flux<MagicCard> getCards(Filters filters) {
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
                                Flux.range(nextPageNumber, lastPageNumber)
                                    .map(pageNumber -> client.getPage(pageNumber, filters)));
                          })
                      .orElse(empty());

              return Flux.merge(just(page), remainingPages)
                  .map(Page::cards)
                  .flatMap(Flux::fromIterable);
            });
  }
}
