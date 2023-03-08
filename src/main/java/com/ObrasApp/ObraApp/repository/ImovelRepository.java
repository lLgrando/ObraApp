package com.ObrasApp.ObraApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ObrasApp.ObraApp.model.Imovel;

public interface ImovelRepository extends CrudRepository<Imovel, String> {

    @Query("SELECT i FROM Imovel i WHERE i.preco BETWEEN :precoMin AND :precoMax "
            + "AND i.cidade = :cidade AND i.dormitorio = :dormitorio")
    List<Imovel> buscarImoveisPorPrecoECidadeEDormitorios(
            @Param("precoMin") Double precoMin,
            @Param("precoMax") Double precoMax,
            @Param("cidade") String cidade,
            @Param("dormitorio") Integer dormitorio);

    @Query("SELECT i FROM Imovel i WHERE i.preco BETWEEN :precoMin AND :precoMax "
            + "AND i.dormitorio = :dormitorio")
    List<Imovel> buscarImoveisPorPrecoEDormitorios(
            @Param("precoMin") Double precoMin,
            @Param("precoMax") Double precoMax,
            @Param("dormitorio") Integer dormitorio);

    @Query("SELECT i FROM Imovel i WHERE i.preco BETWEEN :precoMin AND :precoMax "
            + "AND i.cidade = :cidade")
    List<Imovel> buscarImoveisPorPrecoECidade(
            @Param("precoMin") Double precoMin,
            @Param("precoMax") Double precoMax,
            @Param("cidade") String cidade);

    @Query("SELECT i FROM Imovel i WHERE i.preco BETWEEN :precoMin AND :precoMax ")
    List<Imovel> buscarPorPreco(
            @Param("precoMin") Double precoMin,
            @Param("precoMax") Double precoMax);

}
