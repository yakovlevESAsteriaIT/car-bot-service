package ru.astieriait.bot.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties
@Getter
@Setter
public class CarBotProperties {
    @Value("${car.bot.webhook-path}")
    String webhookPath;
    @Value("${car.bot.token}")
    String token;
    @Value("${car.bot.name}")
    String name;
    @Value("${car.bot.username}")
    String username;
    @Value("${car.bot.api-url}")
    String apiUrl;
}
