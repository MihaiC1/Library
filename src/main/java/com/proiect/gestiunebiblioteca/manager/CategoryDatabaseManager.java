package com.proiect.gestiunebiblioteca.manager;


import com.proiect.gestiunebiblioteca.entity.Carte;
import com.proiect.gestiunebiblioteca.entity.Categorie;
import com.proiect.gestiunebiblioteca.repository.CategoriiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryDatabaseManager {
    @Autowired
    CategoriiRepo categoriiRepo;
    Map<String, Object> response = new HashMap<>();
    public ResponseEntity<Object> addCategories(String nume){
        System.out.println("Input: \n" + " Nume: " + nume);
        try{
            if (nume != null){
                categoriiRepo.insertCategory(nume);
                response.put("Raspuns: ", "Categoria a fost adaugata cu succes!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else {
                response.put("Raspuns:", "Categoria nu a fost adaugata!");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            response.put("Raspuns:", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getCategories(){
        try{
            List<Categorie> result = categoriiRepo.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            response.put("Response: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
