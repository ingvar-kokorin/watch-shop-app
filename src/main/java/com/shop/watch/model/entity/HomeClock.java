package com.shop.watch.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class HomeClock extends Clock {
    private final double clockHeight;
    private final double clockWidth;

    public HomeClock(String brand,
                     String modelName,
                     MechanismType clockType,
                     BigDecimal price,
                     Colour colour,
                     String producingCountry,
                     LocalDate receiptDate,
                     int guarantee,
                     double clockHeight,
                     double clockWidth) {
        super(brand, modelName, clockType, price, colour, producingCountry, receiptDate, guarantee);
        this.clockHeight = clockHeight;
        this.clockWidth = clockWidth;
    }

    public double getClockHeight() {
        return clockHeight;
    }

    public double getClockWidth() {
        return clockWidth;
    }

    @Override
    public String toString() {
        return super.toString() + "Clock height: " + clockHeight + " | " +
                "Clock width" + clockWidth + " | ";
    }
}
