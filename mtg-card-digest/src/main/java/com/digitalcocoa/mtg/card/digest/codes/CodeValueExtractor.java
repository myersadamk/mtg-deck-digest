package com.digitalcocoa.mtg.card.digest.codes;

import com.digitalcocoa.mtg.card.organizer.domain.code.Codifiable;
import com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.MagicCard;
import reactor.core.publisher.Flux;

public interface CodeValueExtractor {
  Flux<String> extract(MagicCard card);

  Codifiable codifies();
}
