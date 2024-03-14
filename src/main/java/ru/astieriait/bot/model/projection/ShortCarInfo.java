package ru.astieriait.bot.model.projection;

import java.math.BigDecimal;
import java.util.UUID;

public interface ShortCarInfo {
    UUID getId();

    String getBrand();

    String getModel();

    BigDecimal getPrice();
}
