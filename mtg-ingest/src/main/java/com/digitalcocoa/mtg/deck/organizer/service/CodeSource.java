package com.digitalcocoa.mtg.deck.organizer.service;

import com.digitalcocoa.mtg.deck.organizer.repository.CodeSetRepository;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import reactor.core.publisher.Mono;

public class CodeSource {

  public record CodeValue(int ID, String value) {}

  public record CodeSet(int ID, String meaning, Set<CodeValue> codeValues) {
    public static CodeSet unloaded(int ID, String meaning) {
      return new CodeSet(ID, meaning, Set.of());
    }
  }
  //  public record CodeSet(Integer ID, String meaning, Set<Code> codes) {}

  private final CodeSetRepository repository;
  private final ConcurrentHashMap<String, CodeSet> codeSetCache;

  public CodeSource(CodeSetRepository repository) {
    this.repository = repository;
  }

  public Mono<Void> loadCodeMeaning(String meaning) {
    //    repository.
  }
  //  public CodeSet getCodeSet(String meaning) {
  //  }
}
