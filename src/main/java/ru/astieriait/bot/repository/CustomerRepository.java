package ru.astieriait.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astieriait.bot.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
