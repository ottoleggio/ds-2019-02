# Corrigindo código não identificado

O código de barras de uma fatura de energia é enviado para a concessionária para que a baixa correspondente possa ser efetuada. O envio ocorre por meio de um arquivo TXT, no qual estão presentes códigos de barras de várias faturas. Neste
arquivo é fornecido uma fatura por linha. Nem sempre, contudo, o código de barras é identificado (reconhecido) pelo sistema, por estar fora do padrão. Em geral, isso acontece por erros de digitação, ou falha no leitor de código de barras, ou ainda em decorrencia da qualidade da câmera empregada para coletar o código.

O padrão do código permite, no entanto, a identificação do código, em alguns casos, mesmo quando o padrão não é seguido. 
Atualmente, o processo para identificar o código de barras a partir de um código de barras com problema é realizado manualmente. A proposta é automatizar este processo por meio de um programa, com benefício direto para o desempenho do processo como um todo. 

Exemplos de códigos seguem abaixo:

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


## Suposições a serem esclarecidas

- Há como automatizar o processo manual hoje empregado. 
 

### Descrição dos requisitos do módulo:
- R1 Uma sequência de 44 números deve ser recebida como sequência de caracteres.
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
  
  
  # Design (classes principais e suas responsabilidades)  

  - **CodigoDeBarras**. Responsável por representar um código de barras. Encapsula a estrutura de dados necessária e fornece os componentes do código de barras sob demanda.
      - A classe possui os métodos **getValorFatura**, **getIdFatura**, **getMesAnoFatura** e **getIdConta**. Cada método 
      retorna este componente do código de barras em questão. O retorno é uma instância de **Bloco**. 
  - **BlocoTipo** é responsável por representar um tipo de bloco. As opções são: PRECO, FATURA, DATA, CONTA.
  - **Bloco** é uma classe cuja instância guarda um dos blocos do código de barra. Cada instância sabe qual é seu tipo correspondente, que é um dos parâmetros de seu construtor.
  - Regras executadas, no momento, manualmente, serão encapsuladas em _predicados_ (classes que implementam **Predicate**). De fato, cada regra deverá ser uma composição de predicados "menores", que possivelmente serão reutilizados entre várias regras. Por exemplo, ...
  - Classes de verificação dos blocos implementando **Predicate** definem regras para verificar se cada bloco é consistente para se levar a busca adiante. A combinação dessas classes formam as regras gerais específicas de cada bloco.
  - Além da verificação dos blocos, existem outras classes implementando **Predicate** quem avaliam a existência desses blocos no banco de dados da organização, e outras ainda comparando os resultados da query com os blocos do código avaliado.
  - O resultado do processamento é uma fatura correspondente identificada, ou uma sugestão de fatura correspondente com a quantidade de dígitos correspondentes, caso não tenha sido possível encontrar a 100% correta.
      **********
      
  A função abaixo recebe um bloco de código de barras e seu respectivo predicate, caso o teste do predicate esteja correto uma busca no banco de dados e realizada.
  ````
  public CodigoDeBarras buscaBancoDeDados(Bloco bloco, Predicate predicate) {  
    if (predicate.test(codigoDeBarras)){  
       return buscaNoBanco(codigoDeBarras);  
    }
  }
  ````        
  ## Exemplos de casos de teste  
  
  ### Teste 1, conta errada:
  Predicates do bloco valor: valor.and(menorQueMil).and(diferenteDeZero) ---------------->  **true**  
  Predicates do bloco fatura: idFatura.and(doisZerosInicio).and(diferenteDeZero) --------> **true**  
  Predicates do bloco data: data.and(dataReal).and(antesDeHoje) -------------------------> **true**  
  Predicates do bloco conta: conta.and(doisZerosInicio).and(diferenteDeZero) ------------> **true**  
  
  8361 000000002687 0009 009387492 1019 00 008011**1**322 : Código não identificado  
  8361 000000002687 0009 009387492 1019 00 008011**0**322 : Código correto  
  - O software deve identificar a fatura através do número da fatura, validando com o valor e o mês/ano.  
  - 100% de certeza  
   **********
   
  ### Teste 2, conta errada:
  Predicates do bloco valor: valor.and(menorQueMil).and(diferenteDeZero) ----------------> **true**  
  Predicates do bloco fatura: idFatura.and(doisZerosInicio).and(diferenteDeZero) --------> **true**  
  Predicates do bloco data: data.and(dataReal).and(antesDeHoje) -------------------------> **true**  
  Predicates do bloco conta: conta.and(**doisZerosInicio**).and(diferenteDeZero) --------> **false**  
  
  8361 000000002687 0009 009387492 1019 00 **1**080113222 : Código não identificado  
  8361 000000002687 0009 009387492 1019 00 **0**080113222 : Código correto  
  - O software deve identificar a fatura através do número da fatura, validando com o valor e o mês/ano.  
  - 100% de certeza  
   **********
     
  ### Teste 3, fatura errada:  
  Predicates do bloco valor: valor.and(menorQueMil).and(diferenteDeZero) ----------------> **true**  
  Predicates do bloco fatura: idFatura.and(doisZerosInicio).and(**diferenteDeZero**) ----> **false**  
  Predicates do bloco data: data.and(dataReal).and(antesDeHoje) -------------------------> **true**  
  Predicates do bloco conta: conta.and(doisZerosInicio).and(diferenteDeZero) ------------> **true**  
  
  8361 000000002687 0009 00**0000000** 1019 00 0080110322 : Código não identificado  
  8361 000000002687 0009 00**9387492** 1019 00 0080110322 : Código correto  
  - O software deve identificar a fatura através do número da conta, validando com o valor e o mês/ano.  
  - 100% de certeza 
     **********
     
  ### Teste 4, valor errado:  
  Predicates do bloco valor: valor.and(**menorQueMil**).and(diferenteDeZero) ------------> **false**  
  Predicates do bloco fatura: idFatura.and(doisZerosInicio).and(diferenteDeZero) --------> **true**  
  Predicates do bloco data: data.and(dataReal).and(antesDeHoje) -------------------------> **true**  
  Predicates do bloco conta: conta.and(doisZerosInicio).and(diferenteDeZero) ------------> **true**  
  
  8361 000000**5**026**00** 0009 009387492 1019 00 0080110322 : Código não identificado  
  8361 000000**0**026**87** 0009 009387492 1019 00 0080110322 : Código correto  
  - O software deve identificar a fatura através do número da fatura, validando com a conta e o mês/ano.  
  - 100% de certeza 
     **********
     
  ### Teste 5, mês/ano errado:   
  Predicates do bloco valor: valor.and(menorQueMil).and(diferenteDeZero) ----------------> **true**  
  Predicates do bloco fatura: idFatura.and(doisZerosInicio).and(diferenteDeZero) --------> **true**  
  Predicates do bloco data: data.and(**dataReal**).and(antesDeHoje) ---------------------> **false**  
  Predicates do bloco conta: conta.and(doisZerosInicio).and(diferenteDeZero) ------------> **true**  
  
  8361 000000002687 0009 009387492 1**4**19 00 0080110322 : Código não identificado  
  8361 000000002687 0009 009387492 1**0**19 00 0080110322 : Código correto  
  - O software deve identificar a fatura através do número da fatura, validando com a conta e o valor. 
  - 100% de certeza 
     **********
     
  ### Teste 6, valor, mês/ano e conta errados: 
  Predicates do bloco valor: valor.and(menorQueMil).and(**diferenteDeZero**) ------------> **false**  
  Predicates do bloco fatura: idFatura.and(doisZerosInicio).and(diferenteDeZero) --------> **true**  
  Predicates do bloco data: data.and(**dataReal**).and(antesDeHoje) ---------------------> **false**  
  Predicates do bloco conta: conta.and(doisZerosInicio).and(diferenteDeZero) ------------> **true** 
  
  8361 00000000**0000** 0009 009387492 10**56** 00 008011**1**322 : Código não identificado  
  8361 00000000**2687** 0009 009387492 10**19** 00 008011**0**322 : Código correto  
  - O software deve consultar a fatura através do número da fatura, como não há nenhum outro bloco igual, o retorno deve ser o percentual de números coincidentes. 
  - 88% de números coincidentes
       **********
     
  ### Teste 7, valor, mês/ano e conta errados:  
  Predicates do bloco valor: valor.and(menorQueMil).and(diferenteDeZero) ---------------> **true**  
  Predicates do bloco fatura: idFatura.and(doisZerosInicio).and(diferenteDeZero) -------> **true**  
  Predicates do bloco data: data.and(**dataReal**).and(antesDeHoje) --------------------> **false**  
  Predicates do bloco conta: conta.and(doisZerosInicio).and(diferenteDeZero) -----------> **true** 
  
  8361 0000000026**00** 0009 009387492 **2356** 00 00**80111**32**1** : Código não identificado  
  8361 0000000026**87** 0009 009387492 **1019** 00 00**21420**32**2** : Código correto  
  - O software deve consultar a fatura através do número da fatura, como não há nenhum outro bloco igual, o retorno deve ser o percentual de números coincidentes. 
  - 73% de números coincidentes 
       **********
     
  ### Teste 8, valor, fatura e mês/ano errados:    
  Predicates do bloco valor: valor.and(menorQueMil).and(diferenteDeZero) ---------------> **true**  
  Predicates do bloco fatura: idFatura.and(**doisZerosInicio**).and(diferenteDeZero) ---> **false**  
  Predicates do bloco data: data.and(**dataReal**).and(antesDeHoje) --------------------> **false**  
  Predicates do bloco conta: conta.and(doisZerosInicio).and(diferenteDeZero) -----------> **true** 
  
  8361 0000000026**00** 0009 **1**09**123**492 **1056** 00 0021420322 : Código não identificado  
  8361 0000000026**87** 0009 **0**09**387**492 **2319** 00 0021420322 : Código correto  
  - O software deve consultar a fatura através do número da conta, como não há nenhum outro bloco igual, o retorno deve ser o  de maior percentual de números coincidentes. 
  - 86% de números coincidentes 
         **********
     
  ### Teste 9, todos os blocos errados:    
  Predicates do bloco valor: valor.and(menorQueMil).and(diferenteDeZero) ---------------> **false**  
  Predicates do bloco fatura: idFatura.and(doisZerosInicio).and(diferenteDeZero) -------> **false**  
  Predicates do bloco data: data.and(**dataReal**).and(antesDeHoje) --------------------> **false**  
  Predicates do bloco conta: conta.and(doisZerosInicio).and(**diferenteDeZero**) -------> **false** 
  
  8361 000**2**000026**00** 0009 **11**9**123**492 **1056** 00 **1121430322** : Código não identificado  
  8361 000**0**000026**87** 0009 **00**9**387**492 **2319** 00 **0000000000** : Código correto  
  - Não há como consultar uma fatura correspondente.
