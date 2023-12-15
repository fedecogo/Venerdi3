package org.example.entities;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Libro extends Archivio {
    // ATTRIBUTI
    private String autore;
    private String genere;

    // Costruttori
    public Libro() {
    }

    public Libro(UUID isbn, String autore, String genere, String nome, int annoPubblicazione, int numeroPagine) {
        super(isbn, nome, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    // Getter
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String getTitolo() {
        return "Titolo del libro";
    }
}
