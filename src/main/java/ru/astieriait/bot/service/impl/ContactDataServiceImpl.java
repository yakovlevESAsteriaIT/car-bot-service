package ru.astieriait.bot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.astieriait.bot.model.ContactData;
import ru.astieriait.bot.model.Customer;
import ru.astieriait.bot.model.id.ContactDataId;
import ru.astieriait.bot.repository.ContactDataRepository;
import ru.astieriait.bot.service.ContactDataService;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactDataServiceImpl implements ContactDataService {
    private final ContactDataRepository contactDataRepository;

    @Override
    public ContactData createContactData(String name, String phoneNumber, Customer customer) {
        ContactData contactData = new ContactData();
        contactData.setId(new ContactDataId(phoneNumber, name));
        contactData.setCustomer(customer);
        return contactDataRepository.save(contactData);
    }
}
