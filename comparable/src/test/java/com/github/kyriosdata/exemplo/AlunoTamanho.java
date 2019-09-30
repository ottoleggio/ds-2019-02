package com.github.kyriosdata.exemplo;

import java.util.Comparator;

public class AlunoTamanho implements Comparator<Aluno> {
    
    @Override
    public int compare(Aluno comparado, Aluno acomparar) {
        int primeiraLetraComparado = comparado.getNome().length();
        int primeiraLetraThis = acomparar.getNome().length();
        if(primeiraLetraComparado == primeiraLetraThis) {
            return 0;
        }
        else if (primeiraLetraComparado > primeiraLetraThis) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
}
