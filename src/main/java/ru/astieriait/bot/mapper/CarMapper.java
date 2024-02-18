package ru.astieriait.bot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.astieriait.bot.dto.CarDto;
import ru.astieriait.bot.model.ShortCarInfo;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(target = "id", expression = "java(shortCarInfo.getId())")
    @Mapping(target = "price", expression = "java(shortCarInfo.getPrice())")
    @Mapping(target = "model", expression = "java(shortCarInfo.getModel())")
    @Mapping(target = "brand", expression = "java(shortCarInfo.getBrand())")
    CarDto toCarDto(ShortCarInfo shortCarInfo);
}
