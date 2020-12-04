package com.digitalcocoa.mtg.card.organizer.domain.card;

import com.digitalcocoa.mtg.card.organizer.domain.card.dao.CardRepository;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CardRegistryService {

  private final LoadingCache<String, Card> cardCache;
  private final CardRepository repository;

  public CardRegistryService(
      CacheBuilder<Object, Object> cardCacheBuilder, CardRepository repository) {
    this.repository = repository;
    this.cardCache = cardCacheBuilder.build(cacheLoader());
  }

  public Mono<Card> getCard(String cardName) {
    return readCache(cardName);
  }

  public Mono<Integer> registerCard(NewCard card) {
    return readCache(card.name())
        .map(ignored -> 0)
        .switchIfEmpty(repository.insertCards(card))
        .doOnSuccess(inserts -> cardCache.refresh(card.name()));
  }

  private CacheLoader<String, Card> cacheLoader() {
    return CacheLoader.from(cardName -> repository.getCardByName(cardName).orElse(null));
  }

  private Mono<Card> readCache(String cardName) {
    return Mono.fromCallable(() -> cardCache.get(cardName))
        .onErrorResume(error -> Mono.empty());
  }
}
