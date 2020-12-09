package com.digitalcocoa.mtg.model.digest.codes;

import com.digitalcocoa.mtg.model.domain.code.Codifiable;
import com.digitalcocoa.mtg.catalog.client.mtgio.rest.MagicCard;
import reactor.core.publisher.Flux;

public interface CodeValueExtractor {
  Flux<String> extract(MagicCard card);

  Codifiable codifies();
}
