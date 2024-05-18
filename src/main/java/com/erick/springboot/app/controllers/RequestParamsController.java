package com.erick.springboot.app.controllers;

import com.erick.springboot.app.models.dto.ParamDto;
import com.erick.springboot.app.models.dto.ParamMixDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.Param;

import java.awt.*;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola que tal") String message){
        ParamDto param  = new ParamDto();
        param.setMessage(message);
        return param;
    };

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);

        return params;
    };

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){

        Integer code = 10;   //pasamos por defecto 10 para que no haya error si ingresa un string
        try{
            code = Integer.parseInt(request.getParameter("code")); //transformando para aceptar integer a string
        }catch (NumberFormatException e){

        }

        ParamMixDto param = new ParamMixDto();
        param.setCode(code);
        param.setMessage(request.getParameter("message"));
        return param;
    }
}
