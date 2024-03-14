package ru.astieriait.bot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.astieriait.bot.model.Manager;
import ru.astieriait.bot.repository.ManagerRepository;
import ru.astieriait.bot.service.ManagerService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;

    @Override
    public Manager createManager() {
        Manager manager = new Manager();
        manager.setActive(true);
//        manager.setTelegramNickname();
        return null;
    }

    @Override
    public Manager findActiveManagerWithMinOrders() {
        return null;
    }

    @Override
    public boolean isManagerExists(String telegramNickname) {
        return managerRepository.existsById(telegramNickname);
    }
}
