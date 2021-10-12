package com.shop.watch.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class WallClock extends HomeClock {
    private final String tickTockSoundPresence;

    public WallClock(String brand,
                     String modelName,
                     MechanismType clockType,
                     BigDecimal price,
                     Colour colour,
                     String producingCountry,
                     LocalDate receiptDate,
                     int guarantee,
                     double clockHeight,
                     double clockWidth,
                     String tickTockSoundPresence) {
        super(brand, modelName, clockType, price, colour, producingCountry, receiptDate, guarantee, clockHeight,
                clockWidth);
        this.tickTockSoundPresence = tickTockSoundPresence;
    }

    public String getTickTockSoundPresence() {
        return tickTockSoundPresence;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Thick tock sound is present: " + tickTockSoundPresence + " | ";
    }
}
