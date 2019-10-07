package com.github.kyriosdata.exemplo;

import java.util.Comparator;

// FIXME esta classe faz parte do negócio, do domínio, não é de teste e, portanto, o melhor lugar para ela é lá do lado do Aluno. Talvez
// até em outro package, mas aí teríamos que ter um contexto maior. 
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
