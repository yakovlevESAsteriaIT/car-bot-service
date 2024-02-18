package ru.astieriait.bot.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.astieriait.bot.telegram.CarTelegramWebhookBot;

@RestController
@AllArgsConstructor
@Slf4j
public class CarBotController {
    private final CarTelegramWebhookBot carTelegramWebhookBot;

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return carTelegramWebhookBot.onWebhookUpdateReceived(update);
    }
}