Avaliação de expressões matemáticas só conhecidas em tempo de execução. Descrição: uma expressão como “x + 2 * (y - 3)” é conhecida ou recebida pelo software como uma sequência de caracteres (String), apenas em tempo de execução, assim como os valores correspondentes às variáveis, neste caso, “x” e “y”, e o software (componente) deve produzir o resultado correspondente. Há muitas bibliotecas que podem ser empregadas para tal finalidade. A identificação delas e a seleção de uma, a ser empregada pelo componente a ser projetado, faz parte deste trabalho

### Descrição dos requisitos do módulo:
- R1 Uma expressão matemática, por exemplo, "x + y" deve ser recebida como uma sequência de caracteres e ter sua avaliação realizada conforme os valores das variáveis empregadas pela expressão.
- R2 Se algum valor não é fornecido, então não há como avaliar a expressão. Por exemplo, se para "x + y" não é conhecido o valor de qualquer uma das variáveis, seja "x" ou "y", então não é possível avaliar a expressão.
- R3 O software deve tratar casos em que o valor das variáveis não for informado.

### Casos de teste:  
x + 2 * (y - 3)  
onde x = -2; y = 3  
resultado = 0  
  
a + b * c / d  
onde a = 1; b = 2; c = 3; d = 4  
resultado = 2.5  

(a + 2) / j  
onde a = 2; j = 10;  
resultado = 0.4  

10 + a * a  
onde a = 2  
resultado = 14  

x * x - x  
onde x = 10  
resultado = 90  

0 * 10  
resultado = 0  

0 + 0  
resultado = 0  

x + 2 * (x - 3)  
onde x = -2; x = 3  
resultado = -5 

x + x  
onde x = 5; x = 10  
resultado = 10 

x + x  
onde x = 5; x = 10  
(teste para variável duplicada)  
resultado = 20  

x + y + x  
onde x = 5; y = 6; x = 10  
(teste para variável duplicada)  
resultado = 26  

### Design
- A biblioteca [EvalEx](https://github.com/uklimaschewski/EvalEx) pode ser utilizada para calcular as expressões matemáticas.

- 'AvaliadorExpressao' é a interface responsável pelo método que avalia a expressão.
- 'Avalia' é um método da interface 'AvaliadorExpressao' que recebe uma String 'exp' contendo a expressão a ser calculada
e um dicionário String e BigDecimal nominado 'valores', sendo a String da variável e o seu valor correspondente respectivamente. Utilizar um dicionário para receber os valores das variáveis evita que diferentes valores sejam atribuidos para uma mesma variável.
  - a função Expression() da biblioteca EvalEx calcula a expressão (por exemplo Expression(a+b)). Para atribuir variáveis
  extende-se a função with() (por exemplo Expression(a+b).with("a", "1").("b", "2"), obtendo 1+2=3).
  - a função eval() calcula a expressão e retorna o resultado.
  - a função itera adicionando os valores das variáveis, usando getUsedVariables().size() para determinar o tamanho do laço.
- Uma excessão 'Valor de variável inválido' deve ser gerado caso um valor não numérico ou nulo seja passado no parâmetro 'valores'
