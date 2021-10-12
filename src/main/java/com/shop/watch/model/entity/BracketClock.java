package com.shop.watch.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BracketClock extends ClockForHome {
    private String lighting;

    public BracketClock(String brand,
                        String modelName,
                        Mechanism clockType,
                        BigDecimal price,
                        Colour colour,
                        String producingCountry,
                        LocalDate dateOfReceipt,
                        int guarantee,
                        double clockHeight,
                        double clockWidth, String lighting) {
        super(brand, modelName, clockType, price, colour, producingCountry, dateOfReceipt, guarantee, clockHeight,
                clockWidth);
        this.lighting = lighting;
    }

    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Lighting: " + lighting + " | ";
    }
}