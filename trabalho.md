# Corrigindo código não identificado

O código de barras de uma fatura de energia é enviado para a concessionária para que a baixa correspondente possa ser efetuada.
O envio ocorre por meio de um arquivo TXT, no qual estão presentes códigos de barras de várias faturas, um por linha. 
Nem sempre, contudo, o código de barras é identificado pelo sistema, por estar fora do padrão. Isso acontece por erros de digitação, ou
falha no leitor de código de barras, ou ainda em decorrencia da qualidade da câmera empregada.

O padrão do código, no entanto, foi projetado de forma a admitir recuperação em alguns casos. Atualmente, o processo para recuperar um código de barras com problema é realizado manualmente. A proposta é automatizar este processo por meio de um programa, com benefício direto para o desempenho do processo como um todo. 

## Suposições a serem esclarecidas

- Há como automatizar o processo manual hoje empregado. 
