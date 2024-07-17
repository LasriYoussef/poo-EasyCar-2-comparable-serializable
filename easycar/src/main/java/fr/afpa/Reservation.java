package fr.afpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation implements Serializable {

    // Attributs
    private LocalDate starDate;
    private LocalDate endDate;
    private boolean paid;
    private Vehicle vehicle;

    // Constructors
    public Reservation(LocalDate starDate, LocalDate endDate, boolean paid, Vehicle vehicle) {
        this.starDate = starDate;
        this.endDate = endDate;
        this.paid = paid;
        this.vehicle = vehicle;
    }

    // Getters & Setters
    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Méthodes
    @Override
    public String toString() {
        return " Reservation [ \n starDate = " + starDate
                + "\n endDate = " + endDate
                + "\n paid = " + paid
                + "]";
    }

    // totalPrice() : double » : permet de retrouver le prix total d’une réservation
    // pour la période de temps de la réservation.
    public double totalPrice() {
        long locationDays = ChronoUnit.DAYS.between(this.starDate, this.endDate);
        double dayPrice = this.vehicle.getPricePerDay();
        return locationDays * dayPrice;
    }
}
