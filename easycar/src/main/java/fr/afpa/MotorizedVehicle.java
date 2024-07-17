package fr.afpa;
// Déclaration du package

// Package : package fr.afpa; indique que cette classe fait partie du package fr.afpa, qui est utilisé pour organiser les classes de manière logique.

import java.time.LocalDate;
// Importation de la classe LocalDate pour gérer les dates
// Importation : import java.time.LocalDate; est utilisé pour importer la classe LocalDate afin de gérer les dates.

import fr.afpa.MotorizedVehicle.FuelType;

public abstract class MotorizedVehicle extends Vehicle {
    // Classe Abstraite : MotorizedVehicle est déclarée comme une classe abstraite,
    // ce qui signifie qu'on ne peut pas créer d'instance de cette classe
    // directement. Les sous-classes concrètes (comme Car, Truck) doivent être
    // créées.
    // Héritage : La classe MotorizedVehicle étend (extends) la classe Vehicle. Cela
    // signifie qu'elle hérite de tous les attributs et méthodes de la classe
    // Vehicle.

    // Attributs
    public enum FuelType {
        ESSENCE,
        DIESEL,
        HYBRID,
        ELECTRIC;
        // Enumération FuelType : L'énumération FuelType définit les différents types de
        // carburant que peuvent utiliser les véhicules motorisés. Les valeurs possibles
        // sont ESSENCE, DIESEL, HYBRID, et ELECTRIC.
    }

    private FuelType fuelType;
    // fuelType : Type de carburant du véhicule, de type FuelType
    private int fuelConsumption;
    // fuelConsumption : Consommation de carburant du véhicule en litres par 100 km
    private boolean integratedGPS;
    // integratedGPS : Indicateur booléen indiquant si le véhicule a un GPS intégré

    // Constructor
    // Appelle le constructeur de la classe parente Vehicle en utilisant super(...).
    // Cela initialise les attributs hérités (brand, model, color, buyingDate,
    // pricePerDay).
    // Initialise les nouveaux attributs spécifiques à MotorizedVehicle (fuelType,
    // fuelConsumption, integratedGPS)
    public MotorizedVehicle(String brand, String model, String color, LocalDate buyingDate, double pricePerDay,
            FuelType fuelType, int fuelConsumption, boolean integratedGPS) {
        super(brand, model, color, buyingDate, pricePerDay);
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.integratedGPS = integratedGPS;
    }

    // Getters
    public FuelType getFuelType() {
        return fuelType;
        // getFuelType() : Retourne le type de carburant du véhicule
    }

    public int getFuelConsumption() {
        return fuelConsumption;
        // getFuelConsumption() : Retourne la consommation de carburant du véhicule
    }

    // Setters
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
        // setFuelType(FuelType fuelType) : Définit le type de carburant du véhicule
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        // setFuelConsumption(int fuelConsumption) : Définit la consommation de
        // carburant du véhicule
    }

    public boolean isIntegratedGPS() {
        return integratedGPS;
        // isIntegratedGPS() : Retourne true si le véhicule a un GPS intégré, sinon
        // false
    }

    public void setIntegratedGPS(boolean integratedGPS) {
        this.integratedGPS = integratedGPS;
        // setIntegratedGPS(boolean integratedGPS) : Définit si le véhicule a un GPS
        // intégré ou non
    }

    // Méthode toString pour afficher les informations du véhicule sous forme de
    // chaîne de caractères
    // Redéfinit la méthode toString de la classe Object.
    // Redéfinit la méthode toString de la classe Object.
    // Fournit une représentation en chaîne de caractères de l'objet
    // MotorizedVehicle.
    // Affiche les attributs fuelType, fuelConsumption, et integratedGPS du véhicule
    // motorisé.
    // Utilisée pour afficher les informations du véhicule de manière lisible, par
    // exemple lors du débogage ou du logging
    @Override
    public String toString() {
        return " MotorizedVehicle [ \n fuelType = " + fuelType
                + "\n fuelConsumption = " + fuelConsumption
                + "\n integratedGPS = " + integratedGPS
                + "]";
    }

}
// Explication Complète
// Classe MotorizedVehicle : Cette classe représente un véhicule motorisé et
// étend la classe abstraite Vehicle. Elle ajoute des attributs spécifiques aux
// véhicules motorisés, tels que le type de carburant, la consommation de
// carburant et la présence d'un GPS intégré.
// Constructeur : Le constructeur initialise à la fois les attributs hérités de
// Vehicle et les nouveaux attributs spécifiques à MotorizedVehicle.
// Getters et Setters : Fournissent des méthodes pour accéder et modifier les
// attributs privés de la classe. Ils permettent de gérer les valeurs des
// attributs de manière contrôlée.
// Méthode toString : Fournit une représentation textuelle de l'objet, utile
// pour afficher ou déboguer les informations sur un véhicule motorisé.
// Cette structure permet de bien encapsuler les détails relatifs aux véhicules
// motorisés et facilite l'extension et la maintenance du code. Les sous-classes
// concrètes de MotorizedVehicle pourront hériter et utiliser ces
// fonctionnalités, tout en ajoutant leurs propres spécificités si nécessaire