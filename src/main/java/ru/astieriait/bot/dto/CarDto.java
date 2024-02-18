package ru.astieriait.bot.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {
    private Long id;
    private BigDecimal price;
    private String brand;
    private String model;
}
