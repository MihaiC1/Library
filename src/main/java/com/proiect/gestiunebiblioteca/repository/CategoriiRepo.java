package com.proiect.gestiunebiblioteca.repository;

import com.proiect.gestiunebiblioteca.entity.Categorie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriiRepo extends JpaRepository<Categorie, Integer> {

    @Transactional
    @Modifying
    @Query(value="INSERT INTO Categorii (nume_categorie)" +
            " VALUES (:nume_categorie)", nativeQuery = true)
    void insertCategory(@Param("nume_categorie") String nume);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Categorii c SET c.nume_categorie = ?1 WHERE c.id_categorie = ?2", nativeQuery = true)
    void updateNume(String numeCategorie, int idCategorie);


}
