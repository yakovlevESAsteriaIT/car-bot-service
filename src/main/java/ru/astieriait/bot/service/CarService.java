package ru.astieriait.bot.service;

import ru.astieriait.bot.dto.CarCategory;
import ru.astieriait.bot.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> getCars(CarCategory carCategory, Integer page, Integer amount);
}
