package ru.astieriait.bot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CarBotKeyboardButton {
    AVAILABLE_CARS("доступные машины"),
    CONNECT_WITH_US("связаться с нами"),
    ADD_CAR("добавить машину"),
    ;

    private String title;
}
