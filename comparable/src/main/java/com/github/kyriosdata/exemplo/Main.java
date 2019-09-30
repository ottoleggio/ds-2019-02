package com.github.kyriosdata.exemplo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Pedro"));
        alunos.add(new Aluno("Amarildo"));
        
   //     int primeiraLetraComparado = Integer.parseInt(alunos.get(0).nome.substring(0, 0));
        System.out.println(alunos.get(1).compareTo(alunos.get(0)));
    }

}
