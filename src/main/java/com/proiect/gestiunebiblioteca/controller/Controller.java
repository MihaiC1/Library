package com.proiect.gestiunebiblioteca.controller;

import com.proiect.gestiunebiblioteca.entity.Carte;
import com.proiect.gestiunebiblioteca.entity.Categorie;
import com.proiect.gestiunebiblioteca.entity.Imprumut;
import com.proiect.gestiunebiblioteca.entity.Utilizator;
import com.proiect.gestiunebiblioteca.manager.BookDatabaseManager;
import com.proiect.gestiunebiblioteca.manager.CategoryDatabaseManager;
import com.proiect.gestiunebiblioteca.manager.RentDatabaseManager;
import com.proiect.gestiunebiblioteca.manager.UserDatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@EnableJpaRepositories(basePackages = "com.proiect.gestiunebiblioteca.repository")
@RequestMapping(value = "/")
@Scope("request")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    UserDatabaseManager userDatabaseManager;
    @Autowired
    BookDatabaseManager bookDatabaseManager;
    @Autowired
    CategoryDatabaseManager categoryDatabaseManager;
    @Autowired
    RentDatabaseManager rentDatabaseManager;

    @RequestMapping(value = "/gestiune/v1/user/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestBody Utilizator utilizator){
        return userDatabaseManager.addUsers(utilizator);
    }
    @RequestMapping(value = "/gestiune/v1/user/all", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers(){

        return userDatabaseManager.getUsers();
    }
    @RequestMapping(value = "/gestiune/v1/user/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@RequestParam("Id") int id){
        return userDatabaseManager.deleteUser(id);
    }




    @RequestMapping(value = "/gestiune/v1/book/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addBook(@RequestBody Carte carte){
        return bookDatabaseManager.addBooks(carte);
    }

    @RequestMapping(value = "/gestiune/v1/book/all", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooks(){

        return bookDatabaseManager.getBooks();
    }
    @RequestMapping(value = "/gestiune/v1/book/find/category", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooksByCategory(@RequestParam("categorie")String categorie){
        return bookDatabaseManager.getBooksByCategory(categorie);
    }
    @RequestMapping(value = "/gestiune/v1/book/find/author", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooksByAuthor(@RequestParam("autor")String autor){
        return bookDatabaseManager.getBooksByAutor(autor);
    }

    @RequestMapping(value = "/gestiune/v1/book/find/title", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooksByTitle(@RequestParam("titlu")String titlu){
        return bookDatabaseManager.getBooksByTitlu(titlu);
    }

    @RequestMapping(value = "/gestiune/v1/book/find/editura", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooksByEditura(@RequestParam("editura")String editura){
        return bookDatabaseManager.getBooksByEditura(editura);
    }

    @RequestMapping(value = "/gestiune/v1/book/find/collection", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooksByCollection(@RequestParam("colectie")String colectie){
        return bookDatabaseManager.getBooksByColectie(colectie);
    }

    @RequestMapping(value = "/gestiune/v1/book/find/release", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooksByReleaseDate(@RequestParam("dataAparitie")String dataAparitie){
        return bookDatabaseManager.getBooksByDataAparitie(dataAparitie);
    }

    @RequestMapping(value = "/gestiune/v1/category/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestParam("Nume") String nume){
        return categoryDatabaseManager.addCategories(nume);
    }

    @RequestMapping(value = "/gestiune/v1/category/all", method = RequestMethod.GET)
    public ResponseEntity<Object> getCategories(){

        return categoryDatabaseManager.getCategories();
    }


    @RequestMapping(value = "/gestiune/v1/rent/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addRent(@RequestBody Imprumut imprumut){
        return rentDatabaseManager.addRents(imprumut);
    }

    @RequestMapping(value = "/gestiune/v1/rents/all", method = RequestMethod.GET)
    public ResponseEntity<Object> getRents(){

        return rentDatabaseManager.getRents();
    }

}
