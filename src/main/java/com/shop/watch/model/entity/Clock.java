package com.shop.watch.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Clock {
    private String brand;
    private String modelName;
    private Mechanism clockType;
    private BigDecimal price;
    private Colour colour;
    private String producingCountry;
    private LocalDate receiptDate;
    private int guaranteePeriod;

    public Clock(String brand,
                 String modelName,
                 Mechanism clockType,
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

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Mechanism getClockType() {
        return clockType;
    }

    public void setClockType(Mechanism clockType) {
        this.clockType = clockType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(int guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
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