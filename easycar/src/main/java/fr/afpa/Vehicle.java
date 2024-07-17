package fr.afpa;
// Déclaration du package

import java.io.Serializable;

// Package : package fr.afpa; indique que cette classe fait partie du package fr.afpa, qui est utilisé pour organiser les classes de manière logique.

import java.time.LocalDate;
// Importation de la classe LocalDate pour gérer les dates
// Importation : import java.time.LocalDate; est utilisé pour importer la classe LocalDate afin de gérer les dates.
import java.util.ArrayList;
// Importation de la classe ArrayList pour gérer les listes
// Importation : import java.util.ArrayList; importe la classe ArrayList de Java, utilisée pour gérer des listes dynamiques

public abstract class Vehicle implements Serializable {
    // Déclaration de la classe abstraite Vehicle
    // La classe est déclarée comme abstraite, ce qui signifie qu'elle ne peut pas
    // être instanciée directement. Elle est destinée à être héritée par d'autres
    // classes concrètes

    // Attributs privés de la classe
    private String brand;
    // Marque du véhicule
    private String model;
    // Modèle du véhicule
    private String color;
    // Couleur du véhicule
    private LocalDate buyingDate;
    // Date d'achat du véhicule
    private double pricePerDay;
    // Prix de location par jour du véhicule
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    // Liste des réservations pour ce véhicule

    // Constructeur de la classe
    protected Vehicle(String brand, String model, String color, LocalDate buyingDate, double pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.buyingDate = buyingDate;
        this.pricePerDay = pricePerDay;
        // Le constructeur initialise les attributs de la classe avec les valeurs
        // fournies lors de la création d'un objet Vehicle
        // Constructeur : Permet d'initialiser un nouvel objet Vehicle avec des valeurs
        // spécifiques pour chaque attribut. Les valeurs sont passées en tant que
        // paramètres.
    }

    // Getters pour les attributs de la classe
    // Les getters permettent d'accéder aux valeurs des attributs
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public LocalDate getBuyingDate() {
        return buyingDate;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    // Setters pour les attributs de la classe
    // Les setters permettent de modifier les valeurs des attributs
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBuyingDate(LocalDate buyingDate) {
        this.buyingDate = buyingDate;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    // Méthode toString pour afficher les informations du véhicule sous forme de
    // chaîne de caractères
    // Redéfinit la méthode toString de la classe Object.
    // Fournit une représentation en chaîne de caractères de l'objet Vehicle.
    // Utilisée pour afficher les informations du véhicule de manière lisible.
    @Override
    public String toString() {
        return " Vehicle [ \n brand = " + brand
                + "\n model = " + model
                + "\n color = " + color
                + "\n rentalDate = " + buyingDate
                + "\n pricePerDay = " + pricePerDay
                + "\n reservations = " + reservations
                + "]";
    }

}
// Explication Complète
// La classe Vehicle sert de classe de base pour différents types de véhicules
// (voitures, camions, vélos). Elle encapsule les attributs communs à tous les
// véhicules, comme la marque, le modèle, la couleur, la date d'acquisition, le
// prix par jour, et les réservations.
// Les sous-classes de Vehicle (comme Car, Truck, Bicycle) hériteront de ces
// attributs et méthodes, et pourront ajouter des attributs et des comportements
// spécifiques à chaque type de véhicule.
// Le constructeur initialise les valeurs des attributs lorsqu'un nouvel objet
// Vehicle est créé.
// Les getters et setters permettent de lire et de modifier les valeurs des
// attributs de manière contrôlée.
// La méthode toString est utile pour le débogage et pour afficher les détails
// des objets Vehicle.
// Ce modèle permet de bien structurer les informations relatives aux véhicules
// et facilitera l'implémentation des fonctionnalités liées à la gestion de la
// location des véhicules dans l'application EasyCar.