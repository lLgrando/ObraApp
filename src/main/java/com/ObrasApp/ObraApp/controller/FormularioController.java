package com.ObrasApp.ObraApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ObrasApp.ObraApp.model.Imovel;
import com.ObrasApp.ObraApp.service.ImovelService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FormularioController {

    private final ImovelService imovelService;

    @GetMapping("/formulario")
    public String formulario(Model model){
        model.addAttribute("imoveis", imovelService.obterTodos());
        return "formularioDeCadastro";
    }

    @RequestMapping("/formulario/editar/{id}")
    public String index(@PathVariable("id") String id, Model model){
        model.addAttribute("imovel", imovelService.obter(id));
        return "editar";
    }

    @PostMapping("/formulario/adicionar")
    public String adicionarItem(Imovel imovel){
        imovelService.criar(imovel);
        return "redirect:/formulario";
    }

    @RequestMapping("/formulario/delete/{id}")
    public String deleteComodo(@PathVariable("id") String id) {
        imovelService.delete(id);
        return "redirect:/formulario";
    }
    
}
