package ru.astieriait.bot.service;

import ru.astieriait.bot.dto.order.create.CreateOrderRequestDto;
import ru.astieriait.bot.dto.order.create.CreateOrderResponseDto;
import ru.astieriait.bot.model.CarOrder;

public interface CarOrderService {
    CreateOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto);

    CarOrder saveOrder(CreateOrderRequestDto createOrderRequestDto);
}
