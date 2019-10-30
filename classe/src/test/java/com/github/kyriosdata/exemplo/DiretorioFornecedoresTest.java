package com.github.kyriosdata.exemplo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiretorioFornecedoresTest {

    @Test
    void test() {
        DiretorioFornecedores teste = new DiretorioFornecedores();
        teste.adicionaFornecedor(new CaldasNovas());
        assertEquals(1, teste.fornecedores().size());
    }

}
