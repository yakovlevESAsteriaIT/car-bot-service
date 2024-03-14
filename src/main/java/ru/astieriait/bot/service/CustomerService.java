package ru.astieriait.bot.service;

import ru.astieriait.bot.dto.order.create.CreateOrderCustomerContactData;
import ru.astieriait.bot.model.Customer;

public interface CustomerService {
    Customer createCustomer(CreateOrderCustomerContactData contactData);
}
