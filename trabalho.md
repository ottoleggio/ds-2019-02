# Corrigindo código não identificado

O código de barras de uma fatura de energia é enviado para a concessionária para que a baixa correspondente possa ser efetuada.
O envio ocorre por meio de um arquivo TXT, no qual estão presentes códigos de barras de várias faturas, um por linha. 
Nem sempre, contudo, o código de barras é identificado pelo sistema, por estar fora do padrão. Isso acontece por erros de digitação, ou
falha no leitor de código de barras, ou ainda em decorrencia da qualidade da câmera empregada.

O padrão do código, no entanto, foi projetado de forma a admitir recuperação em alguns casos. Atualmente, o processo para recuperar um código de barras com problema é realizado manualmente. A proposta é automatizar este processo por meio de um programa, com benefício direto para o desempenho do processo como um todo. 

## Suposições a serem esclarecidas

- Há como automatizar o processo manual hoje empregado. 
  
  
  
Exemplos de códigos:  
A fatura de ID:836 000000002687 0009 0000000 1062 28 970800110000 não foi encontrada.  
A fatura de ID:83620000001399500090000000103780000810100000 não foi encontrada.  
A fatura de ID:83650000000493400090013000001542120000600000 não foi encontrada.  
A fatura de ID:83660000000474000090013000001542110000100000 não foi encontrada.  
A fatura de ID:83650000001128600090000001600044607129000009 não foi encontrada.  
A fatura de ID:83670000000203300090013000001538590000700000 não foi encontrada.  
A fatura de ID:83600000000141900090001419000900020801000000 não foi encontrada.  
A fatura de ID:83610000001273000090013000001540340000700000 não foi encontrada.  
A fatura de ID:83690000002450600090013000001541360000900000 não foi encontrada.  
A fatura de ID:83680000001405100090013000001538610000400000 não foi encontrada.  
A fatura de ID:83670000001527900090000000105041050811000000 não foi encontrada.  
A fatura de ID:83600000000674200090000002100021408901600000 não foi encontrada.  
A fatura de ID:83610000001910300090013000001510530000400000 não foi encontrada.  
A fatura de ID:83680000005301300090013000001540980000700000 não foi encontrada.  
A fatura de ID:83660000000358600090013000001541640000100000 não foi encontrada.  
A fatura de ID:83670000000112700090013000001540740000100000 não foi encontrada.  
A fatura de ID:83600000000229000090000011400051871210000000 não foi encontrada.  
A fatura de ID:83650000000315300090013000001538350000100000 não foi encontrada.  
A fatura de ID:83620000002744400090013000001540670000100000 não foi encontrada.  
A fatura de ID:83640000000195200090013000001541550000100000 não foi encontrada.  
A fatura de ID:83630000000994400090013000001539950000600000 não foi encontrada.  


### Descrição dos requisitos do módulo:
- R1 Uma sequência 44 números deve ser recebida como sequência de caracteres.
- R2 O software deve separar o código em 4 blocos: valor da fatura; id da fatura; mês e ano da fatura; id da conta.
- R3 O software deve ser capaz de identificar quantos blocos tem uma sequência válida para o sistema
de acordo com o manual de código de barras da organização. 
- R4 São considerados id de fatura inválidos quando toda a sequência for de números 0, ou os dois primeiros dígitos não forem 0.  
- R5 São considerados id de conta inválidos quando toda a sequência for de números 0, ou os dois primeiros dígitos não forem 0.
- R6 O software deve identificar se o 'mês e ano da fatura' presente no código corresponde a uma data válida. 
- R7 O software deve sugerir um conjunto de, no mínimo, dois blocos que considerou como válido. Os blocos considerados válidos
serão retornados para que outro sistema consulte no banco de dados da organização se aquela sequência corresponde a uma fatura.
- R8 Caso nenhum ou apenas um bloco seja válido, o sistema deve retornar uma mensagem dizendo que a fatura não é identificável.

Manual do código de barras:  
 83630000000 -> bloco 1   
 99440009001 -> bloco 2  
 30050012190 -> bloco 3  
 00030600110 -> bloco 4  
 Valor da fatura = 0000009954 (bloco 1 , 4 a 10) + (bloco 2, 0 a 3)  
 Id da fatura = 001300500 (bloco 2, 8 a 10) + (bloco 3, 0 a 5)  
 mês e ano da fatura = 1219 (bloco 3, 6 a 9)  
 id da conta = 030600110 (bloco 4, 1 a 10)  
  **********  
  
  
  # Design
  ## Versão 1
 - Receber uma String contendo o código de barras
 - Separar os blocos importantes do código
 - Identificar quais blocos se enquadram como válidos
 - Retornar os blocos válidos, identificando-os  
 **********  
 
  ## Versão 2
  - A classe denominada **CodigoDeBarras** contém o atributo **codigo** que recebe uma String contendo o código de barras através de seu construtor.
  - A classe **CodigoDeBarras** contém um método **separaBlocos** que separa os blocos importantes do código, sendo caractere 3 ao 14 o 'valor da fatura', do 18 ao 27 o 'id da fatura', do 28 ao 32 o 'mês e ano da fatura' e do 34 ao 43 o 'id da conta'. O método retorna um dicionário com os quatro blocos separados.
  - O método **avaliaBlocos** recebe o dicionário da **separaBlocos** e avalia o 'idFatura', o 'mês e ano da fatura' e o 'idConta'.
    - O 'mês e ano da fatura' chama um outro método específico, **avaliaData** para validar se aquela data é uma data possível.
    - O 'idFatura' é verificado se contém dois zeros iniciais.
    - O 'idConta' é verificado se contém dois zeros iniciais.
  - O método **avaliaBlocos** retorna um boolean para cada bloco indicando se é valido ou não.
  **********  
   
  ## Versão 3
  - Um classe denominada **ProcessaCodigoDeBarras** será responsável por desmembrar um código de barras e retornar seus blocos conforme lhe for solicitada. Essa classe é independente do resto do código, encapsulando o processamento do código de barras.
      - A classe possui os métodos **getValorFatura**, **getIdFatura**, **getMesAnoFatura** e **getIdConta**. Cada método lê o código de barras enviado já na construção da classe e retorna o trecho que identifica cada bloco respectivamente.
  - A classe **ValidaBlocos** tem o método **validadorDeBlocos** que é responsável por avaliar se cada bloco é válido ou não conforme especificado nos requisitos. Apenas os blocos considerados como válidos são retornados como um dicionário.
      - Cada regra de validação de cada bloco é definida em métodos menores que serão utilizados pelo **validadorDeBlocos**. Desta forma as regras podem ser aperfeiçoadas sem alterar o comportamento do método avaliador.
  - A classe **faturaPossivel** é responsável por tentar definir qual fatura pode ser mais adequada aos blocos validados que ela receber.
      - Caso o dicionário contenha apenas um ou nenhum bloco válido, o construtor já retorna nulo pois não é possível identificar uma fatura.
      - Ao receber mais de um bloco válido, o método **buscaBanco** realiza uma consulta no banco de dados da organização os seguintes blocos:
        1. id da fatura: Cada consulta pode retornar uma fatura possível, o método retorna os blocos dessa fatura. 
        2. id da conta: Cada consulta retorna várias faturas de uma mesma conta.
      - O método **identificaPossivelFatura** chama o **buscaBanco** e compara a fatura retornada na consulta com a fatura avaliada. A fatura retornada deve coincidir exatamente em pelo menos dois dos quatro blocos para ser considerado como identificada com 100% de certeza.
      - Caso nenhum outro bloco coincida, o método chama o método **avaliaNumeros** que avalia a quantidade de números iguais na mesma posição entre os códigos e retorna os percentuais de igualdade de cada retorno da consulta. Caso o bloco consultado seja o número da conta, a fatura retornada será a que tiver o maior número de dígitos iguais.
      **********
        
  ## Casos de teste
  
  ### Teste 1, conta errada:  
  8361 000000002687 0009 009387492 1019 00 008011**1**322 : Código não identificado  
  8361 000000002687 0009 009387492 1019 00 008011**0**322 : Código correto  
  - O software deve identificar a fatura através do número da fatura, validando com o valor e o mês/ano.  
  - 100% de certeza  
   **********
     
  ### Teste 2, fatura errada:  
  8361 000000002687 0009 0093874**1**2 1019 00 0080110322 : Código não identificado  
  8361 000000002687 0009 0093874**9**2 1019 00 0080110322 : Código correto  
  - O software deve identificar a fatura através do número da conta, validando com o valor e o mês/ano.  
  - 100% de certeza 
     **********
     
  ### Teste 3, valor errado:  
  8361 0000000026**00** 0009 009387492 1019 00 0080110322 : Código não identificado  
  8361 0000000026**87** 0009 009387492 1019 00 0080110322 : Código correto  
  - O software deve identificar a fatura através do número da fatura, validando com a conta e o mês/ano.  
  - 100% de certeza 
     **********
     
  ### Teste 4, mês/ano errado:  
  8361 000000002687 0009 009387492 1**1**19 00 0080110322 : Código não identificado  
  8361 000000002687 0009 009387492 1**0**19 00 0080110322 : Código correto  
  - O software deve identificar a fatura através do número da fatura, validando com a conta e o valor. 
  - 100% de certeza 
     **********
     
  ### Teste 5, valor, mês/ano e conta errados:  
  8361 0000000026**00** 0009 009387492 10**56** 00 008011**1**322 : Código não identificado  
  8361 0000000026**87** 0009 009387492 10**19** 00 008011**0**322 : Código correto  
  - O software deve consultar a fatura através do número da fatura, como não há nenhum outro bloco igual, o retorno deve ser o percentual de números coincidentes. 
  - 88% de números coincidentes
       **********
     
  ### Teste 6, valor, mês/ano e conta errados:  
  8361 0000000026**00** 0009 009387492 **2356** 00 00**80111**32**1** : Código não identificado  
  8361 0000000026**87** 0009 009387492 **1019** 00 00**21420**32**2** : Código correto  
  - O software deve consultar a fatura através do número da fatura, como não há nenhum outro bloco igual, o retorno deve ser o percentual de números coincidentes. 
  - 73% de números coincidentes 
       **********
     
  ### Teste 7, valor, fatura e mês/ano errados:  
  8361 0000000026**00** 0009 009**123**492 **1056** 00 0021420322 : Código não identificado  
  8361 0000000026**87** 0009 009**387**492 **2319** 00 0021420322 : Código correto  
  - O software deve consultar a fatura através do número da conta, como não há nenhum outro bloco igual, o retorno deve ser o  de maior percentual de números coincidentes. 
  - 86% de números coincidentes 
