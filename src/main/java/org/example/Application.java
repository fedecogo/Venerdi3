package org.example;

import org.example.dao.LibroDao;
import org.example.dao.RivistaDao;
import org.example.entities.Libro;
import org.example.entities.Periodicità;
import org.example.entities.Rivista;

import javax.persistence.*;
import java.util.UUID;
import java.util.List;
import java.util.Scanner;



public class Application {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblio");
        EntityManager em = emf.createEntityManager();

        // creazione dei DAO
        LibroDao libroDao = new LibroDao(em);
        RivistaDao rivistaDao = new RivistaDao(em);

        Scanner scanner = new Scanner(System.in);
        String scelta;

        do {
            System.out.println("1. Aggiungi un libro");
            System.out.println("2. Rimuovi un libro");
            System.out.println("3. Aggiungi una rivista");
            System.out.println("4. Rimuovi una rivista");
            System.out.println("0. Esci");

            System.out.print("Scelta: ");
            scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    // Aggiungi un libro
                    Libro nuovoLibro = chiediDettagliLibro(scanner);
                    libroDao.aggiungiLibro(nuovoLibro);
                    visualizzaTuttiLibri(libroDao);
                    break;

                case "2":
                    // Rimuovi un libro
                    System.out.println("Scegli l'UUID del libro da rimuoveree , copialo e inserisclilo nella prossima domanda");
                    visualizzaTuttiLibri(libroDao);
                    System.out.print("Inserisci l'UUID del libro da rimuovere: ");
                    String uuidLibro = scanner.nextLine();
                    libroDao.rimuoviLibro(UUID.fromString(uuidLibro));
                    visualizzaTuttiLibri(libroDao);
                    break;
                 case "3":
                    // Aggiungi una rivista
                    Rivista nuovaRivista = chiediDettagliRivista(scanner);
                    rivistaDao.aggiungiRivista(nuovaRivista);
                    visualizzaTutteRiviste(rivistaDao);
                    break;
                case "4":
                    // Rimuovi una rivista
                    System.out.print("Inserisci l'UUID della rivista da rimuovere copialo e inserisclilo nella prossima domanda ");
                    visualizzaTutteRiviste(rivistaDao);
                    System.out.print("Inserisci l'UUID deelle riviste da rimuovere: ");
                    String uuidRivista = scanner.nextLine();
                    rivistaDao.rimuoviRivista(UUID.fromString(uuidRivista));
                    visualizzaTutteRiviste(rivistaDao);
                    break;
                case "0":
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }

        } while (!scelta.equals("0"));

        scanner.close();
        em.close();
        emf.close();
    }


    private static Libro chiediDettagliLibro(Scanner scanner) {
        System.out.print("Inserisci l'autore del libro: ");
        String autore = scanner.nextLine();

        System.out.print("Inserisci il genere del libro: ");
        String genere = scanner.nextLine();

        System.out.print("Inserisci il nome del libro: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci l'anno di pubblicazione del libro: ");
        int annoPubblicazione = Integer.parseInt(scanner.nextLine());

        System.out.print("Inserisci il numero di pagine del libro: ");
        int numeroPagine = Integer.parseInt(scanner.nextLine());


        return new Libro(UUID.randomUUID(), autore, genere, nome, annoPubblicazione, numeroPagine);
    }

    private static Rivista chiediDettagliRivista(Scanner scanner) {
        System.out.print("Inserisci il nome della rivista: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci l'anno di pubblicazione della rivista: ");
        int annoPubblicazione = Integer.parseInt(scanner.nextLine());

        System.out.print("Inserisci il numero di pagine della rivista: ");
        int numeroPagine = Integer.parseInt(scanner.nextLine());

        System.out.print("Inserisci la periodicità della rivista (MENSILE, BIMESTRALE, TRIMESTRALE, SEMESTRALE, ANNUALE): ");
        Periodicità periodicità = Periodicità.valueOf(scanner.nextLine().toUpperCase());

        return new Rivista(UUID.randomUUID(), nome, annoPubblicazione, numeroPagine, periodicità);
    }


    private static void visualizzaTuttiLibri(LibroDao libroDao) {
        List<Libro> libri = libroDao.visualizzaTuttiLibriDalDatabase();
        libri.forEach(System.out::println);
        System.out.println("libro tolto");
    }

    private static void  visualizzaTutteRiviste(RivistaDao rivistaDao) {
        List<Rivista> rivisti = rivistaDao.visualizzaTutteRivisteDalDatabase();
        rivisti.forEach(System.out::println);
        System.out.println("rivsta tolta");
    }


}