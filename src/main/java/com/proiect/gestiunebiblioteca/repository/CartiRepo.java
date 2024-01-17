package com.proiect.gestiunebiblioteca.repository;

import com.proiect.gestiunebiblioteca.entity.Carte;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartiRepo extends JpaRepository<Carte, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Carti (titlu, autor, editura, colectie, categorie, editie, isbn,traducator, numar_pagini, format, tip_coperta, data_aparitie, stoc)" +
           "VALUES (:titlu, :autor, :editura, :colectie, :categorie, :editie, :isbn, :traducator, :numar_pagini, :format, :tip_coperta, :data_aparitie, :stoc)", nativeQuery = true)
    void insertBook(@Param("titlu") String titlu, @Param("autor") String autor,
                    @Param("editura") String editura, @Param("colectie") String colectie,
                    @Param("categorie") String categorie, @Param("editie") int editie,
                    @Param("isbn") String isbn, @Param("traducator") String traducator,
                    @Param("numar_pagini") int numarPagini, @Param("format") String format,
                    @Param("tip_coperta") String tipCoperta, @Param("data_aparitie") String dataAparitie,
                    @Param("stoc") int stoc);

    @Query(value = "SELECT new Carte(c.titlu, c.autor, c.editura, c.colectie, c.categorie,c.editie, c.isbn, c.traducator, c.numarPagini, c.format, c.tipCoperta, c.dataAparitie)"+
                    "FROM Carte c WHERE c.categorie= ?1")
    List<Carte> findCarteByCategorie(String category);
    @Query(value = "SELECT new Carte(c.titlu, c.autor, c.editura, c.colectie, c.categorie,c.editie, c.isbn, c.traducator, c.numarPagini, c.format, c.tipCoperta, c.dataAparitie)"+
            "FROM Carte c WHERE c.autor= ?1")
    List<Carte> findCarteByAutor(String autor);

    @Query(value = "SELECT new Carte(c.titlu, c.autor, c.editura, c.colectie, c.categorie,c.editie, c.isbn, c.traducator, c.numarPagini, c.format, c.tipCoperta, c.dataAparitie)"+
            "FROM Carte c WHERE c.titlu= ?1")
    List<Carte> findCarteByTitlu(String titlu);

    @Query(value = "SELECT new Carte(c.titlu, c.autor, c.editura, c.colectie, c.categorie,c.editie, c.isbn, c.traducator, c.numarPagini, c.format, c.tipCoperta, c.dataAparitie)"+
            "FROM Carte c WHERE c.editura= ?1")
    List<Carte> findCarteByEditura(String editura);

    @Query(value = "SELECT new Carte(c.titlu, c.autor, c.editura, c.colectie, c.categorie,c.editie, c.isbn, c.traducator, c.numarPagini, c.format, c.tipCoperta, c.dataAparitie)"+
            "FROM Carte c WHERE c.colectie= ?1")
    List<Carte> findCarteByColectie(String colectie);

    @Query(value = "SELECT new Carte(c.titlu, c.autor, c.editura, c.colectie, c.categorie,c.editie, c.isbn, c.traducator, c.numarPagini, c.format, c.tipCoperta, c.dataAparitie)"+
            "FROM Carte c WHERE c.dataAparitie= ?1")
    List<Carte> findCarteByDataAparitie(String dataAparitie);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.stoc = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateStoc(float stocNou, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.titlu = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateTitlu(String titlu, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.autor = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateAutor(String autor, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.editura = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateEditura(String editura, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.colectie = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateColectie(String colectie, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.categorie = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateCategorie(String categorie, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.editie = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateEditie(String editie, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.isbn = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateIsbn(String isbn, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.traducator = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateTraducator(String traducator, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.numar_pagini = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateNumarPagini(int numarPagini, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.format = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateFormat(String format, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.tip_coperta = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateTipCoperta(String tipCoperta, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Carti c SET c.data_aparitie = ?1 WHERE c.id_carte = ?2", nativeQuery = true)
    void updateDataAparitie(String dataAparitie, int idCarte);

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE Carti AUTO_INCREMENT=1", nativeQuery = true)
    void updateId();
}
