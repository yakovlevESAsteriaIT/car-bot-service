package ru.astieriait.bot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.astieriait.bot.dto.car.get.GetCarDto;
import ru.astieriait.bot.dto.car.id.CarDto;
import ru.astieriait.bot.model.Car;
import ru.astieriait.bot.model.projection.ShortCarInfo;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(target = "id", expression = "java(shortCarInfo.getId())")
    @Mapping(target = "price", expression = "java(shortCarInfo.getPrice())")
    @Mapping(target = "model", expression = "java(shortCarInfo.getModel())")
    @Mapping(target = "brand", expression = "java(shortCarInfo.getBrand())")
    GetCarDto toCarDto(ShortCarInfo shortCarInfo);

    CarDto toCarDto(Car car);
}
