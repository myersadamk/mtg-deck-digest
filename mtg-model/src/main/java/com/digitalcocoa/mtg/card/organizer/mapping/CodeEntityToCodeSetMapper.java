package com.digitalcocoa.mtg.card.organizer.mapping;

// @Mapper
public class CodeEntityToCodeSetMapper {

  //  Set<CodeSet> toCodeSet(Collection<CodeEntity> codeEntities) {
  //    return codeEntities.stream()
  //        .collect(Collectors.groupingBy(CodeEntity::meaning))
  //        .entrySet()
  //        .stream()
  //        .map(
  //            entry -> {
  //              final List<CodeEntity> entities = entry.getValue();
  //
  //              final Integer codeSetID =
  //                  entities.stream().findFirst().map(CodeEntity::codeSetId).orElseThrow();
  //              final CodeMeaning meaning = CodeMeaning.valueOf(entry.getKey());
  //              final Set<Code> codes =
  //                  entities.stream()
  //                      .map(
  //                          e ->
  //                              new Code(
  //                                  e.codeValueId(), CodeMeaning.valueOf(e.meaning()), e.value()))
  //                      .collect(Collectors.toSet());
  //
  //              return new CodeSet(codeSetID, meaning, codes);
  //            })
  //        .collect(Collectors.toSet());
  //  }
}
