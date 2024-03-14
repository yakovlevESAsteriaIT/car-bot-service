package ru.astieriait.bot.dto.car.get;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CarCategory {
    ALL,
    NEW,
    SECOND_HAND;

    @JsonValue
    public String getName() {
        return this.name();
    }
}
