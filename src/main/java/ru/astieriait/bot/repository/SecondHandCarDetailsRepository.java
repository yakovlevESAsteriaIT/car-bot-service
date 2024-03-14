package ru.astieriait.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astieriait.bot.model.SecondHandCarDetails;

import java.util.UUID;

@Repository
public interface SecondHandCarDetailsRepository extends JpaRepository<SecondHandCarDetails, UUID> {
}
