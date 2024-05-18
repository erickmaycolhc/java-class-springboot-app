package com.erick.springboot.app.controllers;

import com.erick.springboot.app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;


@Controller
public class UserController{
    @GetMapping("/details")
    public String details(Model model){

        User user = new User("Erick","Cirineo");
        user.setEmail("erickmaycolhc@gmail.com");
        model.addAttribute("title", "Hola bienvenido a spring boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        /*List<User> users = Arrays.asList(
                new User("Pedro","Doe"),
                new User("Jorge","Die", "JorgeLC@gmail.com"),
                new User("Josue","Doo", "Josue12@gmail.com"),
                new User("Pablito", "Due")
        );

        model.addAttribute("users", users); */
        model.addAttribute("title","Listado de usuarios");
        return "list";
    }
    @ModelAttribute("users")
    public List<User> modelUsers(){
        return Arrays.asList(
                new User("Pedro","Doe"),
                new User("Jorge","Die", "JorgeLC@gmail.com"),
                new User("Josue","Doo", "Josue12@gmail.com"),
                new User("Pablito", "Due")
        );
    }
}

