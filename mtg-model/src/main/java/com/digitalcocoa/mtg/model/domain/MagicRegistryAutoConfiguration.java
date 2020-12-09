package com.digitalcocoa.mtg.model.domain;

import com.digitalcocoa.mtg.model.domain.card.CardRegistryService;
import com.digitalcocoa.mtg.model.domain.card.dao.CardAttributeRepository;
import com.digitalcocoa.mtg.model.domain.card.dao.CardRepository;
import com.digitalcocoa.mtg.model.domain.code.CodeRegistryService;
import com.digitalcocoa.mtg.model.domain.code.dao.CodeRepository;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
  CodeRegistryService.class,
  CodeRepository.class,
  CardRegistryService.class,
  CardRepository.class,
  CardAttributeRepository.class,
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
