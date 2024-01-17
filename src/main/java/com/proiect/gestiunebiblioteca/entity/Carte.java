package com.proiect.gestiunebiblioteca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Carti")
@Data
public class Carte {

    @Column(name = "id_carte")
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "titlu")
    private String titlu;

    @Column(name = "autor")
    private String autor;

    @Column(name = "editura")
    private String editura;

    @Column(name = "categorie")
    private String categorie;

    @Column(name = "colectie")
    private String colectie;

    @Column(name="editie")
    private int editie;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "traducator")
    private String traducator;

    @Column(name = "numar_pagini")
    private int numarPagini;

    @Column(name = "format")
    private String format;

    @Column(name = "tip_coperta")
    private String tipCoperta;

    @Column(name = "data_aparitie")
    private String dataAparitie;

    @Column(name = "stoc")
    private int stoc;

    public Carte(){

    }

    public Carte(String titlu, String autor,
                 String editura, String colectie,
                 String categorie, int editie,
                 String isbn, String traducator,
                 int numarPagini, String format,
                 String tip_coperta, String dataAparitie,
                 int stoc) {

        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.colectie = colectie;
        this.categorie = categorie;
        this.editie = editie;
        this.isbn = isbn;
        this.traducator = traducator;
        this.numarPagini = numarPagini;
        this.format = format;
        this.tipCoperta = tip_coperta;
        this.dataAparitie = dataAparitie;
        this.stoc = stoc;
    }

    public Carte(String titlu, String autor,
                 String editura, String categorie,
                 String colectie, int editie,
                 String isbn, String traducator,
                 int numarPagini, String format,
                 String tipCoperta, String dataAparitie) {
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.categorie = categorie;
        this.colectie = colectie;
        this.editie = editie;
        this.isbn = isbn;
        this.traducator = traducator;
        this.numarPagini = numarPagini;
        this.format = format;
        this.tipCoperta = tipCoperta;
        this.dataAparitie = dataAparitie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getColectie() {
        return colectie;
    }

    public void setColectie(String colectie) {
        this.colectie = colectie;
    }

    public int getEditie() {
        return editie;
    }

    public void setEditie(int editie) {
        this.editie = editie;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTraducator() {
        return traducator;
    }

    public void setTraducator(String traducator) {
        this.traducator = traducator;
    }

    public int getNumarPagini() {
        return numarPagini;
    }

    public void setNumarPagini(int numarPagini) {
        this.numarPagini = numarPagini;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTipCoperta() {
        return tipCoperta;
    }

    public void setTipCoperta(String tipCoperta) {
        this.tipCoperta = tipCoperta;
    }

    public String getDataAparitie() {
        return dataAparitie;
    }

    public void setDataAparitie(String dataAparitie) {
        this.dataAparitie = dataAparitie;
    }

//    public int getStoc() {
//        return stoc;
//    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }
}
