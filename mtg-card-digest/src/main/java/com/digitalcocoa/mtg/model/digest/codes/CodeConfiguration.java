package com.digitalcocoa.mtg.model.digest.codes;

import com.digitalcocoa.mtg.model.domain.code.CardProperty;
import com.digitalcocoa.mtg.catalog.client.mtgio.rest.MagicCard;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CodeConfiguration {

  @Bean
  public Set<CodeValueExtractor> extractors() {
    return Set.of(
        new MultiValuedExtractor(MagicCard::types, CardProperty.TYPE),
        new MultiValuedExtractor(MagicCard::subtypes, CardProperty.SUBTYPE),
        new MultiValuedExtractor(MagicCard::supertypes, CardProperty.SUPERTYPE));
  }
}
