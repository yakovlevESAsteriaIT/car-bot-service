package ru.astieriait.bot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionDetails {
    NO_MESSAGE_HANDLER_FOUND("CBS-001", "No message handler found for message=%s"),
    NO_CAR_FOUND("CBS-002", "No one car found by id=%s"),
    NO_MANAGER_FOUND("CBS-003", "No one manager found by id=%s"),
    VIDEO_TELEGRAM_DOWNLOAD_FAILED("CBS-004", "Telegram video(filePath=%s) download failed"),
    NO_CHAT_ID_PRESENT_IN_CALLBACK_QUERY("CBS-005", "No chatId is present in callback query"),
    NO_CHAT_ID_PRESENT_IN_MESSAGE("CBS-006", "No chatId is present in message"),
    ;

    private String code;
    private String message;
}
