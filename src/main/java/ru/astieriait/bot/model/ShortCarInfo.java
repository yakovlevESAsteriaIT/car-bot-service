package ru.astieriait.bot.model;

import java.math.BigDecimal;

public interface ShortCarInfo {
    Long getId();

    String getBrand();

    String getModel();

    BigDecimal getPrice();
}
