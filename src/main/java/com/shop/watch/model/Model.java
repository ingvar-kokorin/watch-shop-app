package com.shop.watch.model;

import com.shop.watch.model.database.ClockStorageFacility;
import com.shop.watch.model.entity.BracketClock;
import com.shop.watch.model.entity.Clock;
import com.shop.watch.model.entity.Colour;
import com.shop.watch.model.entity.MechanismType;
import com.shop.watch.model.entity.Sex;
import com.shop.watch.model.entity.WallClock;
import com.shop.watch.model.entity.WristWatch;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Model {

    private final List<Clock> clocks;

    public Model() {
        clocks = ClockStorageFacility.getInstance().getClockStorage();
    }

    public List<Clock> getAllClocks() {
        return Collections.unmodifiableList(clocks);
    }

    public List<Clock> sortClocksByPrice() {
        return new ArrayList<>(clocks).stream()
                .sorted(Comparator.comparing(Clock::getPrice))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Clock> sortClocksByColour() {
        return new ArrayList<>(clocks).stream()
                .sorted(Comparator.comparing(Clock::getColour))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Clock> sortClocksByDateOfReceipt() {
        return new ArrayList<>(clocks).stream()
                .sorted(Comparator.comparing(Clock::getReceiptDate))
                .collect(Collectors.toUnmodifiableList());
    }

    public BigDecimal getTotalCost() {
        return clocks.stream()
                .map(Clock::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addNewWallClockInTheStorage(String brand, String modelName, MechanismType clockType, BigDecimal price,
                                            Colour colour, String producingCountry, LocalDate dateOfReceipt,
                                            int guarantee, double clockHeight, double clockWidth,
                                            String suspensionPresence) {
        clocks.add(new WallClock(brand, modelName, clockType, price, colour, producingCountry,
                dateOfReceipt, guarantee, clockHeight, clockWidth, suspensionPresence));
    }

    public void addNewBracketClockInTheStorage(String brand, String modelName, MechanismType clockType, BigDecimal price,
                                               Colour colour, String producingCountry, LocalDate receiptDate,
                                               int guarantee, double clockHeight, double clockWidth, String lighting) {
        clocks.add(new BracketClock(brand, modelName, clockType, price, colour, producingCountry,
                receiptDate, guarantee, clockHeight, clockWidth, lighting));
    }

    public void addNewWristClockInTheStorage(String brand, String modelName, MechanismType clockType, BigDecimal price,
                                             Colour colour, String producingCountry, LocalDate receiptDate,
                                             int guarantee, String watchBandMaterial, Sex sex) {
        clocks.add(new WristWatch(brand, modelName, clockType, price, colour, producingCountry,
                receiptDate, guarantee, watchBandMaterial, sex));
    }
}
