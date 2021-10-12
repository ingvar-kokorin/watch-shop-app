package com.shop.watch.model;

import com.shop.watch.model.database.ClockStorageFacility;
import com.shop.watch.model.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Model {

    private final List<Clock> clocks;

    public Model() {
        clocks = ClockStorageFacility.getInstance().getClockStorage();
    }

    public List<Clock> getClocks() {
        return new ArrayList<>(clocks);
    }

    public List<Clock> sortClocksByPrice() {
        return new ArrayList<>(clocks).stream()
                .sorted(Comparator.comparing(Clock::getPrice))
                .collect(Collectors.toList());
    }

    public List<Clock> sortClocksByColour() {
        return new ArrayList<>(clocks).stream()
                .sorted(Comparator.comparing(Clock::getColour))
                .collect(Collectors.toList());
    }

    public List<Clock> sortClocksByDateOfReceipt() {
        return new ArrayList<>(clocks).stream()
                .sorted(Comparator.comparing(Clock::getReceiptDate))
                .collect(Collectors.toList());
    }

    public BigDecimal getTotalCost() {
        return clocks.stream()
                .map(Clock::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addNewWallClockInTheStorage(String brand, String modelName, Mechanism clockType, BigDecimal price,
                                            Colour colour, String producingCountry, LocalDate dateOfReceipt,
                                            int guarantee, double clockHeight, double clockWidth,
                                            String presenceOfSuspension) {
        clocks.add(new WallClock(brand, modelName, clockType, price, colour, producingCountry,
                dateOfReceipt, guarantee, clockHeight, clockWidth, presenceOfSuspension));
    }

    public void addNewBracketClockInTheStorage(String brand, String modelName, Mechanism clockType, BigDecimal price,
                                               Colour colour, String producingCountry, LocalDate dateOfReceipt,
                                               int guarantee, double clockHeight, double clockWidth, String lighting) {
        clocks.add(new BracketClock(brand, modelName, clockType, price, colour, producingCountry,
                dateOfReceipt, guarantee, clockHeight, clockWidth, lighting));
    }

    public void addNewWristClockInTheStorage(String brand, String modelName, Mechanism clockType, BigDecimal price,
                                             Colour colour, String producingCountry, LocalDate dateOfReceipt,
                                             int guarantee, String watchBandMaterial, Sex sex) {
        clocks.add(new WristWatch(brand, modelName, clockType, price, colour, producingCountry,
                dateOfReceipt, guarantee, watchBandMaterial, sex));
    }
}
