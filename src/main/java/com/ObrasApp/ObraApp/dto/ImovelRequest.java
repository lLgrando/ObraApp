package com.ObrasApp.ObraApp.dto;

import lombok.Data;

@Data
public class ImovelRequest {

    private String nomeImovel;
    private String cidade;
    private Float area;
    private Double preco;
    private Integer dormitorio;

}
