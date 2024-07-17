package fr.afpa;

import java.text.CollationElementIterator;
import java.time.LocalDate; // Importation de la classe LocalDate pour manipuler les dates

import fr.afpa.MotorizedVehicle.FuelType; // Importation de l'énumération FuelType définie dans un autre package
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;

public class AppMain {
    private static Logger logger = LogManager.getLogger(AppMain.class);

    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        // Instanciation de chaque type de véhicule
        // Voiture : Audi RS6, couleur gris carbone, date de sortie 25 juin 2024,
        // puissance 500, carburant essence, réservoir 80L, avec un GPS, 5 places
        Vehicle car = new Car("Audi", "RS6", "grey carbon", LocalDate.of(2024, 06, 25), 500, FuelType.ESSENCE, 80, true,
                5);

        // Camion : Renault master, couleur blanche, date de sortie 21 février 2014,
        // puissance 150, carburant diesel, réservoir 150L, sans GPS, 9 place
        Vehicle truck = new Truck("Renault", "master", "white", LocalDate.of(2014, 02, 21), 50, FuelType.DIESEL, 150,
                false, 9);

        // Vélo : Peugeot lc01, couleur blanche et bleue, date de sortie 21 février
        // 1975, poids 100, taille L
        Vehicle bike = new Bike("Peugeot", "lc01", "white and blue", LocalDate.of(1975, 02, 21), 100, 'L');

        // Instanciation de clients
        // Client 1 : Youssef Lasri, adresse 11 rue arago, Saint-Ouen, 93400
        Customer customer1 = new Customer("Youssef", "Lasri", "11 rue arago", "Saint-Ouen", "93400");

        // Client 2 : Rabea Guellil, adresse 2 passage de arceaux, Saint-Loubès, 33450
        Customer customer2 = new Customer("Rabea", "Guellil", "2 passage de arceaux", "Saint-Loubès", "33450");

        Customer customer3 = new Customer("Alain", "Bernard", "11 rue arago", "Saint-Oeun", "93400");

        // Instanciation de réservations et lien entre un véhicule et sa réservation
        // Réservation 1 : du 1er au 10 juillet 2024, non confirmée, pour la voiture
        Reservation reservation1 = new Reservation(LocalDate.of(2024, 07, 01), LocalDate.of(2024, 07, 10), false, car);

        // Réservation 2 : du 1er au 10 juillet 2024, non confirmée, pour le camion
        Reservation reservation2 = new Reservation(LocalDate.of(2024, 07, 01), LocalDate.of(2024, 07, 10), false,
                truck);

        // Réservation 3 : du 1er au 10 juillet 2024, confirmée, pour le vélo
        Reservation reservation3 = new Reservation(LocalDate.of(2024, 07, 01), LocalDate.of(2024, 07, 10), true, bike);

        // Création des liens entre les clients et leurs réservations
        // Ajout des réservations 1 et 2 au client 1 (Youssef)
        customer1.addReservation(reservation1);
        // customer1.totalMoneySpent();
        customer2.addReservation(reservation2);
        // customer2.totalMoneySpent();

        // Ajout de la réservation 3 au client 2 (Rabea)
        customer3.addReservation(reservation3);
        // customer3.totalMoneySpent();

        // Test de la méthode totalMoneySpent pour vérifier les dépenses totales des
        // clients
        // Calcul et affichage du total des dépenses du client 1
        // double totalSpentByCustomer1 = customer1.totalMoneySpent();
        // System.out.println("Total spent by customer 1: " + totalSpentByCustomer1);

        // Calcul et affichage du total des dépenses du client 2
        // double totalSpentByCustomer2 = customer2.totalMoneySpent();
        // System.out.println("Total spent by customer 2: " + totalSpentByCustomer2);

        // double totalSpentByCustomer3 = customer3.totalMoneySpent();
        // System.out.println("Total spent by customer 3: " + totalSpentByCustomer3);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

         // Affichage avant le tri
        System.out.println("Avant le tri :");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Tri des clients par argent total dépensé
           // Tri des clients par argent total dépensé
           Collections.sort(customers);

           // Affichage après le tri
           System.out.println("Après le tri :");
           for (Customer customer : customers) {
               System.out.println(customer);
        }


        // Code permettant de tester la sérialisation
        Customer.serialize(customer1);

        // Code permettant de tester la désérialisation
        Customer customer = Customer.deserialize();

        logger.info("Client désérialisé: " + customer.toString());
    }
}

// Premier TEST de code "BON sans commentaires"
// package fr.afpa;

// import java.time.LocalDate;

// import fr.afpa.MotorizedVehicle.FuelType;

// public class AppMain
// {
// public static void main( String[] args )
// {
// //Instanciation de chaque types de véhicules
// Vehicle car = new Car(" Audi ", " RS6 ", " grey carbon ", LocalDate.of(2024,
// 07, 25), 500, FuelType.ESSENCE, 50, false, 5);
// Vehicle truck = new Truck(" Renault ", " master ", " white ",
// LocalDate.of(2014, 02, 21), 1500, FuelType.DIESEL, 150, true, 3);
// Vehicle bike = new Bike(" Peugeot ", " lc01 ", " white and bleu ",
// LocalDate.of(2022, 02, 21), 100, 'L');

// //Instanciation de clients
// Customer customer1 = new Customer(" Youssef ", " Lasri ", " 11 rue arago ", "
// Saint-Ouen ", "93400");
// Customer customer2 = new Customer(" Rabea ", " Guellil ", " 2 passage de
// arceaux ", " Saint-Loubès ", " 33450 ");

// //Instanciation de réservations + lien entre un vehicle et sa réservation
// Reservation reservation1 = new Reservation(LocalDate.of(2024, 07, 01),
// LocalDate.of(2024, 07, 10), false, car);
// Reservation reservation2 = new Reservation(LocalDate.of(2024, 07, 01),
// LocalDate.of(2024, 07, 10), false, truck);
// Reservation reservation3 = new Reservation(LocalDate.of(2024, 07, 01),
// LocalDate.of(2024, 07, 10), false, bike);

// //Création des liens entre les clients et leur réservation(s)
// customer1.addReservation(reservation1);
// customer1.addReservation(reservation2);
// customer2.addReservation(reservation3);

// //Test de la méthode totalMoneySpent
// customer1.totalMoneySpent();
// customer2.totalMoneySpent();

// }
// }

// customer1.totalMoneySpent();
// System.out.println(customer1.totalMoneySpent());
// customer1.totalMoneySpent();
// System.out.println(reservation1.totalPrice);

// }
// }