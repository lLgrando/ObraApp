package com.ObrasApp.ObraApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormularioController {
    
    @RequestMapping("/formulario")
    public String form(){
        return "formularioDeCadastro";
    }

    
}
