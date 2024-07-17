package fr.afpa;

import java.time.LocalDate;

public class Truck extends MotorizedVehicle {
    // La classe Truck hérite de la classe MotorizedVehicle

    // Attributs
    private double cargoCapacity;
    // Attributs spécifiques à la classe Truck
    // Capacité de chargement du camion

    // Constructors de la classe Truck
    // Le constructeur initialise les attributs du camion en utilisant le
    // constructeur de la classe parente (super()) et initialise l'attribut
    // spécifique cargoCapacity
    public Truck(String brand, String model, String color, LocalDate buyingDate, double pricePerDay, FuelType fuelType,
            int fuelConsumption, boolean integratedGPS, double cargoCapacity) {
        // Appel du constructeur de la classe parente (MotorizedVehicle)

        super(brand, model, color, buyingDate, pricePerDay, fuelType, fuelConsumption, integratedGPS);
        // Initialisation de l'attribut spécifique à Truck

        this.cargoCapacity = cargoCapacity;
    }
    // Getter pour obtenir la capacité de chargement du camion

    public double getCargoCapacity() {
        return cargoCapacity;
    }
    // Setter pour modifier la capacité de chargement du camion

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
    // Redéfinition de la méthode toString() pour afficher les informations du
    // camion

    @Override
    public String toString() {
        return " Truck [ \n cargoCapacity = " + cargoCapacity
                + "\n getBrand() = " + getBrand()
                + "\n getFuelType() = " + getFuelType()
                + "\n getModel() = " + getModel()
                + "\n getFuelConsumption() = " + getFuelConsumption()
                + "\n getColor() = " + getColor()
                + "\n isIntegratedGPS() = " + isIntegratedGPS()
                + "\n getBuyingDate() = " + getBuyingDate()
                + "\n getPricePerDay() = " + getPricePerDay()
                + "]";
    }

}
