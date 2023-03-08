package com.ObrasApp.ObraApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ObrasApp.ObraApp.model.Pesquisa;
import com.ObrasApp.ObraApp.model.Imovel;
import com.ObrasApp.ObraApp.service.ImovelService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
    
    @Autowired
    private final ImovelService imovelService;
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("imoveis", imovelService.obterTodos());
        return "index";
    }

    @RequestMapping("/pesquisar")
    public String adicionarItem(Pesquisa pesquisa, Model model){    
        model.addAttribute("imoveis", imovelService.procurar(pesquisa));
        return "index";
    }

    @GetMapping("/filtrar")
    public String filtrar(Imovel imovel){
        //imovelService.criar(imovel);
        return "redirect:/index";
    }
}
