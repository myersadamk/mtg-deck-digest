package com.digitalcocoa.mtg.model.organizer.client.mtgio;

import static org.assertj.core.api.Assertions.assertThat;

import com.digitalcocoa.mtg.catalog.CardCatalog;
import com.digitalcocoa.mtg.catalog.CardCatalogAutoConfiguration;
import com.digitalcocoa.mtg.catalog.client.mtgio.rest.MagicCardClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.web.reactive.function.client.WebClient;

class CardCatalogAutoConfigurationTest {

  private final ApplicationContextRunner contextRunner =
      new ApplicationContextRunner()
          .withConfiguration(AutoConfigurations.of(CardCatalogAutoConfiguration.class));

  @Test
  void configuresWithUriDefined() {
    contextRunner
        .withPropertyValues("client.mtgio.base-uri=http://somewhere.com")
        .run(
            context -> {
              assertThat(context).hasSingleBean(WebClient.class);
              assertThat(context).hasSingleBean(CardCatalog.class);
              assertThat(context).hasSingleBean(MagicCardClient.class);
            });
  }
}
