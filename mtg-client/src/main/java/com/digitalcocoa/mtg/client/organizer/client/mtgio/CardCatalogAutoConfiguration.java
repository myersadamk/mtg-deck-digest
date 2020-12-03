package com.digitalcocoa.mtg.client.organizer.client.mtgio;

import com.digitalcocoa.mtg.client.organizer.client.mtgio.rest.MagicCardClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConditionalOnClass(WebClient.class)
@ConditionalOnProperty(name = "client.mtgio.base-uri")
@EnableConfigurationProperties(CardClientProperties.class)
@Import({CardCatalog.class, MagicCardClient.class})
public class CardCatalogAutoConfiguration {

  @Bean
  public WebClient mtgApiWebClient(@Value("${client.mtgio.base-uri}") String baseUri) {
    return WebClient.builder()
        .baseUrl(baseUri)
        .defaultHeader(
            HttpHeaders.ACCEPT,
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_UTF8_VALUE)
        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
        .build();
  }

  //  @Bean
  //  public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
  //    return new NamedParameterJdbcTemplate(dataSource);
  //  }

  //  @Bean
  //  @Scope("prototype")
  //  public ObjectMapper objectMapper() {
  //    return new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES,
  // false).findAndRegisterModules();
  //  }

  //  @Bean
  //  public BodyParser jsonDeserializer(ObjectMapper objectMapper) {
  //    return new BodyParser(objectMapper);
  //  }

  //  @Bean(name = "cardPagesCacheManager")
  //  public CacheManager cardPagesCacheManager() {
  //    return new ConcurrentMapCacheManager("cardPages");
  //  }

  //  @Bean
  //  public Converter<RawCard, Card> rawCardToCardMapper() {
  //    return new RawCardToCardMapper();
  //  }

  //  @Bean
  //  public MagicCardClient cardsClient(
  //      @Value("${api.mtgio.cards.uri}") String baseUri, WebClient webClient) {
  //    return new MagicCardClient(baseUri, webClient);
  //  }

  //  @Bean
  //  public CardCatalog cardCatalog(MagicCardClient cardsClient) {
  //    return new CardCatalog(cardsClient);
  //  }
}
