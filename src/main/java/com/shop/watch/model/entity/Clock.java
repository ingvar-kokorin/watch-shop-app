package com.shop.watch.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Clock {
    private final String brand;
    private final String modelName;
    private final MechanismType clockType;
    private final BigDecimal price;
    private final Colour colour;
    private final String producingCountry;
    private final LocalDate receiptDate;
    private final int guaranteePeriod;

    public Clock(String brand,
                 String modelName,
                 MechanismType clockType,
                 BigDecimal price,
                 Colour colour,
                 String producingCountry,
                 LocalDate receiptDate,
                 int guaranteePeriod) {
        this.brand = brand;
        this.modelName = modelName;
        this.clockType = clockType;
        this.price = price;
        this.colour = colour;
        this.producingCountry = producingCountry;
        this.receiptDate = receiptDate;
        this.guaranteePeriod = guaranteePeriod;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelName() {
        return modelName;
    }

    public MechanismType getClockType() {
        return clockType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Colour getColour() {
        return colour;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public int getGuaranteePeriod() {
        return guaranteePeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Clock)) {
            return false;
        }
        Clock clock = (Clock) o;
        return getGuaranteePeriod() == clock.getGuaranteePeriod()
                && Objects.equals(getBrand(), clock.getBrand())
                && Objects.equals(getModelName(), clock.getModelName()) && getClockType() == clock.getClockType()
                && Objects.equals(getPrice(), clock.getPrice()) && getColour() == clock.getColour()
                && Objects.equals(getProducingCountry(), clock.getProducingCountry())
                && Objects.equals(getReceiptDate(), clock.getReceiptDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModelName(), getClockType(), getPrice(), getColour(),
                getProducingCountry(), getReceiptDate(), getGuaranteePeriod());
    }

    @Override
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() + ": " + "Brand: " + brand + " | " +
                "Model name: " + modelName + " | " +
                "Mechanism type: " + clockType + " | " +
                "Price : " + price + " | " +
                "Colour: " + colour + " | " +
                "Country: " + producingCountry + " | " +
                "Date: " + receiptDate + " | " +
                "Guarantee: " + guaranteePeriod + " |";
    }
}