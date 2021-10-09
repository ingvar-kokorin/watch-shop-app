package org.watchshop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WallClock extends ClockForHome {
    String tickTockSoundIsPresent;

    public WallClock(String brand, String modelName, MechanismTypes clockType, BigDecimal price, Colour colour,
                     String producingCountry, LocalDate dateOfReceipt, int guarantee, double clockHeight,
                     double clockWidth, String presenceOfSuspension) {
        super(brand, modelName, clockType, price, colour, producingCountry, dateOfReceipt, guarantee, clockHeight,
                clockWidth);
        this.tickTockSoundIsPresent = presenceOfSuspension;
    }

    public String getTickTockSoundIsPresent() {
        return tickTockSoundIsPresent;
    }

    public void setTickTockSoundIsPresent(String tickTockSoundIsPresent) {
        this.tickTockSoundIsPresent = tickTockSoundIsPresent;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Thick tock sound is present: " + tickTockSoundIsPresent + " | ";
    }
}
