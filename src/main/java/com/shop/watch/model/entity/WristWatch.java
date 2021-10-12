package com.shop.watch.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WristWatch extends Clock {
    private String watchBandMaterial;
    private Sex sex;

    public WristWatch(String brand,
                      String modelName,
                      Mechanism clockType,
                      BigDecimal price,
                      Colour colour,
                      String producingCountry,
                      LocalDate dateOfReceipt,
                      int guarantee,
                      String watchBandMaterial,
                      Sex sex) {
        super(brand, modelName, clockType, price, colour, producingCountry, dateOfReceipt, guarantee);
        this.watchBandMaterial = watchBandMaterial;
        this.sex = sex;
    }

    public String getWatchBandMaterial() {
        return watchBandMaterial;
    }

    public void setWatchBandMaterial(String watchBandMaterial) {
        this.watchBandMaterial = watchBandMaterial;
    }

    public Sex getDepartment() {
        return sex;
    }

    public void setDepartment(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Watch band material: " + watchBandMaterial + " | " +
                "Department: " + sex + " | ";
    }
}
