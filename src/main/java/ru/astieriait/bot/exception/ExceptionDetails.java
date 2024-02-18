package ru.astieriait.bot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionDetails {
    NO_MESSAGE_HANDLER_FOUND("CBS-001", "No message handler found for message=%s");

    private String code;
    private String message;
}
