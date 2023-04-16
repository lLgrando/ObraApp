package com.ObrasApp.ObraApp.service;

import com.ObrasApp.ObraApp.dto.Simulador;
import com.ObrasApp.ObraApp.model.Imovel;
import com.ObrasApp.ObraApp.model.Pesquisa;
import com.ObrasApp.ObraApp.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Imovel> obterTodos() {
        List<Imovel> lista = new ArrayList<>();
        imovelRepository.findAll().forEach(imovel -> lista.add(imovel));
        return lista;
    }

    public Imovel obter(String id) {
        return imovelRepository.findById(id).orElse(null);
    }

    public List<Imovel> procurar(Pesquisa pesquisa) {
        if(pesquisa.getCidade() == "" && pesquisa.getDormitorio() == 0){
            return imovelRepository.findByPrecoBetween(pesquisa.getPrecoMin(), pesquisa.getPrecoMax());
        }else if(pesquisa.getDormitorio() == 0){
            return imovelRepository.findByPrecoBetweenAndCidade(pesquisa.getPrecoMin(), pesquisa.getPrecoMax(), pesquisa.getCidade());
        }else if(pesquisa.getCidade() == "") {
            return imovelRepository.findByPrecoBetweenAndDormitorio(pesquisa.getPrecoMin(), pesquisa.getPrecoMax(), pesquisa.getDormitorio());
        }else {
            return imovelRepository.findByPrecoBetweenAndCidadeAndDormitorio(pesquisa.getPrecoMin(), pesquisa.getPrecoMax(), pesquisa.getCidade(), pesquisa.getDormitorio());
        }
    }
     
    public Imovel atualizar(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public Imovel delete(String id) {
        Imovel imovel = imovelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        imovelRepository.delete(imovel);
        return imovel;
    }

    public Simulador simularValorDaParcela(Simulador simulador){
        if(simulador.getValorDaEntrada() == null)
            simulador.setValorDaEntrada(Float.parseFloat("0"));
        
        if(simulador.getValorDoFgts() == null)
            simulador.setValorDoFgts((Float.parseFloat("0")));
        
        Float valorLiquido = simulador.getValorDoImovel() - simulador.getValorDaEntrada() - simulador.getValorDoFgts();

        return simularParcelas(simulador, valorLiquido);
    }

    private Simulador simularParcelas(Simulador simulador, Float valorLiquido){
        float jurosMenosDeDezAnos = (float) 1.11;
        float jurosEntreDezEVinteAnos = (float) 1.15;
        float jurosMaisDeVinteAnos = (float) 1.19;

        if(simulador.getPrestacoes() <= 120){
            simulador.setValorDaParcela((valorLiquido * jurosMenosDeDezAnos) / simulador.getPrestacoes());
            simulador.setValorFinalDoImovel(simulador.getValorDoImovel() * jurosMenosDeDezAnos);
            return simulador;
        } else if(simulador.getPrestacoes() > 120 && simulador.getPrestacoes() <= 240){
            simulador.setValorDaParcela((valorLiquido * jurosEntreDezEVinteAnos) / simulador.getPrestacoes());
            simulador.setValorFinalDoImovel(simulador.getValorDoImovel() * jurosEntreDezEVinteAnos);
            return simulador;
        } else {
            simulador.setValorDaParcela((valorLiquido * jurosMaisDeVinteAnos) / simulador.getPrestacoes());
            simulador.setValorFinalDoImovel(simulador.getValorDoImovel() * jurosMaisDeVinteAnos);
            return simulador;
        }
    }
    
}
