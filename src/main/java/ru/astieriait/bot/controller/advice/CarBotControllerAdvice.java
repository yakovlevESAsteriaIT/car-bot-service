package ru.astieriait.bot.controller.advice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.astieriait.bot.exception.CarBotServiceException;
import ru.astieriait.bot.service.RequestData;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class CarBotControllerAdvice {
    private final RequestData requestData;

    @ExceptionHandler(value = {CarBotServiceException.class})
    public ResponseEntity<BotApiMethod<?>> handleCarBotServiceException(CarBotServiceException carBotServiceException) {
        log.error("CarBotServiceException occurred. chatId={} exception message={} cause={}",
                requestData.getChatId(), carBotServiceException.getMessage(), carBotServiceException.getCause());
        return ResponseEntity.ok(new SendMessage(requestData.getChatId(), "Sorry, message can't be processed. Please, contact with administrator."));
    }
}
