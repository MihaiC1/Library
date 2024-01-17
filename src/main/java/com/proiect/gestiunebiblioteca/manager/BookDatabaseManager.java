package com.proiect.gestiunebiblioteca.manager;

import com.proiect.gestiunebiblioteca.entity.Carte;
import com.proiect.gestiunebiblioteca.entity.Imprumut;
import com.proiect.gestiunebiblioteca.repository.CartiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookDatabaseManager {
    @Autowired
    CartiRepo cartiRepo;
    Map<String, Object> response = new HashMap<>();

    public BookDatabaseManager() {
    }

    public ResponseEntity<Object> addBooks(Carte carte){
        System.out.println("Input:\n" + " Titlu: " + carte.getTitlu() + "\nautor: " + carte.getAutor()
                            + "\neditura: " + carte.getEditura() + "\ncolectie: " + carte.getColectie() + "\neditie: " + carte.getEditie()
                            + "\nisbn: " + carte.getIsbn() + "\ntraducator: " + carte.getTraducator()
                            + "\nnumarPagini: " + carte.getNumarPagini() + "\nformat: " + carte.getFormat()
                            + "\ntipCoperta: " + carte.getTipCoperta() + "\ndataAparitie: " + carte.getDataAparitie() + "\nstoc: " + carte.getStoc());
        try{
            if (carte.getTitlu() != null && carte.getAutor() != null && carte.getEditura() != null &&
                carte.getColectie() != null && carte.getIsbn() != null && carte.getTraducator() != null &&
                carte.getNumarPagini() > 0 && carte.getFormat() != null && carte.getTipCoperta() != null &&
                carte.getDataAparitie() != null && carte.getCategorie() != null && carte.getStoc() > 0)
            {
                cartiRepo.insertBook(carte.getTitlu(), carte.getAutor(), carte.getEditura(), carte.getColectie(), carte.getCategorie(), carte.getEditie(), carte.getIsbn(), carte.getTraducator(), carte.getNumarPagini(), carte.getFormat(), carte.getTipCoperta(), carte.getDataAparitie(), carte.getStoc());
                response.put("Raspuns: ", "Cartea a fost adaugata cu succes!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else {
                response.put("Raspuns:", "Cartea nu a fost adaugata!");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            response.put("Raspuns:", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooks(){
        try{
            List<Carte> result = cartiRepo.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            response.put("Response: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public Iterable<Carte> getBooksUI(){
        return cartiRepo.findAll();
    }
    public ResponseEntity<Object> getBooksByCategory(String category){
        try{
            List<Carte> result = cartiRepo.findCarteByCategorie(category);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            response.put("Response: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBooksByAutor(String autor){
        try{
            List<Carte> result = cartiRepo.findCarteByAutor(autor);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            response.put("Response: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Object> getBooksByTitlu(String titlu){
        try{
            List<Carte> result = cartiRepo.findCarteByTitlu(titlu);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            response.put("Response: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Object> getBooksByEditura(String editura){
        try{
            List<Carte> result = cartiRepo.findCarteByEditura(editura);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            response.put("Response: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Object> getBooksByColectie(String colectie){
        try{
            List<Carte> result = cartiRepo.findCarteByColectie(colectie);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            response.put("Response: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Object> getBooksByDataAparitie(String dataAparitie){
        try{
            List<Carte> result = cartiRepo.findCarteByDataAparitie(dataAparitie);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            response.put("Response: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Optional<Carte> findBooksById(int id){
        return cartiRepo.findById(id);
    }
    public void deleteBookById(int id){
        cartiRepo.deleteById(id);
        cartiRepo.updateId();
    }
}
