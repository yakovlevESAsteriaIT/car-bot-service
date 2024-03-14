package ru.astieriait.bot.dto.car.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private Integer power;
    private String description;
    private BigDecimal price;
    private Boolean fourWheelDrive;
    private SecondHandCarDetailsDto secondHandCarDetails;
}
