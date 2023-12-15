package org.example.dao;

import org.example.entities.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;



public class LibroDao {
        private EntityManager em;

        public LibroDao(EntityManager em) {
            this.em = em;
        }

        public void aggiungiLibro(Libro libro) {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        }

    public void rimuoviLibro(UUID isbn) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Libro found = em.find(Libro.class, isbn);
            if (found != null) {
                em.remove(found);
                t.commit();
                System.out.println("Libro rimosso");
            } else {
                System.out.println("Libro non trovato");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Libro cercaLibroPerISBN(String isbn) {
        return em.find(Libro.class, isbn);
    }

    public List<Libro> cercaLibroPerAnnoPubblicazione(int anno) {
        return null;
    }

    public List<Libro> cercaLibroPerAutore(String autore) {
        return null;
    }


        public List<Libro> visualizzaTuttiLibriDalDatabase() {
            TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l", Libro.class);
            return query.getResultList();
        }
    }

