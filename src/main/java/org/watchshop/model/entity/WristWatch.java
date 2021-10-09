package org.watchshop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WristWatch extends ClockAbs {
    String watchBandMaterial;
    Department department;

    public WristWatch(String brand, String modelName, MechanismTypes clockType, BigDecimal price, Colour colour,
                      String producingCountry, LocalDate dateOfReceipt, int guarantee, String watchBandMaterial,
                      Department department) {
        super(brand, modelName, clockType, price, colour, producingCountry, dateOfReceipt, guarantee);
        this.watchBandMaterial = watchBandMaterial;
        this.department = department;
    }

    public String getWatchBandMaterial() {
        return watchBandMaterial;
    }

    public void setWatchBandMaterial(String watchBandMaterial) {
        this.watchBandMaterial = watchBandMaterial;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Watch band material: " + watchBandMaterial + " | " +
                "Department: " + department + " | ";
    }
}
