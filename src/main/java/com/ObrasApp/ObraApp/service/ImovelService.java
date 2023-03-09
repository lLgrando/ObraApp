package com.ObrasApp.ObraApp.service;

import com.ObrasApp.ObraApp.model.Imovel;
import com.ObrasApp.ObraApp.model.Pesquisa;
import com.ObrasApp.ObraApp.repository.ImovelRepository;
import com.ObrasApp.ObraApp.tools.Tools;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public Imovel criar(Imovel imovel) {
        if (imovel.getId() != null) {
            throw new IllegalArgumentException();
        }
        imovel.setId(UUID.randomUUID().toString());
        return imovelRepository.save(imovel);
    }

    public Imovel obter(String id) {
        return imovelRepository.findById(id).orElse(null);
    }

    public List<Imovel> procurar(Pesquisa pesquisa) {
        List<Imovel> listaRetorna = new ArrayList<>();
        if(pesquisa == null){
            return null;
        }
        if(obterTodos().isEmpty() || obterTodos() == null){
            return null;
        }
        List<Imovel> lista = obterTodos();
        for(Imovel imovel : lista ){
            if(Tools.retornaImovelCondicaoCidade(imovel, pesquisa)){listaRetorna.add(imovel);}
            switch (Tools.tipoPesquisa(pesquisa)){
                case 1: if(Tools.retornaImovelCondicaoAll(imovel, pesquisa))listaRetorna.add(imovel); break;
                case 2: if(Tools.retornaImovelCondicaoCidade(imovel, pesquisa))listaRetorna.add(imovel); break;
                case 3: if(Tools.retornaImovelCondicaoDormitorio(imovel, pesquisa))listaRetorna.add(imovel); break;
                case 4: if(Tools.retornaImovelCondicaoPreco(imovel, pesquisa))listaRetorna.add(imovel); break;
            }
        }
        return listaRetorna;
    }
     
    public List<Imovel> obterTodos() {
        List<Imovel> lista = new ArrayList<>();
        imovelRepository.findAll().forEach(imovel -> lista.add(imovel));
        return lista;
    }

    public Imovel atualizar(Imovel imovel) {
        
        return imovelRepository.save(imovel);
    }

    public Imovel delete(String id) {
        Imovel imovel = imovelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        imovelRepository.delete(imovel);
        return imovel;
    }

}
