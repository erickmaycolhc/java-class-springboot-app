package com.erick.springboot.app.controllers;

import com.erick.springboot.app.models.User;
import com.erick.springboot.app.models.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/api")
public class UserRestController {


    @GetMapping("/json-dto")
    public UserDto detailsDto(){

        UserDto userDto = new UserDto();

        User user = new User("Erick", "Huallullo");
        userDto.setUser(user);
        userDto.setTitle("Bienvenidos spring boot");

        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
       User user  = new User("Chique", "Cirineo"); //Creando usuarios
       User user2 = new User("Nico Ni", "Cirineo");
       User user3 = new User("Miau", "Cirineo");

       List<User> users = Arrays.asList(user, user2, user3); //lista de usuarios
       /*List<User> users = new ArrayList<>();
               users.add(user);
               users.add(user2);
               users.add(user3);*/

        return users;
     };

    @GetMapping("/json-map")
    public Map<String, Object> detailsMap(){

        User user = new User("Maycol","Cirineo");
        Map<String, Object> body = new HashMap<>();

        body.put("title","Bienvenidos spring boot");
        body.put("user", user);

        return body;
    }
}
