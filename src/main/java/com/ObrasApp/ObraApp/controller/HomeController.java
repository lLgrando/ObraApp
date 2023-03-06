package com.ObrasApp.ObraApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ObrasApp.ObraApp.service.ImovelService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
    
    @Autowired
    private final ImovelService imovelService;
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("imoveis", imovelService.ObterTodos());
        return "index";
    }
}
