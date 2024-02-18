package ru.astieriait.bot.message.handler.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.menubutton.SetChatMenuButton;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.menubutton.MenuButtonCommands;
import org.telegram.telegrambots.meta.api.objects.menubutton.MenuButtonWebApp;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.SentWebAppMessage;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import ru.astieriait.bot.constant.CarBotKeyboardButton;
import ru.astieriait.bot.message.handler.CarBotMessageHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class AvailableCarsMessageHandler implements CarBotMessageHandler {
    @Override
    public BotApiMethod<?> handleMessage(Update update) {
        WebAppInfo webAppInfo = new WebAppInfo();
        webAppInfo.setUrl("https://0572-92-100-50-182.ngrok-free.app");

        MenuButtonWebApp menu = MenuButtonWebApp.builder()
                .text("Актуальные")
                .webAppInfo(webAppInfo)
                .build();

        SetChatMenuButton setChatMenuButton = new SetChatMenuButton();
        setChatMenuButton.setMenuButton(menu);
        setChatMenuButton.setChatId(update.getMessage().getChatId().toString());
        return setChatMenuButton;
    }

    @Override
    public boolean isApplied(Update update) {
        log.info("Check message for apply to handler [AvailableCarsMessageHandler]. isCallback={} data={}", update.hasCallbackQuery(), update.hasCallbackQuery() ? update.getCallbackQuery().getData() : null);
        var result = Boolean.FALSE.equals(update.hasCallbackQuery()) &&
                Objects.equals(update.getMessage().getText(), CarBotKeyboardButton.AVAILABLE_CARS.getTitle());
        log.info("[AvailableCarsMessageHandler] isApplied={}", result);
        return result;
    }
}
