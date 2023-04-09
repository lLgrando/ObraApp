package com.ObrasApp.ObraApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ObrasApp.ObraApp.model.Imovel;
import com.ObrasApp.ObraApp.service.ImovelService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EditarController {
    
    @Autowired
    private final ImovelService imovelService;

    @PostMapping("/formulario/editar/modifica")
    public String adicionarItem(Imovel imovel){
        imovelService.atualizar(imovel);
        return "redirect:/formulario";
    }

}
