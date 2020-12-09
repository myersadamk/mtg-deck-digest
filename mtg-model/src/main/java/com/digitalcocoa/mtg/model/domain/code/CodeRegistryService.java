package com.digitalcocoa.mtg.model.domain.code;

import com.digitalcocoa.mtg.model.domain.code.dao.CodeEntity;
import com.digitalcocoa.mtg.model.domain.code.dao.CodeRepository;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public final class CodeRegistryService {

  private final LoadingCache<Codifiable, CodeSet> codeSetCache;
  private final CodeRepository repository;

  public CodeRegistryService(
      CodeRepository repository, CacheBuilder<Object, Object> cardCacheBuilder) {
    this.repository = repository;
    this.codeSetCache = cardCacheBuilder.initialCapacity(6000).build(cacheLoader());
  }

  public Mono<CodeSet> getCodeSet(Codifiable codeMeaning) {
    return readCache(codeMeaning).map(Mono::just).orElseGet(Mono::empty);
  }

  public Mono<Integer> registerCodeValues(Codifiable meaning, String... codeValues) {
    return registerCodeValues(meaning, Set.of(codeValues));
  }

  public Mono<Integer> registerCodeValues(Codifiable meaning, Set<String> codeValues) {
    return getCodeSet(meaning)
        .switchIfEmpty(registerCodeSets(meaning).then(getCodeSet(meaning)))
        .flatMap(
            codeSet -> {
              final Set<String> existingCodeValues = codeSet.getCodeValues();
              return Flux.fromIterable(codeValues)
                  .filter(value -> !existingCodeValues.contains(value))
                  .collectList()
                  .map(Set::copyOf)
                  .flatMap(
                      newCodeValues ->
                          newCodeValues.isEmpty()
                              ? Mono.just(0)
                              : repository.insertCodeValues(codeSet.id(), newCodeValues));
            })
        .doOnTerminate(() -> codeSetCache.refresh(meaning));
  }

  public Mono<Void> registerCodeSets(Codifiable... meanings) {
    return registerCodeSets(Set.of(meanings));
  }

  public Mono<Void> registerCodeSets(Set<Codifiable> meanings) {
    final Flux<Codifiable> unregisteredMeanings =
        Flux.fromIterable(meanings).filter(meaning -> readCache(meaning).isEmpty());

    return unregisteredMeanings
        .doOnNext(System.out::println)
        .map(Codifiable::getMeaning)
        .collectList()
        .map(Set::copyOf)
        .flatMap(repository::insertCodeSets)
        .thenMany(unregisteredMeanings)
        .doOnNext(codeSetCache::refresh)
        .then();
  }

  private CacheLoader<Codifiable, CodeSet> cacheLoader() {
    return CacheLoader.from(
        (Codifiable meaning) -> {
          final List<CodeEntity> codes = repository.selectCodesByMeaning(meaning);
          return mapCodeEntities(codes).orElseThrow();
        });
  }

  private Optional<CodeSet> readCache(Codifiable codifiable) {
    try {
      return Optional.of(codeSetCache.get(codifiable));
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  private static Optional<CodeSet> mapCodeEntities(Collection<CodeEntity> codeEntities) {
    if (codeEntities.isEmpty()) {
      return Optional.empty();
    }

    return codeEntities.stream()
        .collect(Collectors.groupingBy(CodeEntity::meaning))
        .entrySet()
        .stream()
        .map(
            entry -> {
              final List<CodeEntity> entities = entry.getValue();
              final Integer codeSetID =
                  entities.stream().findFirst().map(CodeEntity::codeSetId).orElseThrow();

              final CardProperty meaning = CardProperty.valueOf(entry.getKey().toUpperCase());
              return new CodeSet(codeSetID, meaning, CodeEntity.toCodes(entities));
            })
        .collect(Collectors.toSet())
        .stream()
        .findAny();
  }
}
