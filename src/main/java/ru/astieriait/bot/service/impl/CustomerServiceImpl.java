package ru.astieriait.bot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.astieriait.bot.dto.order.create.CreateOrderCustomerContactData;
import ru.astieriait.bot.model.Customer;
import ru.astieriait.bot.repository.CustomerRepository;
import ru.astieriait.bot.service.ContactDataService;
import ru.astieriait.bot.service.CustomerService;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ContactDataService contactDataService;

    @Override
    public Customer createCustomer(CreateOrderCustomerContactData contactData) {
        Customer customer = new Customer();
        customer.setTelegramNickname(contactData.getTelegramNickname());

        var savedCustomer = customerRepository.save(customer);
        contactDataService.createContactData(contactData.getName(), contactData.getPhoneNumber(), savedCustomer);
        return customer;
    }
}
