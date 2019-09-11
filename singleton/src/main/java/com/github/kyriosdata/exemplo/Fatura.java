package com.github.kyriosdata.exemplo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fatura {

    private String idFatura;
    private String unidadeConsumidora;
    private double consumo;
    private List<String> encargos;
    private boolean baixaRenda;

    public static class Builder {
        private String idFatura = "";
        private String unidadeConsumidora = "";
        private double consumo = 0.0;
        private List<String> encargos = new ArrayList<>();
        private boolean baixaRenda = false;

        public Builder(final String identificador) {
            idFatura = identificador;
        }
        
        public Builder addUnidadeConsumidora(final String identificador) {
            unidadeConsumidora = identificador;
            return this;
        }
        
        public Builder addConsumo(final double valor) {
            consumo = valor;
            return this;
        }
            
        public Builder addEncargo(final String encargo) {
            encargos.add(encargo);
            return this;
        }
        
        public Builder baixaRenda(final boolean cadastro) {
            baixaRenda = cadastro;
            return this;
        }
        
        public Fatura build() {
            return new Fatura(this);
        }
    }
    
    private Fatura(Builder builder) {
        idFatura = builder.idFatura;
        unidadeConsumidora = builder.unidadeConsumidora;
        consumo = builder.consumo;
        encargos = Collections.unmodifiableList(builder.encargos);
        baixaRenda = builder.baixaRenda;
    }

    public String getIdFatura() {
        return idFatura;
    }

    public String getUnidadeConsumidora() {
        return unidadeConsumidora;
    }

    public double getConsumo() {
        return consumo;
    }

    public List<String> getEncargos() {
        return encargos;
    }

    public boolean isBaixaRenda() {
        return baixaRenda;
    }
    
    public double calculaValor() {
        if(baixaRenda) {
            return consumo * Tarifa.getTarifaBaixaRenda();
        }
        else {
            return consumo * Tarifa.getTarifa();
        }
    }

    public String toString() {
        return String.format("%s %s %s", idFatura, unidadeConsumidora, consumo);
    }
}
