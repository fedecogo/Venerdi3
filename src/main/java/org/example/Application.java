package org.example;

import org.example.dao.LibroDao;
import org.example.dao.RivistaDao;
import org.example.entities.Libro;
import org.example.entities.Periodicità;
import org.example.entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;



public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblio");
        EntityManager em = emf.createEntityManager();

        // creazione dei DAO
        LibroDao libroDao = new LibroDao(em);
        RivistaDao rivistaDao = new RivistaDao(em);

        // agg di un libro
        Libro nuovoLibro = new Libro(UUID.randomUUID(), "io", "romanzo", "Tree ", 2023, 200);
        libroDao.aggiungiLibro(nuovoLibro);

        // rivsta aggiunta
        Rivista nuovaRivista = new Rivista(UUID.randomUUID(), "RivistaBella", 2023, 50, Periodicità.MENSILE);
        rivistaDao.aggiungiRivista(nuovaRivista);

        // rimuovi libro E' FUNZINOANTE MA OGNI VOLTA BISOGNA CAMBIARE UUID
        // libroDao.rimuoviLibro(UUID.fromString("aa677472-3c0a-4621-9a9d-8b885a148af1"));

        // rimuovi rivista E' FUNZINOANTE MA OGNI VOLTA BISOGNA CAMBIARE UUID
        // rivistaDao.rimuoviRivista(UUID.fromString("1a146ef3-8364-4e20-99c9-4bacb428bb38"));

        em.close();
        emf.close();
    }
}