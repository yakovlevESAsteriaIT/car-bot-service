package ru.astieriait.bot.service;

import ru.astieriait.bot.model.Manager;

public interface ManagerService {
    Manager createManager();
    Manager findActiveManagerWithMinOrders();
    boolean isManagerExists(String telegramNickname);
}
