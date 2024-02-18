package ru.astieriait.bot.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import ru.astieriait.bot.config.CarBotProperties;
import ru.astieriait.bot.helper.CarBotMessageHandlersHelper;
import ru.astieriait.bot.helper.LogHelper;
import ru.astieriait.bot.service.RequestData;

@Component
@Slf4j
public class CarTelegramWebhookBot extends SpringWebhookBot {
    private CarBotProperties carBotProperties;

    private CarBotMessageHandlersHelper carBotMessageHandlersHelper;
    private RequestData requestData;

    public CarTelegramWebhookBot(
            SetWebhook setWebhook,
            CarBotProperties carBotProperties,
            CarBotMessageHandlersHelper carBotMessageHandlersHelper,
            RequestData requestData
    ) {
        super(setWebhook);
        this.carBotProperties = carBotProperties;
        this.carBotMessageHandlersHelper = carBotMessageHandlersHelper;
        this.requestData = requestData;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        log.info("[START] handle message={}", LogHelper.toJson(update));
        requestData.setChatId(update.getMessage().getChatId().toString());
        var result = carBotMessageHandlersHelper.handleMessage(update);
        log.info("[FINISH] message handling finished successfully. result={}", LogHelper.toJson(result));
        return result;
    }

    @Override
    public String getBotPath() {
        return carBotProperties.getWebhookPath();
    }

    @Override
    public String getBotUsername() {
        return carBotProperties.getUsername();
    }

    @Override
    public String getBotToken() {
        return carBotProperties.getToken();
    }
}
