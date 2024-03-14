package ru.astieriait.bot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface ReplyKeyboardService {
    InlineKeyboardMarkup getStartKeyboard(boolean isManager);

    ReplyKeyboardMarkup getDefaultAdminKeyboard();
}
