package ru.astieriait.bot.service;

import ru.astieriait.bot.model.ContactData;
import ru.astieriait.bot.model.Customer;

public interface ContactDataService {
    ContactData createContactData(String name, String phoneNumber, Customer customer);
}
