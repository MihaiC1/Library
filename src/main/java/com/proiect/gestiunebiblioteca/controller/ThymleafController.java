package com.proiect.gestiunebiblioteca.controller;

import com.proiect.gestiunebiblioteca.entity.Carte;
import com.proiect.gestiunebiblioteca.entity.Imprumut;
import com.proiect.gestiunebiblioteca.entity.Utilizator;
import com.proiect.gestiunebiblioteca.manager.BookDatabaseManager;
import com.proiect.gestiunebiblioteca.manager.CategoryDatabaseManager;
import com.proiect.gestiunebiblioteca.manager.RentDatabaseManager;
import com.proiect.gestiunebiblioteca.manager.UserDatabaseManager;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ThymleafController {

    private BookDatabaseManager bookDatabaseManager;
    private CategoryDatabaseManager categoryDatabaseManager;
    private RentDatabaseManager rentDatabaseManager;
    private UserDatabaseManager userDatabaseManager;

    @Autowired

    public ThymleafController(BookDatabaseManager bookDatabaseManager, CategoryDatabaseManager categoryDatabaseManager, RentDatabaseManager rentDatabaseManager, UserDatabaseManager userDatabaseManager) {
        this.bookDatabaseManager = bookDatabaseManager;
        this.categoryDatabaseManager = categoryDatabaseManager;
        this.rentDatabaseManager = rentDatabaseManager;
        this.userDatabaseManager = userDatabaseManager;
    }
    @GetMapping("/gestiune/v1/login")
    public String login(){
        return "login";
    }

    @GetMapping("/gestiune/v1/home")
    public String home(){
        return "Home";
    }
    @GetMapping("/gestiune/v1/rents-ui/all")
    public String rents(Model model){
        model.addAttribute("rents", rentDatabaseManager.getRentsUI());
        return "rents";
    }
    @GetMapping(value = {"/gestiune/v1/rents-ui/edit-add/{id}", "/gestiune/v1/rents-ui/edit-add"})
    public String editRent(Model model, @PathVariable("id") Optional<Integer> id){
        Imprumut imprumut = id.isPresent() ?
                rentDatabaseManager.findRentById(id.get()).get() : new Imprumut();
        model.addAttribute("rent", imprumut);
        return "edit-add-rents";

    }
    @PostMapping("/gestiune/v1/rents-ui/add")
    public String addRent(@ModelAttribute("rent") Imprumut imprumut, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "edit-add-rents";
        }
        rentDatabaseManager.addRents(imprumut);
        return "redirect:/gestiune/v1/rents-ui/all";
    }
    @GetMapping("/gestiune/v1/rents-ui/delete/{id}")
    public String removeReservation(@PathVariable("id") int id, Model model) {
        rentDatabaseManager.deleteRentById(id);
        model.addAttribute("rents", rentDatabaseManager.getRentsUI());
        return "rents";
    }

    @PostMapping("/gestiune/v1/rents-ui/update/")
    public String updateUser(@ModelAttribute("rent") Imprumut imprumut, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "edit-add-users";
        }
        System.out.println(rentDatabaseManager.findRentById(imprumut.getIdImprumut()).get().getIdUtilizator());
        if (imprumut.getIdUtilizator()!=(rentDatabaseManager.findRentById(imprumut.getIdImprumut()).get().getIdUtilizator())){
            rentDatabaseManager.updateImprumutUserId(imprumut, imprumut.getIdUtilizator());
        }
        //rentDatabaseManager.addUsers(imprumut);
        return "redirect:/gestiune/v1/rents-ui/all";
    }
    @GetMapping("/gestiune/v1/rents-ui/update/{id}")
    public String updateUser(Model model, @PathVariable("id") int id){
        model.addAttribute("rent", rentDatabaseManager.findRentById(id).get());
        return "update-rents";
    }





    @GetMapping("/gestiune/v1/books-ui/all")
    public String books(Model model){
        model.addAttribute("books", bookDatabaseManager.getBooksUI());
        return "Books";
    }
    @GetMapping(value = {"/gestiune/v1/books-ui/edit-add/{id}", "/gestiune/v1/books-ui/edit-add"})
    public String editBook(Model model, @PathVariable("id") Optional<Integer> id){
        Carte carte = id.isPresent() ?
                bookDatabaseManager.findBooksById(id.get()).get() : new Carte();
        model.addAttribute("book", carte);
        return "edit-add-books";

    }
    @PostMapping("/gestiune/v1/books-ui/add")
    public String addBook(@ModelAttribute("carte") Carte carte, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "edit-add-books";
        }
        bookDatabaseManager.addBooks(carte);
        return "redirect:/gestiune/v1/books-ui/all";
    }
    @GetMapping("/gestiune/v1/books-ui/delete/{id}")
    public String removeBook(@PathVariable("id") int id, Model model) {
        bookDatabaseManager.deleteBookById(id);
        model.addAttribute("books", bookDatabaseManager.getBooksUI());
        return "Books";
    }







    @GetMapping("/gestiune/v1/users-ui/all")
    public String users(Model model){
        model.addAttribute("users", userDatabaseManager.getUsersUI());
        return "Users";
    }
    @GetMapping(value = {"/gestiune/v1/users-ui/edit-add/{id}", "/gestiune/v1/users-ui/edit-add"})
    public String editUser(Model model, @PathVariable("id") Optional<Integer> id){
        Utilizator utilzator = id.isPresent() ?
                userDatabaseManager.findUserById(id.get()).get(0) : new Utilizator();
        model.addAttribute("user", utilzator);
        return "edit-add-users";

    }
    @PostMapping("/gestiune/v1/users-ui/add")
    public String addUser(@ModelAttribute("rent") Utilizator utilizator, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "edit-add-users";
        }
        userDatabaseManager.addUsers(utilizator);
        return "redirect:/gestiune/v1/users-ui/all";
    }
//    @PostMapping("/gestiune/v1/users-ui/update")
//    public String updateUser(@ModelAttribute("rent") Utilizator utilizator, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return "edit-add-users";
//        }
//        if (!utilizator.getNume().equals(userDatabaseManager.findUserById(utilizator.getId()).get(0).getNume())){
//            userDatabaseManager.updateUserName(utilizator);
//        }
//        userDatabaseManager.addUsers(utilizator);
//        return "redirect:/gestiune/v1/users-ui/all";
//    }
    @GetMapping("/gestiune/v1/users-ui/delete/{id}")
    public String removeUser(@PathVariable("id") int id, Model model) {
        userDatabaseManager.deleteUserById(id);
        model.addAttribute("users", userDatabaseManager.getUsersUI());
        return "users";
    }

    @GetMapping("/gestiune/v1/users-ui/makeActive/{id}")
    public String users(@PathVariable("id") int id){
        userDatabaseManager.makeActive(id);
        return "redirect:/gestiune/v1/users-ui/all";
    }


}
