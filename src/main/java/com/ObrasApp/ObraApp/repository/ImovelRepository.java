package com.ObrasApp.ObraApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ObrasApp.ObraApp.model.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, String> {

    List<Imovel> findByPrecoBetweenAndCidadeAndDormitorio(Double precoMin, Double precoMax, String cidade, Integer dormitorio);
    List<Imovel> findByPrecoBetweenAndDormitorio(Double precoMin, Double precoMax, Integer dormitorio);
    List<Imovel> findByPrecoBetweenAndCidade(Double precoMin, Double precoMax, String cidade);
    List<Imovel> findByPrecoBetween(Double precoMin, Double precoMax);

}
