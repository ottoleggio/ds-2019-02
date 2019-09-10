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
 * Serviço para implementação da avaliação de expressões matemáticas.
 */
public interface AvaliaExpressao {

    /**
     * Produz o valor {@code double} para a expressão fornecida.
     *
     * @param expressao A expressão a ser avaliada, por exemplo, "2 + 3".
     *                  Apenas expressões que produzem um valor numérico
     *                  são esperadas.
     *
     * @return O valor da avaliação da expressão.
     *
     * @throws IllegalArgumentException Se a expressão fornecida for inválida.
     * @throws IllegalArgumentException Se a expressão fornecida não resultar
     * em valor do tipo {@code double}.
     */
    double calcula(String expressao);

    /**
     * Produ o valor {@code double} para a avaliação da expressão fornecida
     * considerando os parâmetros fornecidos.
     *
     * @param expressao A expressão a ser avaliada, possivelmente contendo
     *                  variáveis, por exemplo, "2 * a".
     *
     * @param contexto Os valores das variáveis possivelmente empregadas
     *                 pela expressão. Por exemplo, para a expressão "2 * a"
     *                 é esperado que o presente parâmetro contenha a chave
     *                 "a", cujo valor ({@link Map#get(Object)} será empregado
     *                 na avaliação da expressão.
     *
     * @return O valor da avaliação da expressão considerando os valores
     * fornecidos para as variáveis empregadas.
     */
    double calcula(String expressao, Map<String, Double> contexto);

}
