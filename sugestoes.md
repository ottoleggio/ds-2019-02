## Sugestões

- Classe CodigoDeBarras (String), retém todo o código. Qual o formato? Não interessa exceto para esta classe. Instância cb. 
Dentre suas responsabilidades está o conhecimento sobre o formato deste código de barras específico. Um dos métodos é 
getBlocos(codigoDeBarras) retorna List<Bloco>. getPreco retorna Bloco, getFatura retorna Bloco, ... 
- enum BlocoTipo { PRECO, FATURA, DATA, CONTA }.
- Bloco é uma classe cuja instância guarda um dos blocos do código de barra. Cada instância sabe qual o tipo correspondente.
Bloco tem como um dos parâmetros de um construtor o tipo. Bloco(BlocoTipo.PRECO, String), Bloco(BlocoTipo.FATURA, String), ...
- Cria-se pelo menos uma classe de verificação que implementa Predicate<Bloco> para cada um dos tipos de bloco. A regra que 
não pode ser tudo zero seria a classe TudoZero implements Predicate<Bloco>, a regra desejada é 
Predicate<Bloco> regraNaoPodeSerTudoZero = new Predicate() { boolean test(Bloco bloco) { return not(new TudoZero().test(bloco)); }

- Você talvez tenha que criar várias classes, empregando esta estratégia, depois terá que combiná-las para 
formar as regras. 

- Fase1(recebendo um codigo de barras), Você obtém um CodigoDeBarras do banco pela fatura. ExisteNoBanco(CodigoDeBarras) implements Predicate<Bloco>, na sequencia, quando te interrompi, você dizia "se retornar, ...." a regra é 
existe.test(b).
