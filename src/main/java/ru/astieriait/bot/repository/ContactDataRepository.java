package ru.astieriait.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astieriait.bot.model.ContactData;
import ru.astieriait.bot.model.id.ContactDataId;

@Repository
public interface ContactDataRepository extends JpaRepository<ContactData, ContactDataId> {
}
