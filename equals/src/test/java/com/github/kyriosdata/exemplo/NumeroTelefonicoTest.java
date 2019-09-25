package com.github.kyriosdata.exemplo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class NumeroTelefonicoTest {

    @Test
    void test() {
        NumeroTelefonico teste1 = new NumeroTelefonico("Brasil", "55", "12345678");
        Set<NumeroTelefonico> setTeste = new HashSet<>();
        setTeste.add(teste1);
        NumeroTelefonico teste2 = new NumeroTelefonico("Brasil", "55", "12345678");
        assertTrue(setTeste.contains(teste2));
        assertTrue(setTeste.contains(teste1));
    }

}
