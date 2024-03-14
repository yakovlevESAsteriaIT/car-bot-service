package ru.astieriait.bot.message.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.astieriait.bot.message.handler.CarBotMessageHandler;
import ru.astieriait.bot.service.ManagerService;
import ru.astieriait.bot.service.ReplyKeyboardService;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class StartMessageHandler implements CarBotMessageHandler {
    private final ReplyKeyboardService replyKeyboardService;
    private final ManagerService managerService;

    @Override
    public BotApiMethod<?> handleMessage(Update update) {
        var sendMessage = new SendMessage(update.getMessage().getChatId().toString(), "Приветственная страница");
        sendMessage.enableMarkdown(true);
        sendMessage.setReplyMarkup(replyKeyboardService.getStartKeyboard(managerService.isManagerExists(update.getMessage().getChat().getUserName())));
        return sendMessage;
    }

    @Override
    public boolean isApplied(Update update) {
        var messageText = Optional.of(update)
                .map(Update::getMessage)
                .map(Message::getText)
                .orElse(StringUtils.EMPTY);
        log.info("Check message for apply to handler [StartMessageHandler]. isCallback={} text={}", update.hasCallbackQuery(), messageText);
        var result = Boolean.FALSE.equals(update.hasCallbackQuery())
                && Objects.equals(messageText, "/start");
        log.info("[StartMessageHandler] isApplied={}", result);
        return result;
    }
}
