package com.digitalcocoa.mtg.catalog.client.mtgio.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

class PagingProtocolTest {

    private static final HttpHeaders LINK_HEADERS = new HttpHeaders();
    private static final String NEXT_URI = "https://api.magicthegathering.io/v1/cards?page=2&sets=KTK";
    private static final String LAST_URI = "https://api.magicthegathering.io/v1/cards?page=3&sets=KTK";
    static {
      LINK_HEADERS.add("link", String.format("<%s>; rel=\"last\", <%s>; rel=\"next\"", LAST_URI, NEXT_URI));
    }

  @Test
  void nextPage() {
    assertThat(PagingProtocol.getNextPageUri(LINK_HEADERS)).contains(UriComponentsBuilder.fromHttpUrl(NEXT_URI).build());
  }
}