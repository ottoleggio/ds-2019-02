package com.github.kyriosdata.exemplo;

/**
 * Entendo que Tarifa não é um uso "recomendado", afinal, temos muitas
 * tarifas, e não apenas uma. De fato, seria desejável termos apenas uma
 * única instância de Tarifa para refletir o que ocorre no mundo real,
 * contudo, temos um cenário bem diferente deste.
 *
 * Adicionalmente, em vez de Tarifa, podemos ter a classe TabelaTarifas, na
 * qual o processo de criação de uma instância é oneroso e, não apenas por
 * este motivo, mas também pelo fato de que as atualizações seriam frequentes
 * ao longo de um dia e, neste caso, não faz sentido repetir o mesmo processo
 * onde teríamos várias instâncias de TabelaTarifas.
 *
 * Neste contexto, melhor seria termos uma única instância e todos saberiam
 * que, se houve uma atualização, então ela é compartilhada por todos.
 *
 * Finalmente, o exemplo mostra como implementar o Singleton, mas não o faz
 * com uma semântica adequada, diria que é um exemplo sintático apenas. 
 */
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
