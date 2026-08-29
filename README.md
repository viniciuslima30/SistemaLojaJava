# 🛒 Sistema de Loja

Sistema de gerenciamento de uma loja desenvolvido em **Java**, com foco em **Programação Orientada a Objetos (POO)**, manipulação de coleções e aplicação de regras de negócio.

O projeto simula um sistema de vendas executado pelo terminal, permitindo cadastrar produtos e clientes, realizar vendas, consultar vendas e cancelar compras.

## 📌 Funcionalidades

* 📦 Cadastro de produtos
* 👤 Cadastro de clientes
* 📋 Listagem de produtos
* 👥 Listagem de clientes
* 🛍️ Criação de vendas
* 🧾 Consulta de vendas realizadas
* ❌ Cancelamento de vendas
* 🔄 Reposição automática do estoque após cancelamento
* 🆔 Geração de identificadores únicos para clientes e vendas com `UUID`
* ✅ Validação de entradas do usuário

## 🧱 Estrutura do Projeto

O sistema é dividido em classes que representam diferentes responsabilidades:

```text
SistemaLoja/
├── Main.java
├── Loja.java
├── Produto.java
├── Cliente.java
├── Venda.java
└── Item.java
```

### `Produto`

Representa um produto disponível na loja.

Responsável por:

* Nome
* Preço
* Estoque
* Retirada de estoque
* Aumento de estoque

### `Cliente`

Representa um cliente cadastrado.

Possui:

* Nome
* ID único (`UUID`)

### `Item`

Representa um item pertencente a uma venda.

Possui:

* Nome do produto
* Preço
* Quantidade

### `Venda`

Representa uma venda realizada.

Possui:

* Cliente comprador
* Lista de itens
* ID único (`UUID`)

### `Loja`

É responsável pelo gerenciamento do sistema.

Controla:

* Lista de produtos
* Lista de clientes
* Lista de vendas
* Cadastro
* Busca de objetos
* Criação de vendas
* Cancelamento de vendas
* Atualização do estoque

### `Main`

Responsável pela interação com o usuário através do terminal.

Contém:

* Menu principal
* Entrada de dados
* Validação das entradas
* Chamadas aos métodos da `Loja`

## 🧠 Conceitos praticados

Este projeto foi desenvolvido com foco em fundamentos importantes de Java e POO:

* Classes e objetos
* Encapsulamento
* Atributos privados
* Getters
* Construtores
* Métodos
* Referências de objetos
* `ArrayList`
* `UUID`
* `for-each`
* Validação de dados
* `try/catch`
* `NumberFormatException`
* `equalsIgnoreCase()`
* Separação de responsabilidades
* Relacionamento entre objetos
* Regras de negócio

## 🔄 Exemplo de fluxo de uma venda

```text
Cliente
   ↓
Loja procura o cliente
   ↓
Loja procura o produto
   ↓
Verifica o estoque
   ↓
Retira a quantidade do estoque
   ↓
Cria Item
   ↓
Cria Venda
   ↓
Adiciona a venda à lista
```

Ao cancelar:

```text
ID da venda
   ↓
Localiza a venda
   ↓
Recupera os itens
   ↓
Devolve a quantidade ao estoque
   ↓
Remove a venda da lista
```

## 🆔 Identificação das vendas

Cada venda recebe um `UUID` próprio.

Isso permite cancelar uma venda específica através do seu identificador, evitando depender do nome do cliente.

Exemplo:

```text
ID da compra:
550e8400-e29b-41d4-a716-446655440000
```

## ▶️ Como executar

Tenha o **Java JDK** instalado.

Clone o projeto:

```bash
git clone <URL_DO_REPOSITORIO>
```

Entre na pasta:

```bash
cd SistemaLoja
```

Compile e execute o projeto através da sua IDE ou utilizando o terminal com o Java.

## 🚀 Próximos passos

Possíveis evoluções para o projeto:

* [ ] Adicionar testes unitários com JUnit
* [ ] Melhorar a validação das entradas
* [ ] Refatorar métodos repetidos da `Main`
* [ ] Permitir múltiplos itens em uma única venda
* [ ] Adicionar cálculo do valor total da venda
* [ ] Melhorar o tratamento de exceções
* [ ] Utilizar `Map` para otimizar buscas
* [ ] Persistir os dados em banco de dados
* [ ] Transformar o sistema em uma API REST com Spring Boot

## 👨‍💻 Objetivo

Projeto desenvolvido para praticar **Java e Programação Orientada a Objetos**, simulando regras de negócio presentes em um sistema de vendas real.

O projeto também serve como base para evoluções futuras envolvendo **testes automatizados, banco de dados, APIs REST e Spring Boot**.
