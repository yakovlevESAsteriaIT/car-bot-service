package ru.astieriait.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astieriait.bot.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String> {
}
