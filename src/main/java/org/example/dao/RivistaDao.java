package org.example.dao;

import org.example.entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class RivistaDao {
    private EntityManager em;

    public RivistaDao(EntityManager em) {
        this.em = em;
    }

    public void aggiungiRivista(Rivista rivista) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(rivista);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void rimuoviRivista(UUID isbn) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Rivista rivista = em.find(Rivista.class, isbn);
            if (rivista != null) {
                em.remove(rivista);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Rivista cercaRivistaPerISBN(UUID isbn) {
        return em.find(Rivista.class, isbn);
    }

    public List<Rivista> cercaRivistePerAnnoPubblicazione(int anno) {
        return em.createQuery("SELECT r FROM Rivista r WHERE r.annoPubblicazione = :anno", Rivista.class)
                .setParameter("anno", anno)
                .getResultList();
    }

    public List<Rivista> visualizzaTutteRivisteDalDatabase(){
        TypedQuery<Rivista> query = em.createQuery("SELECT r FROM Rivista r", Rivista.class);
        return query.getResultList();
    }

}
