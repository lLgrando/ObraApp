package com.ObrasApp.ObraApp.tools;

import com.ObrasApp.ObraApp.model.Imovel;
import com.ObrasApp.ObraApp.model.Pesquisa;

import java.util.Objects;

public class Tools {

    public static int tipoPesquisa(Pesquisa pesquisa){
        if(!(pesquisa.getCidade().isEmpty() || pesquisa.getCidade().isBlank())
                && (pesquisa.getDormitorio() == 0 || pesquisa.getDormitorio() == null)){
            return 2;
        } else if ((pesquisa.getCidade().isEmpty() || pesquisa.getCidade().isBlank() || pesquisa.getCidade() == null)
                && !(pesquisa.getDormitorio() == 0)) {
            return 3;
        } else if ((pesquisa.getCidade().isEmpty() || pesquisa.getCidade().isBlank() || pesquisa.getCidade() == null)
                && (pesquisa.getDormitorio() == 0 || pesquisa.getDormitorio() == null)) {
            return 4;
        } else {
            return 1;
        }
    }

    public static boolean retornaImovelCondicaoAll(Imovel imovel, Pesquisa pesquisa){
        if(imovel.getPreco() >= pesquisa.getPrecoMin() && imovel.getPreco() <= pesquisa.getPrecoMax()
                && Objects.equals(imovel.getDormitorio(), pesquisa.getDormitorio())
                && Objects.equals(imovel.getCidade(), pesquisa.getCidade())){
            return true;
        } else return false;
    }

    public static boolean retornaImovelCondicaoCidade(Imovel imovel, Pesquisa pesquisa){
        if(imovel.getPreco() >= pesquisa.getPrecoMin() && imovel.getPreco() <= pesquisa.getPrecoMax()
                && Objects.equals(imovel.getCidade(), pesquisa.getCidade())){
            return true;
        } else return false;
    }

    public static boolean retornaImovelCondicaoDormitorio(Imovel imovel, Pesquisa pesquisa){
        if(imovel.getPreco() >= pesquisa.getPrecoMin() && imovel.getPreco() <= pesquisa.getPrecoMax()
                && Objects.equals(imovel.getDormitorio(), pesquisa.getDormitorio())){
            return true;
        } else return false;
    }

    public static boolean retornaImovelCondicaoPreco(Imovel imovel, Pesquisa pesquisa){
        if(imovel.getPreco() >= pesquisa.getPrecoMin() && imovel.getPreco() <= pesquisa.getPrecoMax()){
            return true;
        } else return false;
    }

}
