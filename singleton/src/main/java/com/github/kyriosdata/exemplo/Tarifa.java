package com.github.kyriosdata.exemplo;

public class Tarifa {
    private static double tarifa = 1.5;
    private static double tarifaBaixaRenda = 1.2;
    
    private Tarifa(double tarifa, double tarifaBaixaRenda) {
        tarifa = Tarifa.tarifa;
        tarifaBaixaRenda = Tarifa.tarifaBaixaRenda;
    }
    
    private static final Tarifa INSTANCIA = criaInstancia();

    private static Tarifa criaInstancia() {
            return new Tarifa(tarifa, tarifaBaixaRenda);
    }

    public static Tarifa getInstance() {
        return INSTANCIA;
    }

    public static double getTarifa() {
        return tarifa;
    }

    public static double getTarifaBaixaRenda() {
        return tarifaBaixaRenda;
    }
}
