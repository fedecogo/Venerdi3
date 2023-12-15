package org.example.dao;

import org.example.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;


public class UtenteDao {
    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void aggiungiUtente(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
    }

    public void rimuoviUtente(UUID id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Utente found = em.find(Utente.class, id);
        if (found != null) {
            em.remove(found);
            transaction.commit();
            System.out.println("Utente rimosso");
        } else {
            System.out.println("Utente non trovato");
        }
    }

    public Utente cercaUtentePerId(int id) {
        return em.find(Utente.class, id);
    }

    public List<Utente> visualizzaTuttiUtentiDalDatabase() {
        String jpql = "SELECT u FROM Utente u";
        TypedQuery<Utente> query = em.createQuery(jpql, Utente.class);
        return query.getResultList();
    }
}
