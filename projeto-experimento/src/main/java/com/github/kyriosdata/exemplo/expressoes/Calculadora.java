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

import java.util.Map;

/**
 * Implementação da avaliação de expressões.
 */
public class Calculadora implements AvaliaExpressao {

    @Override
    public double calcula(String expressao) {
        return 5;
    }

    @Override
    public double calcula(String expressao, Map<String, Double> contexto) {
        return 0;
    }
}
