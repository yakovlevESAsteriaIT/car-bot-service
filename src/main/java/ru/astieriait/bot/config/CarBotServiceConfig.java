package ru.astieriait.bot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

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
}
