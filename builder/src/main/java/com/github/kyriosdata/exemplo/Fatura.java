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

        /**
         * Ter um primeiro nome é obrigatório.
         *
         * @param nome O primeiro nome do nome.
         */
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

    public String toString() {
        // Deve fazer parte os atributos relevantes. Quais seriam?
        return String.format("%s %s %s", idFatura, unidadeConsumidora, consumo);
    }
}
