package com.shop.watch.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class WristWatch extends Clock {
    private final String watchBandMaterial;
    private final Sex sex;

    public WristWatch(String brand,
                      String modelName,
                      MechanismType clockType,
                      BigDecimal price,
                      Colour colour,
                      String producingCountry,
                      LocalDate receiptDate,
                      int guarantee,
                      String watchBandMaterial,
                      Sex sex) {
        super(brand, modelName, clockType, price, colour, producingCountry, receiptDate, guarantee);
        this.watchBandMaterial = watchBandMaterial;
        this.sex = sex;
    }

    public String getWatchBandMaterial() {
        return watchBandMaterial;
    }

    public Sex getDepartment() {
        return sex;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Watch band material: " + watchBandMaterial + " | " +
                "Department: " + sex + " | ";
    }
}
