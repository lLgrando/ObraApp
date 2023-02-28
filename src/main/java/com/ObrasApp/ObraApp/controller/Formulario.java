package com.ObrasApp.ObraApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Formulario {
    
    @RequestMapping("/formulario")
    public String index(){
        return "form";
    }

}
