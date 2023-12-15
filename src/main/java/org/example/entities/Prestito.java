package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Archivio archivioPrestato;

    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(Utente utente, Archivio archivioPrestato) {
        this.utente = utente;
        this.archivioPrestato = archivioPrestato;
        this.dataInizioPrestito = LocalDate.now();
        this.dataRestituzionePrevista = this.dataInizioPrestito.plusDays(30);
    }

    // Getter e setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Archivio getArchivioPrestato() {
        return archivioPrestato;
    }

    public void setArchivioPrestato(Archivio archivioPrestato) {
        this.archivioPrestato = archivioPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", archivioPrestato=" + archivioPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}

