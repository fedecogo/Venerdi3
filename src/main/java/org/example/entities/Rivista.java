package org.example.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Rivista extends Archivio {

    @Enumerated(EnumType.STRING)
    @Column(name = "periodicità", nullable = true)
    private Periodicità periodicità;


    public Rivista() {
    }

    public Rivista(UUID isbn, String nome, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(isbn, nome, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    // Getter e setter per periodicità
    public Periodicità getPeriodicità() {
        return periodicità;
    }

    @Override
    public String getTitolo() {
        return super.getTitolo();
    }
}
