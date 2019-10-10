# Corrigindo código não identificado

O código de barras de uma fatura de energia é enviado para a concessionária para que a baixa correspondente possa ser efetuada.
O envio ocorre por meio de um arquivo TXT, no qual estão presentes códigos de barras de várias faturas, um por linha. 
Nem sempre, contudo, o código de barras é identificado pelo sistema, por estar fora do padrão. Isso acontece por erros de digitação, ou
falha no leitor de código de barras, ou leitores de câmeras de celular ruins.
O padrão do código no entanto foi pensado de uma forma a ser possível interpretar um código não identificado e se identificar a 
fatura. Entretanto esse processo é realizado manualmente.
Minha proposta é fazer o design do programa que recebe um código não identificado e tenta identificar possíveis códigos corretos,
para facilitar a baixa das faturas desses casos. Conheço bem o padrão dos códigos de barras e seria muito útil e interessante
para mim trabalhar nesse domínio.
