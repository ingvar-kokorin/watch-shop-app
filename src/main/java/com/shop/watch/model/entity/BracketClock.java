package com.shop.watch.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class BracketClock extends HomeClock {
    private final String lighting;

    public BracketClock(String brand,
                        String modelName,
                        MechanismType clockType,
                        BigDecimal price,
                        Colour colour,
                        String producingCountry,
                        LocalDate receiptDate,
                        int guarantee,
                        double clockHeight,
                        double clockWidth,
                        String lighting) {
        super(brand, modelName, clockType, price, colour, producingCountry, receiptDate, guarantee, clockHeight,
                clockWidth);
        this.lighting = lighting;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Lighting: " + lighting + " | ";
    }
}