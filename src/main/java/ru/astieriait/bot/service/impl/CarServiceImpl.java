package ru.astieriait.bot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.astieriait.bot.dto.CarCategory;
import ru.astieriait.bot.dto.CarDto;
import ru.astieriait.bot.mapper.CarMapper;
import ru.astieriait.bot.model.ShortCarInfo;
import ru.astieriait.bot.repository.CarRepository;
import ru.astieriait.bot.repository.SecondHandCarDetailsRepository;
import ru.astieriait.bot.service.CarService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final SecondHandCarDetailsRepository secondHandCarDetailsRepository;
    private final CarMapper carMapper;

    @Override
    public List<CarDto> getCars(CarCategory carCategory, Integer page, Integer amount) {
        log.info("[START] [HTTP frontend http request] Request for /cars. carCategory={} page={} amount={}",
                carCategory, page, amount);
        var cars = Stream.ofNullable(getShortCarInfo(carCategory, page, amount))
                .flatMap(List::stream)
                .map(carMapper::toCarDto)
                .collect(Collectors.toList());
        log.info("[FINISH] [HTTP frontend http request] Request for /cars processed successfully. cars={}",
                cars);
        return cars;
    }

    private List<ShortCarInfo> getShortCarInfo(CarCategory carCategory, Integer page, Integer amount) {
        switch (carCategory) {
            case ALL -> {
                return carRepository.getAllShortCarsInfo(amount, page * amount);
            }
            case NEW -> {
                return carRepository.getNewShortCarsInfo(amount, page * amount);
            }
            case SECOND_HAND -> {
                return carRepository.getSecondHandShortCarsInfo(amount, page * amount);
            }
            default -> {
                return List.of();
            }
        }
    }
}
