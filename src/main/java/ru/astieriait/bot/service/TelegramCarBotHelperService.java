package ru.astieriait.bot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramCarBotHelperService {
    String getChatId(Update update);
}
