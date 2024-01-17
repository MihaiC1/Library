package com.proiect.gestiunebiblioteca.repository;

import com.proiect.gestiunebiblioteca.entity.Imprumut;
import jakarta.transaction.Transactional;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ImprumuturiRepo extends JpaRepository<Imprumut, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Imprumuturi(id_utilizator, id_carte, data_imprumut, data_restituire, penalitati)"+
            "VALUES(:id_utilizator, :id_carte, :data_imprumut, :data_restituire, :penalitati)", nativeQuery = true)
    void addImprumut(@Param("id_utilizator") int idUtilizator, @Param ("id_carte") int idCarte,
                     @Param("data_imprumut")String dataImprumut, @Param("data_restituire")String dataRestituire,
                     @Param("penalitati") float penalitati);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Imprumuturi i SET i.id_carte = ?1 WHERE c.id_imprumut = ?2", nativeQuery = true)
    void updateIdCarte(int idCarte, int idImprumut);
    @Transactional
    @Modifying
    @Query(value = "UPDATE Imprumuturi i SET i.id_utilizator = ?1 WHERE c.id_imprumut = ?2", nativeQuery = true)
    void updateIdUser(int idUtilizator, int idImprumut);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Imprumuturi i SET i.data_imprumut = ?1 WHERE c.id_imprumut = ?2", nativeQuery = true)
    void updateDataImprumut(String dataImprumut, int idImprumut);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Imprumuturi i SET i.data_restituire = ?1 WHERE c.id_imprumut = ?2", nativeQuery = true)
    void updateDataRestituire(String dataRestituire, int idImprumut);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Imprumuturi i SET i.penalitati = ?1 WHERE c.id_imprumut = ?2", nativeQuery = true)
    void updatePenalitati(float penalitati, int idImprumut);

    @Transactional
    @Modifying
    @Query(value = "DELETE from Imprumuturi i where i.id_imprumut = ?1", nativeQuery = true)
    void deleteById(int id);

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE Imprumuturi AUTO_INCREMENT=1", nativeQuery = true)
    void updateId();


}
