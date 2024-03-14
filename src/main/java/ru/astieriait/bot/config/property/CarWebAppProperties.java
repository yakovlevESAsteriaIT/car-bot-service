package ru.astieriait.bot.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Getter
@Setter
public class CarWebAppProperties {
    @Value("${car.web-app.host}")
    String webAppHost;
}
