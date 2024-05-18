package com.erick.springboot.app.controllers;

import com.erick.springboot.app.models.User;
import com.erick.springboot.app.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/var")

public class PathVariableController {
    @Value("${config.username}")
    private String username;
    @Value("${config.message}")
    private String message;
    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")  //utilizamos ' ' solo para poder utilizar metodos separar, mayúscula, minúscula, etc
    private List<String> valueList;
    @Value("#{'${config.listOfValues}'.toUpperCase()}") //utilizamos ' ' solo para poder utilizar metodos separar, mayúscula, minúscula, etc
    private List<String> valueString;

    @Value("#{${config.valuesMap}}") // no utilizamos ' '  cuando es solo mostrar valores sin modificar
    private Map<String, Object> valuesMap;
    @Value("#{${config.valuesMap}.product}")
    private String product;
    @Value("#{${config.valuesMap}.price}")
    private long price;
    @Value("${config.code}")
    private Integer code;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;

    }
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){  //Object
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){

        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(){

        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product",product);
        json.put("product2", environment.getProperty("config.message"));
        json.put("code2", environment.getProperty("config.code", long.class)); //forma de convertir a entero  long.class
        json.put("code3", Integer.valueOf(environment.getProperty("config.code")));//forma de convertir a entero  Integer.valueOf()
        json.put("pricess", price);
        return json;
    }
}
