package org.watchshop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class ClockForHome extends ClockAbs {
    double clockHeight;
    double clockWidth;

    public ClockForHome(String brand, String modelName, MechanismTypes clockType, BigDecimal price, Colour colour,
                        String producingCountry, LocalDate dateOfReceipt, int guarantee, double clockHeight,
                        double clockWidth) {
        super(brand, modelName, clockType, price, colour, producingCountry, dateOfReceipt, guarantee);
        this.clockHeight = clockHeight;
        this.clockWidth = clockWidth;
    }

    public double getClockHeight() {
        return clockHeight;
    }

    public void setClockHeight(double clockHeight) {
        this.clockHeight = clockHeight;
    }

    public double getClockWidth() {
        return clockWidth;
    }

    public void setClockWidth(double clockWidth) {
        this.clockWidth = clockWidth;
    }

    @Override
    public String toString() {
        return super.toString() + "Clock height: " + clockHeight + " | " +
                "Clock width" + clockWidth + " | ";
    }
}
