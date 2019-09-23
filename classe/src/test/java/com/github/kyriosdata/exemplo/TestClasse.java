package com.github.kyriosdata.exemplo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClasse {

    @Test
    void verificaCloseChamado() {
        assertThrows(RuntimeException.class, () -> {
            try (ClasseCriada obj = new ClasseCriada(null)) {
            }
        });
    }

}
