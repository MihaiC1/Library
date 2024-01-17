package com.proiect.gestiunebiblioteca.manager;

import com.proiect.gestiunebiblioteca.entity.Imprumut;
import com.proiect.gestiunebiblioteca.entity.Utilizator;
import com.proiect.gestiunebiblioteca.repository.UtilizatoriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserDatabaseManager {

    @Autowired
    UtilizatoriRepo utilizatoriRepo;
    Map<String, Object> response = new HashMap<>();
    public UserDatabaseManager(){

    }
    public ResponseEntity<Object> addUsers(Utilizator utilizator){
        System.out.println("Input: \n" + " Nume: " + utilizator.getNume() + " NrTel: " + utilizator.getNumarTelefon());
        try{
            if (utilizator.getNume() != null && utilizator.getNumarTelefon() != null && utilizator.getNumarTelefon().length() != 9 && utilizator.getEmail() != null){
                utilizatoriRepo.insertUsers(utilizator.getNume(),utilizator.getNumarTelefon(), utilizator.getEmail());
                response.put("Raspuns: ", "Utilizatorul a fost adaugat cu succes!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else {
                response.put("Raspuns:", "Utilizatorul nu a fost adaugat!");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            response.put("Raspuns:", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getUsers(){
        try{
            List<Utilizator> result = utilizatoriRepo.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            response.put("Response: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public Iterable<Utilizator> getUsersUI(){
        return utilizatoriRepo.findAll();
    }
    public List<Utilizator> findUserById(int id){return utilizatoriRepo.findById(id);}
    public ResponseEntity<Object> deleteUser(int id){
        try{
            List<Utilizator> result = utilizatoriRepo.findById(id);
            if (result.isEmpty()){
                response.put("Raspuns: ", "Nu au fost gasiti utilizatori cu id: " + id);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            utilizatoriRepo.delete(id);
            System.out.println(result.get(0));
            if (utilizatoriRepo.findById(id).isEmpty()){
                response.put("Raspuns: ", "Utilizator sters cu succes!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else{
                response.put("Raspuns: ", "Utilizatorul nu a fost sters!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        }catch (Exception e){
            response.put ("Raspuns: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void deleteUserById(int id){
        utilizatoriRepo.deleteById(id);

        utilizatoriRepo.updateId();
    }

    public void makeActive(int id){
        utilizatoriRepo.makeActive(id);
    }

    public void updateUserName(Utilizator utilizator){
        utilizatoriRepo.updateName(utilizator.getId(), utilizator.getNume());
    }

}
