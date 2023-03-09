package com.ObrasApp.ObraApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ObrasApp.ObraApp.model.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, String> {

    List<Imovel> findByPrecoBetweenAndCidadeAndDormitorio(Double precoMin, Double precoMax, String cidade, Integer dormitorio);
    List<Imovel> findByPrecoBetweenAndDormitorio(Double precoMin, Double precoMax, Integer dormitorio);
    List<Imovel> findByPrecoBetweenAndCidade(Double precoMin, Double precoMax, String cidade);
    List<Imovel> findByPrecoBetween(Double precoMin, Double precoMax);

    /*
     * @Query("SELECT i FROM Imovel i WHERE i.preco BETWEEN :precoMin AND :precoMax "
     * + "AND i.cidade = :cidade AND i.dormitorio = :dormitorio")
     * List<Imovel> buscarImoveisPorPrecoECidadeEDormitorios(
     * 
     * @Param("precoMin") Double precoMin,
     * 
     * @Param("precoMax") Double precoMax,
     * 
     * @Param("cidade") String cidade,
     * 
     * @Param("dormitorio") Integer dormitorio);
     */
}
