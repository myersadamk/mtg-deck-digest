package com.digitalcocoa.mtg.model.domain.card;

import com.digitalcocoa.mtg.model.domain.card.dao.CardAttributeEntity;
import com.digitalcocoa.mtg.model.domain.card.dao.CardAttributeRepository;
import com.digitalcocoa.mtg.model.domain.card.dao.CardRepository;
import com.digitalcocoa.mtg.model.domain.card.dao.CardRepository.CardEntity;
import com.digitalcocoa.mtg.model.domain.code.Code;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Collection;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardRegistryService {

  private final LoadingCache<String, Card> cardCache;
  private final CardRepository cardRepository;
  private final CardAttributeRepository attributeRepository;

  public CardRegistryService(
      CardRepository cardRepository,
      CardAttributeRepository attributeRepository,
      CacheBuilder<Object, Object> cardCacheBuilder) {
    this.cardRepository = cardRepository;
    this.attributeRepository = attributeRepository;
    this.cardCache = cardCacheBuilder.build(cacheLoader());
  }

  public Mono<Card> getCard(String cardName) {
    return readCache(cardName);
  }

  public Flux<Card> getCards(Collection<String> cardNames) {
    return Flux.fromIterable(cardRepository.selectCardsByTitle(cardNames))
        .doOnNext(card -> cardCache.put(card.name(), card));
  }

  public boolean isLoaded(String cardName) {
    return cardCache.asMap().containsKey(cardName);
  }

  public Mono<Void> registerAttributes(Card card, Collection<Code> attributes) {
    if (attributes.isEmpty()) {
      return Mono.empty();
    }

    final Mono<Card> flux = card.id() == null ? getCard(card.name()) : Mono.just(card);

    return flux.map(c -> CardAttributeEntity.forAttributes(c.id(), attributes))
        .flatMapMany(Flux::fromIterable)
        .collectList()
        .doOnNext(attributeRepository::insertCardAttributes)
        .switchIfEmpty(Mono.error(new RuntimeException("This card doesn't exist!")))
        .then();
  }

  public Flux<NewCard> registerNewCards(Collection<NewCard> cards) {
    return Flux.fromIterable(cards)
        .map(card -> new CardEntity(null, card.name(), card.type(), card.manaCost(), card.cmc()))
        .collectList()
        .checkpoint("Mapped new cards", true)
        .doOnNext(cardRepository::insertCards)
        .checkpoint("Finished inserting base cards")
        .thenMany(Flux.fromIterable(cards));
  }

  private CacheLoader<String, Card> cacheLoader() {
    return CacheLoader.from(cardName -> cardRepository.selectCardByName(cardName).orElse(null));
  }

  private Mono<Card> readCache(String cardName) {
    return Mono.fromCallable(() -> cardCache.get(cardName)).onErrorResume(error -> Mono.empty());
  }
}
