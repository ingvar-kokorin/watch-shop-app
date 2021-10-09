package org.watchshop.model;

import org.watchshop.model.database.ClockStorageFacility;
import org.watchshop.model.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Model {
    private final List<ClockAbs> clockStorageFacility = ClockStorageFacility.clock_storage;

    public List<ClockAbs> getClockStorageFacility() {
        return clockStorageFacility;
    }

    public void sortClocksByPrice() {
        clockStorageFacility.sort(Comparator.comparing(ClockAbs::getPrice));
    }

    public void sortClocksByColour() {
        clockStorageFacility.sort(Comparator.comparing(ClockAbs::getColour));
    }

    public void sortClocksByDateOfReceipt() {
        clockStorageFacility.sort(Comparator.comparing(ClockAbs::getDateOfReceipt));
    }

    public double coastOfAllClocksInTheStorage() {
        return clockStorageFacility.stream()
                .map(ClockAbs::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .doubleValue();
    }

    public void addNewWallClockInTheStorage(String brand, String modelName, MechanismTypes clockType, BigDecimal price,
                                            Colour colour, String producingCountry, LocalDate dateOfReceipt,
                                            int guarantee, double clockHeight, double clockWidth,
                                            String presenceOfSuspension) {
        clockStorageFacility.add(new WallClock(brand, modelName, clockType, price, colour, producingCountry,
                dateOfReceipt, guarantee, clockHeight, clockWidth, presenceOfSuspension));
    }

    public void addNewBracketClockInTheStorage(String brand, String modelName, MechanismTypes clockType, BigDecimal price,
                                               Colour colour, String producingCountry, LocalDate dateOfReceipt,
                                               int guarantee, double clockHeight, double clockWidth, String lighting) {
        clockStorageFacility.add(new BracketClock(brand, modelName, clockType, price, colour, producingCountry,
                dateOfReceipt, guarantee, clockHeight, clockWidth, lighting));
    }

    public void addNewWristClockInTheStorage(String brand, String modelName, MechanismTypes clockType, BigDecimal price,
                                             Colour colour, String producingCountry, LocalDate dateOfReceipt,
                                             int guarantee, String watchBandMaterial, Department department) {
        clockStorageFacility.add(new WristWatch(brand, modelName, clockType, price, colour, producingCountry,
                dateOfReceipt, guarantee, watchBandMaterial, department));
    }
}
