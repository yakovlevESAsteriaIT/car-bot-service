package ru.astieriait.bot.dto.order.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderCustomerContactData {
    private String phoneNumber;
    private String name;
    private String telegramNickname;
}
