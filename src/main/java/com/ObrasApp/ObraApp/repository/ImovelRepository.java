package com.ObrasApp.ObraApp.repository;

import com.ObrasApp.ObraApp.model.Imovel;
import org.springframework.data.repository.CrudRepository;

public interface ImovelRepository extends CrudRepository<Imovel, String> {
    
}
