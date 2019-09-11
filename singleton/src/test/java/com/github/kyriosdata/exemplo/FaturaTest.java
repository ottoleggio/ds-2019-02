package com.github.kyriosdata.exemplo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FaturaTest {

    @Test
    void builderCasoTrivial() {
        Fatura.Builder builder = new Fatura.Builder("2019821721")
                .addConsumo(13.5);
        assertEquals("idFatura=2019821721, unidadeConsumidora=, consumo=13.5, encargos=[]"
                , builder.build().toString());
    }
    
    @Test
    void verificaBuilder() {
        Fatura.Builder builder = new Fatura.Builder("2019832832")
                .addConsumo(20.33)
                .addEncargo("multa revelia")
                .addUnidadeConsumidora("727381X");
        assertEquals("idFatura=2019832832, unidadeConsumidora=727381X, consumo=20.33, encargos=[multa revelia]"
                , builder.build().toString());
    }
    
    @Test
    void encargosImmutable() {
        Fatura.Builder builder = new Fatura.Builder("Davi");
        Fatura nome = builder.build();

        // Não há como adicionar
        assertThrows(UnsupportedOperationException.class, () ->
                nome.getEncargos().add("teste"));

        // Não há como remover
        assertThrows(UnsupportedOperationException.class, () ->
                nome.getEncargos().remove(0));
}
}

