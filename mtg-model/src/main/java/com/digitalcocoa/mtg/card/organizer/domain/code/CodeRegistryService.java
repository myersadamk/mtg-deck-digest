package com.digitalcocoa.mtg.card.organizer.domain.code;

import com.digitalcocoa.mtg.card.organizer.repository.CodeEntity;
import com.digitalcocoa.mtg.card.organizer.repository.CodeRepository;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Collection;
import java.util.HashSet;
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
      CodeRepository repository, CacheBuilder<Object, Object> codeSetCacheBuilder) {
    this.repository = repository;
    this.codeSetCache = codeSetCacheBuilder.initialCapacity(600).build(cacheLoader());
  }

  public Mono<CodeSet> getCodeSet(Codifiable codeMeaning) {
    return readCache(codeMeaning).map(Mono::just).orElseGet(Mono::empty);
  }

  public Mono<Void> registerCodeValues(Codifiable meaning, String... codeValues) {
    return registerCodeValues(meaning, Set.of(codeValues));
  }

  public Mono<Void> registerCodeValues(Codifiable meaning, Set<String> codeValues) {
    final Set<String> existingCodeValues = new HashSet<>();

    return Flux.fromIterable(codeValues)
        .doFirst(
            () ->
                existingCodeValues.addAll(
                    repository.selectCodesByMeaning(meaning).stream()
                        .map(CodeEntity::value)
                        .collect(Collectors.toSet())))
        .filter(existingCodeValues::contains)
        .collectList()
        .map(Set::copyOf)
        .map(
            newValues ->
                getCodeSet(meaning)
                    .switchIfEmpty(registerCodeSets(meaning).then(getCodeSet(meaning)))
                    .map(codeSet -> repository.insertCodeValues(codeSet.id(), newValues)))
        .doOnTerminate(() -> codeSetCache.refresh(meaning))
        .then();
  }

  public Mono<Void> registerCodeSets(Codifiable... meanings) {
    return registerCodeSets(Set.of(meanings));
  }

  public Mono<Void> registerCodeSets(Set<Codifiable> meanings) {
    final Flux<Codifiable> unregisteredMeanings =
        Flux.fromIterable(meanings)
            .filter(meaning -> readCache(meaning).isEmpty());

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

              final Set<Code> codes =
                  entities.stream()
                      .filter(e -> e.value() != null && e.codeSetId() > 0)
                      .map(
                          e ->
                              new Code(
                                  e.codeValueId(), CardProperty.valueOf(e.meaning()), e.value()))
                      .collect(Collectors.toSet());

              return new CodeSet(codeSetID, meaning, codes);
            })
        .collect(Collectors.toSet())
        .stream()
        .findAny();
  }

  private Optional<CodeSet> readCache(Codifiable codifiable) {
    try {
      return Optional.of(codeSetCache.get(codifiable));
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
