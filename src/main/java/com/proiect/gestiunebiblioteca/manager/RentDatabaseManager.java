package com.proiect.gestiunebiblioteca.manager;


import com.proiect.gestiunebiblioteca.entity.Carte;
import com.proiect.gestiunebiblioteca.entity.Imprumut;
import com.proiect.gestiunebiblioteca.entity.Utilizator;
import com.proiect.gestiunebiblioteca.repository.CartiRepo;
import com.proiect.gestiunebiblioteca.repository.ImprumuturiRepo;
import com.proiect.gestiunebiblioteca.repository.UtilizatoriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RentDatabaseManager {
    @Autowired
    ImprumuturiRepo imprumuturiRepo;
    @Autowired
    CartiRepo cartiRepo;
    @Autowired
    UtilizatoriRepo utilizatoriRepo;
    Map<String, Object> response = new HashMap<>();

    public RentDatabaseManager() {
    }

    public ResponseEntity<Object> addRents(Imprumut imprumut){
        System.out.println("IASNDASNDN OUT!");
        try{
            Carte carte = cartiRepo.findById(imprumut.getIdCarte()).get();
            Utilizator utilizator = utilizatoriRepo.findById(imprumut.getIdUtilizator()).get(0);
            System.out.println("IASNDASNDN");
            if (imprumut.getIdUtilizator() > 0 && imprumut.getIdCarte() > 0 &&
                imprumut.getDataRestituire() != null && imprumut.getDataImprumut() != null &&
                imprumut.getPenalitati() == 0) {


                if (carte != null && utilizator != null){
                    imprumuturiRepo.addImprumut(imprumut.getIdUtilizator(), imprumut.getIdCarte(), imprumut.getDataImprumut(), imprumut.getDataRestituire(), imprumut.getPenalitati());
                    int stocNou = carte.getStoc() - 1;
                    cartiRepo.updateStoc(stocNou, carte.getId());
                    System.out.println("Imprumutul a fost adaugat cu succes!");
                    response.put("Raspuns: ", "Imprumutul a fost adaugat cu succes!");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                else{
                    System.out.println("Imprumutul nu a fost adaugat!");
                    response.put("Raspuns: ", "Imprumutul nu a fost adaugat!");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }

            }
            else{
                System.out.println("Imprumutul nu a fost adaugat!");
                response.put("Raspuns: ", "Imprumutul nu a fost adaugat!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            response.put("Raspuns:", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getRents(){
        try{
            List<Imprumut> result = imprumuturiRepo.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            response.put("Response: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public Optional<Imprumut> findRentById(int id){return imprumuturiRepo.findById(id);}
    public void deleteRentById(int id){
        imprumuturiRepo.deleteById(id);
        imprumuturiRepo.updateId();
    }
    public Iterable<Imprumut> getRentsUI(){
        return imprumuturiRepo.findAll();
    }

    public void updateImprumutTitlu(int id, int idNou){
        imprumuturiRepo.updateIdCarte(id, idNou);
    }
    public void updateImprumut(int id, int idNou){
        imprumuturiRepo.updateIdCarte(id, idNou);
    }
    public ResponseEntity<Object> updateImprumutUserId(Imprumut imprumut, int idNou){
        imprumuturiRepo.updateIdUser(idNou, imprumut.getIdImprumut());
        response.put("Raspuns: ", "Id-ul utilizatorului a fost actualizat cu success!");
        return new ResponseEntity<>(response, HttpStatus.OK);


    }



}
