package ru.astieriait.bot.exception;

public class CarBotServiceException extends RuntimeException {
    private static final String ERR_MSG_FORMAT = "code=%s message=%s";
    private ExceptionDetails exceptionDetails;

    public CarBotServiceException(ExceptionDetails exceptionDetails, Throwable throwable) {
        super(String.format(ERR_MSG_FORMAT, exceptionDetails.getCode(), exceptionDetails.getMessage()), throwable);
    }

    public CarBotServiceException(ExceptionDetails exceptionDetails, Object detail) {
        super(String.format(ERR_MSG_FORMAT, exceptionDetails.getCode(), String.format(exceptionDetails.getMessage(), detail)));
    }

    public CarBotServiceException(ExceptionDetails exceptionDetails) {
        super(String.format(ERR_MSG_FORMAT, exceptionDetails.getCode(), exceptionDetails.getMessage()));
    }

    public CarBotServiceException(ExceptionDetails exceptionDetails, Object detail, Throwable throwable) {
        super(String.format(ERR_MSG_FORMAT, exceptionDetails.getCode(), String.format(exceptionDetails.getMessage(), detail), throwable));
    }
}
