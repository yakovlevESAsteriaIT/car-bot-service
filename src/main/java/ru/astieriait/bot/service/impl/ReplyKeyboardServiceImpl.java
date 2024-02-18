package ru.astieriait.bot.service.impl;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.astieriait.bot.constant.CarBotKeyboardButton;
import ru.astieriait.bot.service.ReplyKeyboardService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyKeyboardServiceImpl implements ReplyKeyboardService {
    @Override
    public ReplyKeyboardMarkup getStartKeyboard() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(CarBotKeyboardButton.AVAILABLE_CARS.getTitle()));
        row1.add(new KeyboardButton(CarBotKeyboardButton.CONNECT_WITH_US.getTitle()));

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }
}
