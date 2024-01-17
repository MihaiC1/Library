package com.proiect.gestiunebiblioteca.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "utilizatori")
@Data
public class Utilizator {

    @Id
    @Column (name = "id_utilizator")
    @GeneratedValue
    private int id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "email")
    private String email;

    @Column(name = "numar_telefon")
    private String numarTelefon;

    @Column(name = "activ")
    private Boolean activ;

    public Utilizator() {
    }
    public Utilizator(int id, String nume, String numarTelefon, boolean activ, String email) {
        this.id = id;
        this.nume = nume;
        this.email = email;
        this.numarTelefon = numarTelefon;
        this.activ = activ;
    }
    public Utilizator(String nume, String numarTelefon, String email,boolean activ) {
        this.nume = nume;
        this.numarTelefon = numarTelefon;
        this.email = email;
        this.activ = activ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public Boolean getActiv() {
        return activ;
    }

    public void setActiv(Boolean activ) {
        this.activ = activ;
    }
}
