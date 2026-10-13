# Builder - Montagem de Pedidos (Lanchonete)

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Builder** para montar pedidos de lanchonete (hambúrguer e pizza) com muitas configurações opcionais e regras de validação.

## Sobre o padrão

O **Builder** é um padrão de criação que separa a **construção** de um objeto complexo da sua **representação**, permitindo criar objetos passo a passo. Em vez de um construtor gigante com dezenas de parâmetros, o `PedidoBuilder` oferece métodos encadeados (fluent interface) e só cria o `Pedido` no método `build()` — que também centraliza as validações.

## Estrutura

```
builder/
├── builder.iml
└── src/
    ├── Main.java                # Ponto de entrada (monta os pedidos)
    ├── builder/
    │   └── PedidoBuilder.java   # Builder (fluent + validações)
    └── model/
        └── Pedido.java          # Produto final (imutável)
```

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd builder
javac -d out $(find src -name "*.java")
java -cp out Main
```

Ou abra o projeto no IntelliJ IDEA (arquivo `builder.iml`) e execute a classe `Main`.

### Saída esperada

```
Tipo: HAMBURGUER
Tamanho: M
Pagamento: PIX
Itens:
- X-Bacon
Pão: BRIOCHE
Entrega: Delivery
Endereço de entrega: Rua Exemplo, 123
Observações: Sem cebola
Tipo: PIZZA
Tamanho: G
Pagamento: CARTÃO
Itens:
- Pizza Calabresa
Massa: FINA
Borda Recheada: SIM
Entrega: Retirada
Cupom: 10OFF
Tipo: HAMBURGUER
Tamanho: P
Pagamento: DINHEIRO
Itens:
- X-Salada
Pão: TRADICIONAL
Entrega: Retirada
Troco para: R$ 100.0
Erro esperado: Troco só pode ser informado para pagamento em dinheiro.
```

## Regras de validação (em `build()`)

| Condição | Erro lançado |
| -------- | ------------ |
| Tipo diferente de `HAMBURGUER`/`PIZZA` | "Tipo inexistente" |
| Tamanho diferente de `P`/`M`/`G` | "Tamanho inválido" |
| Pagamento diferente de `PIX`/`CARTÃO`/`DINHEIRO` | "Escolha de pagamento inválida" |
| Nenhum item informado | "Não apresentou nenhum item." |
| Hambúrguer sem pão válido | "O Hambúrguer deve ter 1 tipo de pão." |
| Hambúrguer com massa ou borda | "Massa e borda recheada são somente para pizzas." |
| Pizza sem massa válida | "É necessário 1 tipo de massa." |
| Pizza com tipo de pão | "Tipo de pão é somente para hambúrguer." |
| Entrega diferente de `Delivery`/`Retirada` | "Tipo de entrega inválida." |
| Delivery sem endereço | "Delivery exige endereço de entrega" |
| Troco em pagamento diferente de dinheiro | "Troco só pode ser informado para pagamento em dinheiro." |
| Troco `<= 0` | "Troco deve ser maior que zero." |

## Conceitos

- **Builder**: `PedidoBuilder`
- **Product**: `Pedido`
- **Client**: `Main`

## Vantagens

- Evita construtores com muitos parâmetros.
- Construção passo a passo legível e encadeada.
- Centraliza todas as regras de validação em um único ponto (`build()`), garantindo que nenhum `Pedido` inválido seja criado.

## Desvantagem

- Exige criar uma classe extra (`PedidoBuilder`) e duplicar os campos do produto.
