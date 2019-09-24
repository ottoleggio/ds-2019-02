package com.github.kyriosdata.exemplo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClasse {

    @Test
    void verificaCloseChamado() {
        assertThrows(RuntimeException.class, () -> {
            // Parece que está funcionando, mas o null provoca exceção que não é aquela do seu método close!!!!!
            try (ClasseCriada obj = new ClasseCriada(null)) {
            }
        });
    }

}
