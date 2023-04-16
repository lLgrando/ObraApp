package com.ObrasApp.ObraApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ObrasApp.ObraApp.dto.Simulador;
import com.ObrasApp.ObraApp.model.Pesquisa;
import com.ObrasApp.ObraApp.service.ImovelService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
    
    private final ImovelService imovelService;
    
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("imoveis", imovelService.obterTodos());
        return "home";
    }

    @RequestMapping("/pesquisar")
    public String adicionarItem(Pesquisa pesquisa, Model model){    
        model.addAttribute("imoveis", imovelService.procurar(pesquisa));
        return "home";
    }

    @GetMapping("/simulador")
    public String simulador(){
        return "simulador";
    }

    @PostMapping("/simulador")
    public String simulador(Simulador simulador, Model model){
        model.addAttribute("simulacao", imovelService.simularValorDaParcela(simulador));
        return "simulador";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }
}
