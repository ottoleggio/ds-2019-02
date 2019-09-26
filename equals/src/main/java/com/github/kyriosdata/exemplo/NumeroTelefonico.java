package com.github.kyriosdata.exemplo;

public class NumeroTelefonico {
    String codPais;
    String codEstado;
    String numero;
    
    public NumeroTelefonico(String codPais, String codEstado, String numero) {
        super();
        this.codPais = codPais;
        this.codEstado = codEstado;
        this.numero = numero;
    }
    
    @Override
    public int hashCode() {
        // TODO nao é preciso "reinventar" a roda.
        return Objects.hashCode(codPais + codEstado + numero); 
    }

    public boolean equals(Object teste) {
        if (this == teste) {
            return true;
            }
        if (teste == null) {
            return false;
            }
        if (getClass() != teste.getClass()) {
            return false;
            }
        NumeroTelefonico teste2 = (NumeroTelefonico) teste;
        if (codEstado == null) {
            if (teste2.codEstado != null) {
                return false;
                }
        } else if (!codEstado.equals(teste2.codEstado)) {
            return false;
        }
        if (codPais == null) {
            if (teste2.codPais != null) {
                return false;
            }
        } else if (!codPais.equals(teste2.codPais)) {
            return false;
        }
        if (numero == null) {
            if (teste2.numero != null) {
                return false;
            }
        } else if (!numero.equals(teste2.numero)) {
            return false;
        }
        return true;
    }
    
    
}
