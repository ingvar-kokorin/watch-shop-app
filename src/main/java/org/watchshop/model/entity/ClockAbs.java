package org.watchshop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class ClockAbs {
    private String brand;
    private String modelName;
    private MechanismTypes clockType;
    private BigDecimal price;
    private Colour colour;
    private String producingCountry;
    private LocalDate dateOfReceipt;
    private int Guarantee;

    public ClockAbs(String brand, String modelName, MechanismTypes clockType, BigDecimal price, Colour colour,
                    String producingCountry, LocalDate dateOfReceipt, int guarantee) {
        this.brand = brand;
        this.modelName = modelName;
        this.clockType = clockType;
        this.price = price;
        this.colour = colour;
        this.producingCountry = producingCountry;
        this.dateOfReceipt = dateOfReceipt;
        Guarantee = guarantee;
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

    public MechanismTypes getClockType() {
        return clockType;
    }

    public void setClockType(MechanismTypes clockType) {
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

    public LocalDate getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(LocalDate dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public int getGuarantee() {
        return Guarantee;
    }

    public void setGuarantee(int guarantee) {
        Guarantee = guarantee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClockAbs)) return false;
        ClockAbs clockAbs = (ClockAbs) o;
        return getGuarantee() == clockAbs.getGuarantee()
                && Objects.equals(getBrand(), clockAbs.getBrand())
                && Objects.equals(getModelName(), clockAbs.getModelName()) && getClockType() == clockAbs.getClockType()
                && Objects.equals(getPrice(), clockAbs.getPrice()) && getColour() == clockAbs.getColour()
                && Objects.equals(getProducingCountry(), clockAbs.getProducingCountry())
                && Objects.equals(getDateOfReceipt(), clockAbs.getDateOfReceipt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModelName(), getClockType(), getPrice(), getColour(),
                getProducingCountry(), getDateOfReceipt(), getGuarantee());
    }

    @Override
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() + ": " + "Brand: " + brand + " | " +
                "Model name: " + modelName + " | " +
                "Mechanism type: " + clockType + " | " +
                "Price : " + price + " | " +
                "Colour: " + colour + " | " +
                "Country: " + producingCountry + " | " +
                "Date: " + dateOfReceipt + " | " +
                "Guarantee: " + Guarantee + " |";
    }
}
