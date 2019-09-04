package com.github.kyriosdata.exemplo.application.console;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

class FactoryTest {

    @Test
    void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Aluno aluno = Factory.newInstance("com.github.kyriosdata.exemplo.application.console.Aluno");
        Professor professor = Factory.newInstance("com.github.kyriosdata.exemplo.application.console.Professor");

        assertEquals("estudar", aluno.Atividade());
        assertEquals("educar", professor.Atividade());
    }

}
