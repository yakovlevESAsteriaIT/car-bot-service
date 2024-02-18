package ru.astieriait.bot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface ReplyKeyboardService {
    ReplyKeyboardMarkup getStartKeyboard();
}
