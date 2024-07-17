package fr.afpa;

import java.time.LocalDate;

public class Bike extends Vehicle {

    // Attributs
    private char size; // (S)mall, (M)edium, (L)arge

    // Constructors
    public Bike(String brand, String model, String color, LocalDate buyingDate, double pricePerDay, char size) {
        super(brand, model, color, buyingDate, pricePerDay);
        this.size = size;
    }

    // Getters & Setters
    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    // Méthodes
    @Override
    public String toString() {
        return " Bike [ \n size = " + size
                + "\n getBrand() = " + getBrand()
                + "\n getModel() = " + getModel()
                + "\n getColor() = " + getColor()
                + "\n getBuyingDate() = " + getBuyingDate()
                + "\n getPricePerDay() = " + getPricePerDay()
                + "]";
    }

}
