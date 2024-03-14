package ru.astieriait.bot.message.handler.impl.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.astieriait.bot.constant.CarBotKeyboardButton;
import ru.astieriait.bot.message.handler.CarBotMessageHandler;
import ru.astieriait.bot.service.ManagerService;
import ru.astieriait.bot.service.ReplyKeyboardService;
import ru.astieriait.bot.statemachine.service.CarBotStateMachineService;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddCarMessageHandler implements CarBotMessageHandler {
    private final ManagerService managerService;
    private final ReplyKeyboardService replyKeyboardService;
    private final CarBotStateMachineService carBotStateMachineService;

    @Override
    public BotApiMethod<?> handleMessage(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        sendMessage.setText("Добавление новой машины в базу данных.\n Введите марку автомобиля");
        sendMessage.setReplyMarkup(replyKeyboardService.getDefaultAdminKeyboard());
        carBotStateMachineService.start(update.getCallbackQuery().getMessage().getChat().getUserName());
        return sendMessage;
    }

    @Override
    public boolean isApplied(Update update) {
        log.info("Check message for apply to handler [AddCarMessageHandler]. isCallback={} data={}", update.hasCallbackQuery(), update.hasCallbackQuery() ? update.getCallbackQuery().getData() : null);
        var result = Boolean.TRUE.equals(update.hasCallbackQuery())
                && managerService.isManagerExists(update.getCallbackQuery().getMessage().getChat().getUserName())
                && Objects.equals(update.getCallbackQuery().getData(), CarBotKeyboardButton.ADD_CAR.name());
        log.info("[AddCarMessageHandler] isApplied={}", result);
        return result;
    }
}
