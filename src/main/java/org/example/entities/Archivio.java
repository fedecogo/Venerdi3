package org.example.entities;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "archivio")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Archivio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID isbn;


    private String nome;

    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;


    // Costruttori
    public Archivio() {

    }

    public Archivio(UUID isbn, String nome, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.nome = nome;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    // Getter setter
    public UUID getIsbn() {
        return isbn;
    }

    public void setIsbn(UUID isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
    //toString()

    @Override
    public String toString() {
        return "Archivio{" +
                "isbn=" + isbn +
                ", nome='" + nome + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public String getTitolo() {
        return null;
    }
}
