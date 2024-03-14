package ru.astieriait.bot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.astieriait.bot.exception.CarBotServiceException;
import ru.astieriait.bot.exception.ExceptionDetails;
import ru.astieriait.bot.service.TelegramCarBotHelperService;

import java.util.Optional;

@Service
@Slf4j
public class TelegramCarBotHelperServiceImpl implements TelegramCarBotHelperService {
    @Override
    public String getChatId(Update update) {
        if (update.hasCallbackQuery()) {
            log.info("Get chatId from callback query.");
            return Optional.of(update)
                    .map(Update::getCallbackQuery)
                    .map(CallbackQuery::getMessage)
                    .map(Message::getChatId)
                    .map(Object::toString)
                    .orElseThrow(() -> new CarBotServiceException(ExceptionDetails.NO_CHAT_ID_PRESENT_IN_CALLBACK_QUERY));
        }
        log.info("Get chatId from message.");
        return Optional.of(update)
                .map(Update::getMessage)
                .map(Message::getChatId)
                .map(Object::toString)
                .orElseThrow(() -> new CarBotServiceException(ExceptionDetails.NO_CHAT_ID_PRESENT_IN_MESSAGE));
    }
}
