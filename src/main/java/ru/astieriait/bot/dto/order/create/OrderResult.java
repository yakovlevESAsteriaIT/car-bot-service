package ru.astieriait.bot.dto.order.create;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum OrderResult {
    SUCCESS,
    FAILED,
    ;

    @JsonValue
    public String getName() {
        return this.name();
    }
}
