======== LOJA ========

1 - Cadastrar produto
2 - Cadastrar cliente
3 - Listar produtos
4 - Listar clientes
5 - Criar venda
6 - Ver vendas
7 - Cancelar venda
0 - Sair

Regras

Produtos

possuem nome
possuem preço
possuem estoque
podem ter seu estoque alterado

Clientes

possuem nome
possuem algum identificador único que você deverá decidir

Venda

pertence a um cliente
possui produtos
cada produto comprado pode ter uma quantidade diferente
deve calcular o valor total
ao realizar uma venda, o estoque deve diminuir
não pode vender quantidade maior que o estoque
não pode vender produto inexistente
não pode vender para cliente inexistente

Cancelamento

uma venda cancelada deve devolver os produtos ao estoque
uma venda já cancelada não pode ser cancelada novamente