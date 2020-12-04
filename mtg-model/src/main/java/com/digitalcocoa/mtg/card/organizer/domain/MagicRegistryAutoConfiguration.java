package com.digitalcocoa.mtg.card.organizer.domain;

import com.digitalcocoa.mtg.card.organizer.domain.card.CardRegistryService;
import com.digitalcocoa.mtg.card.organizer.domain.card.dao.CardRepository;
import com.digitalcocoa.mtg.card.organizer.domain.code.CodeRegistryService;
import com.digitalcocoa.mtg.card.organizer.domain.code.dao.CodeRepository;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// @ConditionalOnBean(NamedParameterJdbcTemplate.class)
@Import({
  CodeRegistryService.class,
  CodeRepository.class,
  CardRegistryService.class,
  CardRepository.class
})
public class MagicRegistryAutoConfiguration {

  @Bean
  //  @ConditionalOnMissingBean(name = "cardCacheBuilder")
  public CacheBuilder<Object, Object> cardCacheBuilder() {
    return defaultCache();
  }

  @Bean
  //  @ConditionalOnMissingBean(name = "codeSetCacheBuilder")
  public CacheBuilder<Object, Object> codeSetCacheBuilder() {
    return defaultCache();
  }

  private static CacheBuilder<Object, Object> defaultCache() {
    return CacheBuilder.newBuilder();
  }
}
