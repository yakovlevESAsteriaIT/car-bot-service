package ru.astieriait.bot.dto.order.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequestDto {
    private UUID carId;
    private CreateOrderCustomerContactData contactData;
}
