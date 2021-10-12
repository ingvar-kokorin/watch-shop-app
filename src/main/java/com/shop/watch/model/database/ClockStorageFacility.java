package com.shop.watch.model.database;

import com.shop.watch.model.entity.BracketClock;
import com.shop.watch.model.entity.Clock;
import com.shop.watch.model.entity.Colour;
import com.shop.watch.model.entity.Sex;
import com.shop.watch.model.entity.MechanismType;
import com.shop.watch.model.entity.WallClock;
import com.shop.watch.model.entity.WristWatch;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ClockStorageFacility {
    private final List<Clock> clockStorage = new ArrayList<>();

    private static ClockStorageFacility clockStorageFacility;

    private ClockStorageFacility() {
    }

    public static ClockStorageFacility getInstance() {
        if (clockStorageFacility == null) {
            clockStorageFacility = new ClockStorageFacility();
            Stream.of(new BracketClock("Hippih Clock", "SZQ-45", MechanismType.MECHANICAL,
                                    BigDecimal.valueOf(43.5), Colour.BLACK, "China",
                                    LocalDate.of(2020, 12, 17), 32,
                                    10, 10, "LCD"),
                            new BracketClock("Wolger", "SSZK-44", MechanismType.QUARTZ,
                                    BigDecimal.valueOf(103.3), Colour.BLACK, "USA",
                                    LocalDate.of(2019, 11, 21), 24,
                                    10, 10, "LCD"),
                            new BracketClock("ZippoCK", ".Zk4-335", MechanismType.ELECTRICAL,
                                    BigDecimal.valueOf(71.2), Colour.BLUE, "Turkey",
                                    LocalDate.of(2017, 6, 13), 12,
                                    10, 10, "LCD"),
                            new WallClock("Zet Clock", "SZQ-45", MechanismType.MECHANICAL,
                                    BigDecimal.valueOf(41.7), Colour.WHITE, "China",
                                    LocalDate.of(2021, 6, 7), 32,
                                    15, 15, "Yes"),
                            new WallClock("Ozen Wall Clock", "SZQ-45", MechanismType.MECHANICAL,
                                    BigDecimal.valueOf(33.1), Colour.ORANGE, "Russia",
                                    LocalDate.of(2020, 4, 13), 32,
                                    15, 15, "No"),
                            new WallClock("Hippih Clock", "SZQ-45", MechanismType.ELECTRICAL,
                                    BigDecimal.valueOf(25.6), Colour.GREEN, "UK",
                                    LocalDate.of(2016, 1, 11), 24,
                                    15, 15, "Yes"),
                            new WristWatch("EMPORIO ARMANI", "SZQ-45", MechanismType.MECHANICAL,
                                    BigDecimal.valueOf(613.4), Colour.BLUE, "China",
                                    LocalDate.of(2021, 9, 7), 32,
                                    "Leather", Sex.WOMEN),
                            new WristWatch("Omega", "SZQ-45", MechanismType.ELECTRICAL,
                                    BigDecimal.valueOf(443.5), Colour.GREY, "China",
                                    LocalDate.of(2021, 2, 1), 32,
                                    "Leather", Sex.UNISEX),
                            new WristWatch("Rolex", "SZQ-45", MechanismType.QUARTZ,
                                    BigDecimal.valueOf(2499.99), Colour.BLACK, "Switzerland",
                                    LocalDate.of(2020, 5, 9), 48,
                                    "Steel", Sex.MEN))
                    .forEach(getInstance().clockStorage::add);
        }
        return clockStorageFacility;
    }

    public List<Clock> getClockStorage() {
        return clockStorage;
    }
}
