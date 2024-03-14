package ru.astieriait.bot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.astieriait.bot.dto.order.create.CreateOrderRequestDto;
import ru.astieriait.bot.dto.order.create.CreateOrderResponseDto;
import ru.astieriait.bot.model.CarOrder;
import ru.astieriait.bot.repository.OrderRepository;
import ru.astieriait.bot.service.CustomerService;
import ru.astieriait.bot.service.ManagerService;
import ru.astieriait.bot.service.CarOrderService;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarOrderServiceImpl implements CarOrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ManagerService managerService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public CreateOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public CarOrder saveOrder(CreateOrderRequestDto createOrderRequestDto) {
        CarOrder carOrder = new CarOrder();
        carOrder.setHandled(false);
        carOrder.setCustomer(customerService.createCustomer(createOrderRequestDto.getContactData()));
        carOrder.setManager(managerService.createManager());
        return orderRepository.save(carOrder);
    }
}
