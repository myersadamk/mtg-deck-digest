package com.digitalcocoa.mtg.catalog;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "client.mtgio")
public class CardClientProperties {
  public String baseUri;

  public String getBaseUri() {
    return baseUri;
  }

  public void setBaseUri(String baseUri) {
    this.baseUri = baseUri;
  }
}
