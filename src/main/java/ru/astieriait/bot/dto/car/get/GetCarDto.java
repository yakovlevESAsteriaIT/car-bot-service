package ru.astieriait.bot.dto.car.get;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetCarDto {
    private UUID id;
    private BigDecimal price;
    private String brand;
    private String model;
}
