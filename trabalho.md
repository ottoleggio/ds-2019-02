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
A fatura de ID:83680000000262100090013000001541990000400000 não foi encontrada.  
A fatura de ID:83610000004926700090013000001542390000500000 não foi encontrada.  
A fatura de ID:83650000001575000090013000001541200000800000 não foi encontrada.  
A fatura de ID:83680000000241800090013000001541660000000000 não foi encontrada.  
A fatura de ID:83690000000231800090013000001541740000400000 não foi encontrada.  
A fatura de ID:83690000000402200090013000001530970000100000 não foi encontrada.  
A fatura de ID:83600000000332300090013000001540020000700000 não foi encontrada.  
A fatura de ID:83640000002715200090013000001538120000100000 não foi encontrada.  
A fatura de ID:83620000000320600090013000001538630000300000 não foi encontrada.  
A fatura de ID:83610000002163600090013000001535870000100000 não foi encontrada.  
A fatura de ID:83650000000565200090013000001518330000900000 não foi encontrada.  
A fatura de ID:83680000000703200090013000001540400000200000 não foi encontrada.  
A fatura de ID:83660000000568500090013000001539300000100000 não foi encontrada.  
A fatura de ID:83630000007290300090013000001541230000100000 não foi encontrada.  
A fatura de ID:83680000000809500090013000001542140000500000 não foi encontrada.  
A fatura de ID:83680000000177300090013000001542160000400000 não foi encontrada.  
A fatura de ID:83620000000274900090013000001519130000400000 não foi encontrada.  
A fatura de ID:83650000001777700090013000001542030000700000 não foi encontrada.  
A fatura de ID:83650000000916700090013000001533790000100000 não foi encontrada.  
A fatura de ID:83640000001744800090013000001542200000100000 não foi encontrada.  
A fatura de ID:83640000000487700090000004700001850811000000 não foi encontrada.  
A fatura de ID:83640000000346700090013000001535330000400000 não foi encontrada.  
A fatura de ID:83630000000486200090013000001533360000200000 não foi encontrada.   
A fatura de ID:83640000001073100090013000001518260000900000 não foi encontrada.  
A fatura de ID:83690000004004300090013000001537390000700000 não foi encontrada.  
A fatura de ID:83600000000129200090000012600000720712100000 não foi encontrada.  
A fatura de ID:83650000001926400090013000001537360000300000 não foi encontrada.  
A fatura de ID:83600000003483800090000012600000070712900000 não foi encontrada.  
A fatura de ID:83640000002615400090013000001534120000000000 não foi encontrada.  

