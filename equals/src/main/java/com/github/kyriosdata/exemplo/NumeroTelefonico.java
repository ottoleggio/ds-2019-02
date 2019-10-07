package com.github.kyriosdata.exemplo;

public class NumeroTelefonico {
    String codPais;
    String codEstado;
    String numero;
    
    public NumeroTelefonico(String codPais, String codEstado, String numero) {
        // TODO linha abaixo desnecessária
        super();
        
        // TODO você poderia ter optado por (verifique os argumentos)
        // this.codPais = Objects.requireNonNull(codPais);
        this.codPais = codPais;
        this.codEstado = codEstado;
        this.numero = numero;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((codEstado == null) ? 0 : codEstado.hashCode());
        result = prime * result + ((codPais == null) ? 0 : codPais.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    public boolean equals(Object teste) {
        if (this == teste) {
            return true;
            }
        if (teste == null) {
            return false;
            }
        
        // FIXME Eu sugeri instanceof em vez de getClass() conforme abaixo.
        // Você sabe a diferença? Conforme está o Princípio de Substituição de Liskov é quebrado. 
        // Você deveria evitar essa implementação. Sugerida: 
        // if (teste instanceof NumeroTelefonico)
        if (getClass() != teste.getClass()) {
            return false;
            }
        NumeroTelefonico teste2 = (NumeroTelefonico) teste;
        
        // FIXME lógica "complexa" não?
        // Por que não...
        // return codEstado.equals(teste2.codEstado) && codPais.equals(teste2.codPais) && ...;
        
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
