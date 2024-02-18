package ru.astieriait.bot.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Getter
@Setter
@Component
public class RequestData {
    private String chatId;
}
