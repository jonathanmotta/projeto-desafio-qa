#language: pt

Funcionalidade: Fluxo de Compra na Kabum
Como um usuário 
Gostaria de comprar 1 unidade do produto de minha escolha
Com a forma de pagamento cartão de crédito

Contexto: fazer login no sistema 
Dado que eu faça o login no sistema
E compre o produto de minha escolha

# 1º Fluxo de compra onde o cliente busca por um determinado produto no site (qualquer produto de sua escolha).
# A partir do resultado da busca, ele clica no produto desejado para acessar a página com detalhes do produto, então adiciona 
# esse produto em seu carrinho, prosseguindo com o fluxo de compra, optando como forma de pagamento cartão de crédito.
Cenário: 01 - Validar fluxo de compra selecionando 1 unidade do produto de minha escolha com a forma de pagamento cartão de crédito
Quando adicionar uma unidade do produto em minha cesta de compra
E finalizar a compra com cartão de crédito
Então devo ver o campo observações presente na tela antes de confirmar meu pedido

# 2º Mesmo fluxo de compra descrito no passo anterior, porém o cliente seleciona
# comprar 2 unidades do produto em questão na página com detalhes do produto.
Cenário: 02 - Validar fluxo de compra selecionando 2 unidades do produto de minha escolha com a forma de pagamento cartão de crédito
Quando adicionar duas unidades do produto em minha cesta de compra
E finalizar a compra com cartão de crédito
Então devo ver o campo observações presente na tela antes de confirmar meu pedido

# 3º Criar um caso de teste para remover um item do carrinho.
Cenário: 03 - Validar remoção de um item do carrinho de compras com sucesso
Quando adicionar uma unidade do produto em minha cesta de compra
E remover um item do carrinho
Então não deve haver produtos na cesta