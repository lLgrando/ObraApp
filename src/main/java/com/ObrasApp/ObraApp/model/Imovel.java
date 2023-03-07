package com.ObrasApp.ObraApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Imovel {
    @Id
    private String id;
    private String nomeImovel;
    private String cidade;
    private Float area;
    private Double preco;
    private Integer dormitorio;

}
