// Déclaration du package
package fr.afpa;

// Package : package fr.afpa; indique que cette classe fait partie du package fr.afpa, qui est utilisé pour organiser les classes de manière logique.

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
// Importation de la classe ArrayList pour gérer les listes
// Importation : import java.util.ArrayList; importe la classe ArrayList de Java, utilisée pour gérer des listes dynamiques.
import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customer implements Comparable<Customer>, Serializable {

    // récupération du logger
    private static Logger logger = LogManager.getLogger(Customer.class);

    private static final long serialVersionUID = 1L;
    // Classe Customer : Cette classe représente un client

    // Attributs
    private String firstName;
    // Prénom du client
    private String lastName;
    // Nom de famille du client
    private String address;
    // Adresse postale du client
    private String city;
    // Ville du client
    private String postalCode;
    // Code postal du client
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    // reservations : Liste des réservations effectuées par le client. Utilise
    // ArrayList pour stocker des objets de type Reservation

    // Constructors
    public Customer(String firstName, String lastName, String address, String city, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        // Initialise les attributs firstName, lastName, address, city, et postalCode
        // avec les valeurs fournies en paramètres lors de la création d'un objet
        // Customer
    }

    // Getters
    // Méthodes pour accéder aux valeurs des attributs privés (firstName, lastName,
    // address, city, postalCode)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    // Setters
    // Méthodes pour modifier les valeurs des attributs privés (firstName, lastName,
    // address, city, postalCode)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Méthode toString :
    // Redéfinit la méthode toString de la classe Object.
    // Fournit une représentation en chaîne de caractères de l'objet Customer.
    // Affiche les attributs firstName, lastName, address, city, et postalCode
    @Override
    public String toString() {
        return " Customer [ \n firstName = " + firstName
                + "\n lastName = " + lastName
                + "\n address = " + address
                + "\n city = " + city
                + "\n postalCode = " + postalCode
                + "\n totalMoneySpace = " + totalMoneySpent()
                + "]";
    }

    @Override
    public int compareTo(Customer other) {
        if (this.totalMoneySpent() < other.totalMoneySpent()) {
            return -1;
        }
        if (this.totalMoneySpent() > other.totalMoneySpent()) {
            return 1;
        }
        return 0;
    }

    // Méthode totalMoneySpent() : double :
    // Calcule et retourne la somme totale de l'argent dépensé par le client pour
    // toutes ses réservations.
    // Utilise une boucle for-each pour parcourir la liste des réservations et
    // additionner les prix totaux de chaque réservation.
    // Affiche le montant total dépensé par le client
    public double totalMoneySpent() {
        double total = 0.0;
        // 0.0 valeur initiale
        for (Reservation reservation : reservations) {
            total += reservation.totalPrice();
        }
        return total;
    }

    // Méthodes addReservation(reservation : Reservation) : void : ajoute une
    // réservation du
    // client
    // Vérifie si la réservation n'existe pas déjà dans la liste avant de l'ajouter
    // pour éviter les doublons.
    // Affiche un message indiquant si la réservation a été ajoutée ou si elle
    // existe déjà
    public void addReservation(Reservation reservation) {
        // ! (negation) Vérifier si la réservation n'existe pas déjà dans l'utilisateur
        if (!reservations.contains(reservation)) {
            reservations.add(reservation);
            System.out.println(" La réservation : " + reservation + " a été ajoutée pour le client : " + this.firstName
                    + " " + this.lastName);
        } else {
            System.out.println(" La réservation : " + reservation + " existe déjà pour le client : " + this.firstName
                    + " " + this.lastName);
        }

    }

    // Méthodes removeReservation(reservation : Reservation) : boolean, supprime une
    // réservation de la liste des réservations du client, Vérifie si la réservation
    // existe dans la liste avant de la supprimer, Affiche un message indiquant si
    // la réservation a été supprimée ou si elle n'a pas été trouvée, Retourne true
    // si la réservation a été supprimée avec succès, sinon retourne false
    public boolean removeReservation(Reservation reservation) {
        // Vérifier si la réservation existe dans la liste
        if (reservations.contains(reservation)) {
            System.out.println("La réservation : " + reservation + " a été retirée pour le client : " + this.firstName
                    + " " + this.lastName);
            reservations.remove(reservation);
            return true;
        } else {
            System.out.println("La réservation : " + reservation + " n'a pas été trouvée pour le client : "
                    + this.firstName + " " + this.lastName);
            return false;
        }
    }
    // Implémentation de l'interface Comparable<Customer>

    public static void serialize(Customer customer) {

        try {
            // instructions de sérialisation
            File newFile = new File("customer.ser");

            // instanciation d'un flux vers un fichier
            FileOutputStream fos = new FileOutputStream(newFile);

            // ouverture d'un flux sur un fichier
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // sérialization de l'objet
            oos.writeObject(customer);
            oos.close();
        } catch (NotSerializableException exception) {
            logger.error(exception.getMessage());
        } catch (IOException exception) {
            logger.error(exception.getMessage());
        }
    }

    public static Customer deserialize() {

        Customer deserializedCustomer = null;
        try {
            File fichier = new File("customer.ser");

            FileInputStream fis = new FileInputStream(fichier);
            // ouverture d'un flux sur un fichier
            ObjectInputStream ois = new ObjectInputStream(fis);

            // désérialization de l'objet
            deserializedCustomer = (Customer) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException  exception) {
            logger.error(exception.getMessage());
        } 

        return deserializedCustomer;
    }
}
// Conclusion
// Encapsulation : La classe Customer utilise des attributs privés et fournit
// des getters et setters pour accéder et modifier ces attributs, assurant ainsi
// l'encapsulation.
// Gestion des Réservations : La classe permet de gérer les réservations des
// clients en ajoutant, supprimant et calculant le total des dépenses liées aux
// réservations.
// Méthode toString : Fournit une représentation textuelle utile pour
// l'affichage et le débogage.
// Vérifications : Les méthodes addReservation et removeReservation incluent des
// vérifications pour éviter les doublons et gérer les cas où une réservation
// n'existe pas.
// Cette structure permet de modéliser efficacement un client et ses
// interactions avec le système de réservation de l'entreprise