package ru.astieriait.bot.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.astieriait.bot.exception.CarBotServiceException;
import ru.astieriait.bot.exception.ExceptionDetails;
import ru.astieriait.bot.message.handler.CarBotMessageHandler;

import java.util.List;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class CarBotMessageHandlersHelper {
    private final List<CarBotMessageHandler> carBotMessageHandlers;

    public BotApiMethod<?> handleMessage(Update update) {
        return Stream.ofNullable(carBotMessageHandlers)
                .flatMap(List::stream)
                .filter(handler -> handler.isApplied(update))
                .findFirst()
                .map(handler -> handler.handleMessage(update))
                .orElseThrow(() -> new CarBotServiceException(ExceptionDetails.NO_MESSAGE_HANDLER_FOUND, update.getMessage()));
    }
}
