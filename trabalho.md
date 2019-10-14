# Corrigindo código não identificado

O código de barras de uma fatura de energia é enviado para a concessionária para que a baixa correspondente possa ser efetuada.
O envio ocorre por meio de um arquivo TXT, no qual estão presentes códigos de barras de várias faturas, um por linha. 
Nem sempre, contudo, o código de barras é identificado pelo sistema, por estar fora do padrão. Isso acontece por erros de digitação, ou
falha no leitor de código de barras, ou ainda em decorrencia da qualidade da câmera empregada.

O padrão do código, no entanto, foi projetado de forma a admitir recuperação em alguns casos. Atualmente, o processo para recuperar um código de barras com problema é realizado manualmente. A proposta é automatizar este processo por meio de um programa, com benefício direto para o desempenho do processo como um todo. 

## Suposições a serem esclarecidas

- Há como automatizar o processo manual hoje empregado. 
  
  
  
Exemplos de códigos:  
A fatura de ID:83600000000268700090000000106228970800110000 não foi encontrada.  
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
- R2 O sistema deve separar o código em 4 blocos: valor da fatura; id da fatura; mês e ano da fatura; id da conta.
- R3 O software deve ser capaz de identificar quantos blocos tem uma sequência válida para o sistema
de acordo com o manual de código de barras da organização.
- R4 O software deve sugerir um conjunto de blocos que considerou como válido.
- R5 Para uma sugestão de código ser emitida, pelo menos dois blocos devem ter uma sequência de números considerada válida.


 Código exemplo:  
 8363000000 0 -> bloco 1   
 9944000900 1 -> bloco 2  
 3005001219 9 -> bloco 3  
 5000060011 0 -> bloco 4  
 Valor da fatura = 0000009954 (bloco 1 , 4 a 9) + (bloco 2, 0 a 4)  
 Id da fatura = 00300500 (bloco 2, 8 a 9) + (bloco 3, 0 a 6)  
 mês e ano da fatura = 1219 (bloco 3, 7 a 9)  
 id da conta = 5000060011 (bloco 4, 0 a 9)  
