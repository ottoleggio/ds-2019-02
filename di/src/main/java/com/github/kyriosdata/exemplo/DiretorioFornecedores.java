package com.github.kyriosdata.exemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DiretorioFornecedores {

    private List<Supplier<Leite>> listaFornecedores = new ArrayList<Supplier<Leite>>();

    public void adicionaFornecedor(Supplier<Leite> fornecedor) {
        listaFornecedores.add(fornecedor);
    }
    
    public List<String> fornecedores(){
        List<String> nomes = new ArrayList<String>();
        
        for(Supplier<Leite> fornecedor: listaFornecedores) {
            nomes.add(fornecedor.get().getFornecedor());
        }
        
        return nomes;
    }

}
