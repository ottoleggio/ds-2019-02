/**
 Copyright 2019 Fábrica de Software
 Instituto de Informática - Universidade Federal de Goiás

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.github.kyriosdata.exemplo.expressoes;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest {

    private AvaliaExpressao avaliador = new Calculadora();

    @Test
    void constante() {
        assertEquals(2, avaliador.calcula("2"));
    }

    @Test
    void casoTrivial() {
        assertEquals(5, avaliador.calcula("2 + 3"));
    }

    @Test
    void tipoLogicoInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
            avaliador.calcula("2 == 1"));
    }

    @Test
    void expressaoComVariavelCasoTrivial() {
        Map<String, Double> ctx = new HashMap<>();
        ctx.put("a", 3d);
        assertEquals(6, avaliador.calcula("2 * a", ctx));
    }
}


