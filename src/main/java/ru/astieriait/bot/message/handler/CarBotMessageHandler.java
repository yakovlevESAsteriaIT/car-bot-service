package ru.astieriait.bot.message.handler;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface CarBotMessageHandler {
    BotApiMethod<?> handleMessage(Update update);

    boolean isApplied(Update update);
}
