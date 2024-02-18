package ru.astieriait.bot.message.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.astieriait.bot.message.handler.CarBotMessageHandler;
import ru.astieriait.bot.service.ReplyKeyboardService;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class StartMessageHandler implements CarBotMessageHandler {
    private final ReplyKeyboardService replyKeyboardService;

    @Override
    public BotApiMethod<?> handleMessage(Update update) {
        var sendMessage = new SendMessage(update.getMessage().getChatId().toString(), "Приветственная страница");
        sendMessage.enableMarkdown(true);
        sendMessage.setReplyMarkup(replyKeyboardService.getStartKeyboard());
        return sendMessage;
    }

    @Override
    public boolean isApplied(Update update) {
        log.info("Check message for apply to handler [StartMessageHandler]. isCallback={} text={}", update.hasCallbackQuery(), update.getMessage().getText());
        var result = Boolean.FALSE.equals(update.hasCallbackQuery()) && Objects.equals(update.getMessage().getText(), "/start");
        log.info("[StartMessageHandler] isApplied={}", result);
        return result;
    }
}
