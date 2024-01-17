package com.proiect.gestiunebiblioteca.repository;

import com.proiect.gestiunebiblioteca.entity.Utilizator;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilizatoriRepo extends JpaRepository<Utilizator, Integer> {

    @Transactional
    @Modifying
    @Query(value="INSERT INTO Utilizatori (nume, numar_telefon, email, activ)" +
            " VALUES (:nume, :numar_telefon, :email, false)", nativeQuery = true)
    void insertUsers(@Param("nume") String nume,
                     @Param("numar_telefon") String numarTelefon,
                     @Param("email") String email
                     );

    @Query(value = "SELECT new Utilizator(u.nume, u.numarTelefon, u.email, u.activ) FROM Utilizator u WHERE u.id = ?1")
    List<Utilizator> findById(int id);

    @Query(value = "DELETE FROM Utilizator u WHERE u.id = ?1")
    @Modifying
    void delete(int id);

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE Utilizatori AUTO_INCREMENT=1", nativeQuery = true)
    void updateId();

    @Transactional
    @Modifying
    @Query(value = "UPDATE Utilizatori u SET u.activ = true WHERE u.id_utilizator = ?1", nativeQuery = true)
    void makeActive(int idUtilizator);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Utilizatori u SET u.nume = ?2 WHERE u.id_utilizator = ?1", nativeQuery = true)
    void updateName(int idUtilizator, String nume);

}
