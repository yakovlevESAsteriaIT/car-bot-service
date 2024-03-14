package ru.astieriait.bot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import ru.astieriait.bot.config.property.CarBotProperties;
import ru.astieriait.bot.config.property.CarWebAppProperties;

@Configuration
@RequiredArgsConstructor
public class CarBotServiceConfig {
    @Bean
    public SetWebhook setWebhookInstance(CarBotProperties carBotProperties) {
        return SetWebhook.builder().url(carBotProperties.getWebhookPath()).build();
    }

    @Bean
    public CarBotProperties carBotProperties() {
        return new CarBotProperties();
    }

    @Bean
    public CarWebAppProperties carWebSiteProperties() {
        return new CarWebAppProperties();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .build();
    }
}
