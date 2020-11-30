package com.digitalcocoa.mtg.deck.organizer.client.mtgio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
//@EnableJdbcAuditing !
public class MagicTheGatheringApiConfig {

  @Bean
  public WebClient webClient() {
    return WebClient.builder()
        .codecs(configurer -> configurer
            .defaultCodecs()
            .maxInMemorySize(16 * 1024 * 1024))
        .build();
  }

//  @Bean
//  public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
//    return new NamedParameterJdbcTemplate(dataSource);
//  }

//  @Bean
//  @Scope("prototype")
//  public ObjectMapper objectMapper() {
//    return new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false).findAndRegisterModules();
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
