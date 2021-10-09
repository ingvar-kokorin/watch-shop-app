package org.watchshop.model.database;

import org.watchshop.model.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClockStorageFacility {
    public static final List<ClockAbs> clock_storage = new ArrayList<>();

    static {
        clock_storage.add(new BracketClock("Hippih Clock", "SZQ-45", MechanismTypes.MECHANICAL,
                BigDecimal.valueOf(43.5), Colour.BLACK, "China",
                LocalDate.of(2020, 12, 17), 32,
                10, 10, "LCD"));
        clock_storage.add(new BracketClock("Wolger", "SSZK-44", MechanismTypes.QUARTZ,
                BigDecimal.valueOf(103.3), Colour.BLACK, "USA",
                LocalDate.of(2019, 11, 21), 24,
                10, 10, "LCD"));
        clock_storage.add(new BracketClock("ZippoCK", ".Zk4-335", MechanismTypes.ELECTRICAL,
                BigDecimal.valueOf(71.2), Colour.BLUE, "Turkey",
                LocalDate.of(2017, 6, 13), 12,
                10, 10, "LCD"));


        clock_storage.add(new WallClock("Zet Clock", "SZQ-45", MechanismTypes.MECHANICAL,
                BigDecimal.valueOf(41.7), Colour.WHITE, "China",
                LocalDate.of(2021, 6, 7), 32,
                15, 15, "Yes"));
        clock_storage.add(new WallClock("Ozen Wall Clock", "SZQ-45", MechanismTypes.MECHANICAL,
                BigDecimal.valueOf(33.1), Colour.ORANGE, "Russia",
                LocalDate.of(2020, 4, 13), 32,
                15, 15, "No"));
        clock_storage.add(new WallClock("Hippih Clock", "SZQ-45", MechanismTypes.ELECTRICAL,
                BigDecimal.valueOf(25.6), Colour.GREEN, "UK",
                LocalDate.of(2016, 1, 11), 24,
                15, 15, "Yes"));

        clock_storage.add(new WristWatch("EMPORIO ARMANI", "SZQ-45", MechanismTypes.MECHANICAL,
                BigDecimal.valueOf(613.4), Colour.BLUE, "China",
                LocalDate.of(2021, 9, 7), 32,
                "Leather", Department.WOMEN));
        clock_storage.add(new WristWatch("Omega", "SZQ-45", MechanismTypes.ELECTRICAL,
                BigDecimal.valueOf(443.5), Colour.GREY, "China",
                LocalDate.of(2021, 2, 1), 32,
                "Leather", Department.UNI));
        clock_storage.add(new WristWatch("Rolex", "SZQ-45", MechanismTypes.QUARTZ,
                BigDecimal.valueOf(2499.99), Colour.BLACK, "Switzerland",
                LocalDate.of(2020, 5, 9), 48,
                "Steel", Department.MEN));
    }
}
