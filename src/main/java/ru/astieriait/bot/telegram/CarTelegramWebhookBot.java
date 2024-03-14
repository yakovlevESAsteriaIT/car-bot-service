package ru.astieriait.bot.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import ru.astieriait.bot.config.property.CarBotProperties;
import ru.astieriait.bot.helper.CarBotMessageHandlersHelper;
import ru.astieriait.bot.helper.LogHelper;
import ru.astieriait.bot.service.RequestData;
import ru.astieriait.bot.service.TelegramCarBotHelperService;

@Component
@Slf4j
public class CarTelegramWebhookBot extends SpringWebhookBot {
    private CarBotProperties carBotProperties;

    private CarBotMessageHandlersHelper carBotMessageHandlersHelper;
    private TelegramCarBotHelperService telegramCarBotHelperService;
    private RequestData requestData;

    public CarTelegramWebhookBot(
            SetWebhook setWebhook,
            CarBotProperties carBotProperties,
            CarBotMessageHandlersHelper carBotMessageHandlersHelper,
            TelegramCarBotHelperService telegramCarBotHelperService,
            RequestData requestData
    ) {
        super(setWebhook);
        this.carBotProperties = carBotProperties;
        this.carBotMessageHandlersHelper = carBotMessageHandlersHelper;
        this.requestData = requestData;
        this.telegramCarBotHelperService = telegramCarBotHelperService;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        log.info("[START] handle bot message={}", LogHelper.toJson(update));
        requestData.setChatId(telegramCarBotHelperService.getChatId(update));
        var result = carBotMessageHandlersHelper.handleMessage(update);
        log.info("[FINISH] bot message handling finished successfully. result={}", LogHelper.toJson(result));
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
