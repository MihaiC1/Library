package com.proiect.gestiunebiblioteca.entity;


import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "Imprumuturi")
@Data
public class Imprumut {

    @Id
    @Column(name = "id_imprumut")
    @GeneratedValue
    private int idImprumut;

    @Column(name = "id_utilizator", insertable=false, updatable=false)
    private int idUtilizator;

    @Column(name = "id_carte", insertable=false, updatable=false)
    private int idCarte;

    @Column(name = "data_imprumut")
    private String dataImprumut;

    @Column(name = "data_restituire")
    private String dataRestituire;

    @Column(name = "penalitati")
    private float penalitati;

    @ManyToOne
    @JoinColumn(name = "id_utilizator")
    private Utilizator utilizator;

    @ManyToOne
    @JoinColumn(name = "id_carte")
    private Carte carte;


    public Imprumut() {
    }

    public Imprumut(int idUtilizator, int idCarte, String dataImprumut, String dataRestituire, float penalitati, Utilizator utilizator, Carte carte) {

        this.idUtilizator = idUtilizator;
        this.idCarte = idCarte;
        this.dataImprumut = dataImprumut;
        this.dataRestituire = dataRestituire;
        this.penalitati = penalitati;
        this.utilizator = utilizator;
        this.carte = carte;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public int getIdImprumut() {
        return idImprumut;
    }

    public void setIdImprumut(int idImprumut) {
        this.idImprumut = idImprumut;
    }

    public int getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(int idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public String getDataImprumut() {
        return dataImprumut;
    }

    public void setDataImprumut(String dataImprumut) {
        this.dataImprumut = dataImprumut;
    }

    public String getDataRestituire() {
        return dataRestituire;
    }

    public void setDataRestituire(String dataRestituire) {
        this.dataRestituire = dataRestituire;
    }

    public float getPenalitati() {
        return penalitati;
    }

    public void setPenalitati(float penalitati) {
        this.penalitati = penalitati;
    }
}
