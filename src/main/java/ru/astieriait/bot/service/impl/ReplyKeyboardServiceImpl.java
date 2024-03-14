package ru.astieriait.bot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import ru.astieriait.bot.config.property.CarWebAppProperties;
import ru.astieriait.bot.constant.CarBotKeyboardButton;
import ru.astieriait.bot.service.ReplyKeyboardService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyKeyboardServiceImpl implements ReplyKeyboardService {
    private static final String CAR_BOT_GET_CARS_URL_FORMAT = "%s/";
    private final CarWebAppProperties carWebAppProperties;

    @Override
    public InlineKeyboardMarkup getStartKeyboard(boolean isManager) {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();

        WebAppInfo webAppInfo = new WebAppInfo();
        webAppInfo.setUrl(String.format(CAR_BOT_GET_CARS_URL_FORMAT, carWebAppProperties.getWebAppHost()));

        row1.add(InlineKeyboardButton.builder()
                .text(CarBotKeyboardButton.AVAILABLE_CARS.getTitle())
                .webApp(webAppInfo)
                .build());
        row1.add(InlineKeyboardButton.builder()
                .text(CarBotKeyboardButton.CONNECT_WITH_US.getTitle())
                .callbackData(CarBotKeyboardButton.CONNECT_WITH_US.name())
                .build());
        keyboard.add(row1);

        if (isManager) {
            List<InlineKeyboardButton> row2 = new ArrayList<>();
            row2.add(InlineKeyboardButton.builder()
                    .text(CarBotKeyboardButton.ADD_CAR.getTitle())
                    .callbackData(CarBotKeyboardButton.ADD_CAR.name())
                    .build());
            keyboard.add(row2);
        }

        return InlineKeyboardMarkup.builder()
                .clearKeyboard()
                .keyboard(keyboard)
                .build();
    }

    @Override
    public ReplyKeyboardMarkup getDefaultAdminKeyboard() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(
                KeyboardButton.builder()
                        .text("Пропустить")
                .build()
        );
        row1.add(
                KeyboardButton.builder()
                        .text("Отменить")
                        .build()
        );
        return ReplyKeyboardMarkup.builder()
                .keyboardRow(row1)
                .build();
    }
}
