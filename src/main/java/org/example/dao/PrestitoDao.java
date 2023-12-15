package org.example.dao;

import org.example.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PrestitoDao {
    private EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }

    public void registraPrestito(Prestito prestito) {
    }

    public List<Prestito> prestitiInScadenza() {
        return null;
    }
}
