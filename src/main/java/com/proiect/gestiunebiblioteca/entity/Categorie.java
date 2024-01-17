package com.proiect.gestiunebiblioteca.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Categorii")
@Data
public class Categorie {

    @Id
    @Column(name = "id_categorie")
    @GeneratedValue
    private int id;

    @Column(name = "nume_categorie")
    private String numeCategorie;

    public Categorie() {
    }

    public Categorie(int id, String numeCategorie) {
        this.id = id;
        this.numeCategorie = numeCategorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeCategorie() {
        return numeCategorie;
    }

    public void setNumeCategorie(String numeCategorie) {
        this.numeCategorie = numeCategorie;
    }
}
