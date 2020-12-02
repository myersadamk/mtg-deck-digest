package com.digitalcocoa.mtg.client.organizer.client.mtgio.rest;
;
import static org.springframework.http.HttpHeaders.LINK;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

// TODO: alllll of this header/URI related stuff, both here and in the client, can be made into a
// component that can be unit tested apart
// from all of the network I/O stuff.
final class PagingProtocol {

  private static final String LINK_RELATIONSHIP_PATTERN = "<([\\w:/\\.\\d\\?=]+)>; rel=\"%s\"";
  private static final Pattern NEXT = createLinkPattern("next");
  private static final Pattern LAST = createLinkPattern("last");

  static Pattern createLinkPattern(String relationship) {
    return Pattern.compile(String.format(LINK_RELATIONSHIP_PATTERN, relationship));
  }

  static Optional<UriComponents> getLastPageUri(final HttpHeaders headers) {
    return getLink(headers, LAST);
  }

  static Optional<UriComponents> getNextPageUri(final HttpHeaders headers) {
    return getLink(headers, NEXT);
  }

  private static Optional<UriComponents> getLink(final HttpHeaders headers, final Pattern pattern) {
    final List<String> headerContent = headers.get(LINK);
    if (headerContent == null) {
      return Optional.empty();
    }

    return headerContent.stream()
        .map(
            content -> {
              final Matcher matcher = pattern.matcher(content);
              if (matcher.find() && matcher.groupCount() >= 1) {
                return matcher.group(1);
              }
              return null;
            })
        .filter(Objects::nonNull)
        .findFirst()
        .map(uri -> UriComponentsBuilder.fromUriString(uri).build());
  }

  private PagingProtocol() {}
}
