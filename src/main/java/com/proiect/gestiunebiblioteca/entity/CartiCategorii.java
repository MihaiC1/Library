package com.proiect.gestiunebiblioteca.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Carti_Categorii")
@Data
public class CartiCategorii {

    @Column(name = "id_carte")
    @Id
    private int idCarte;

    @Column(name = "id_categorie")
    @Id
    private int idCategorie;

    @OneToOne
    @JoinColumn(name = "id_carte")
    private Carte carte;

    @OneToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    public CartiCategorii() {
    }

    public CartiCategorii(int idCarte, int idCategorie) {
        this.idCarte = idCarte;
        this.idCategorie = idCategorie;
    }

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
}
