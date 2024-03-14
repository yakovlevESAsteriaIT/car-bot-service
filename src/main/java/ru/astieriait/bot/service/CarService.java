package ru.astieriait.bot.service;

import ru.astieriait.bot.dto.car.get.CarCategory;
import ru.astieriait.bot.dto.car.get.GetCarDto;
import ru.astieriait.bot.dto.car.id.CarDto;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<GetCarDto> getCars(CarCategory carCategory, Integer page, Integer amount);

    CarDto getCarDetails(UUID carId);
}
