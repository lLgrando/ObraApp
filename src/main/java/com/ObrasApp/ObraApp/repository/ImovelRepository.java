package com.ObrasApp.ObraApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.ObrasApp.ObraApp.model.Imovel;

public interface ImovelRepository extends CrudRepository<Imovel, String> {
    
}
