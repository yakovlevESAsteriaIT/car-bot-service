package ru.astieriait.bot.dto.car.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SecondHandCarDetailsDto {
    private Integer ownersAmount;
    private Integer mileage;
}
