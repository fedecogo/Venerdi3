package org.example.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Date;
import java.util.UUID;

@Entity
public class Utente {
    //ATTRIBUTI
    @Id
    @GeneratedValue
    private UUID tessera;
    private String nome;
    private String cognome;
    private Date dataDiNascita;


    //GETTERS
    public UUID getTessera() {
        return tessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    //COSTRUTTORI
    public Utente() {
    }

    public Utente(String nome, String cognome, Date dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    //toString()
    @Override
    public String toString() {
        return "Utente{" +
                "tessera=" + tessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
