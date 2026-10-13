# Composite - Itens de Loja (Produtos e Kits)

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Composite** em uma loja que vende produtos avulsos e **kits** que podem conter produtos **e outros kits** (composição recursiva).

## Sobre o padrão

O **Composite** é um padrão estrutural que permite compor objetos em **estruturas de árvore** e tratar itens individuais (folhas) e composições (galhos) de forma **uniforme**, através de uma interface comum.

Neste projeto:

- `ItemLoja` é o **componente** (interface comum)
- `Produto` é a **folha** (*leaf*)
- `Kit` é o **composite** — contém uma lista de `ItemLoja` e pode, inclusive, conter outros kits

O preço de um `Kit` é calculado recursivamente somando o preço dos seus itens.

## Estrutura

```
Composite/
└── src/
    ├── Main.java          # Ponto de entrada
    ├── ItemLoja.java      # Component
    ├── Produto.java       # Leaf
    └── Kit.java           # Composite
```

### Diagrama simplificado

```
            ┌───────────────────────────┐
            │   ItemLoja (interface)    │
            │   + getNome()             │
            │   + getPreco()            │
            │   + exibir(prefixo)       │
            └─────────────▲─────────────┘
                          │ implementa
             ┌────────────┴────────────┐
             │                         │
     ┌───────────────┐        ┌────────────────────┐
     │   Produto     │        │        Kit         │
     │  (leaf)       │        │  (composite)       │
     │  nome, preco  │        │  List<ItemLoja>    │
     └───────────────┘        │  + adicionar()     │
                              │  + remover()       │
                              └─────────┬──────────┘
                                        │ contém
                          ┌─────────────┼──────────────┐
                          ▼             ▼              ▼
                      Produto        Produto        Kit...
```

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Composite
javac -d out src/*.java
java -cp out Main
```

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

```
+ Kit: Kit Setup | Total: R$ 1170.0
  - Produto: Monitor | Preço: R$ 900.0
  + Kit: Kit Periféricos | Total: R$ 270.0
    - Produto: Mouse | Preço: R$ 80.0
    - Produto: Teclado | Preço: R$ 150.0
    - Produto: Mousepad | Preço: R$ 40.0
```

### Árvore montada no exemplo

```
Kit Setup (R$ 1170.0)
├── Monitor (R$ 900.0)
└── Kit Periféricos (R$ 270.0)
    ├── Mouse (R$ 80.0)
    ├── Teclado (R$ 150.0)
    └── Mousepad (R$ 40.0)
```

## Conceitos

- **Component**: `ItemLoja`
- **Leaf**: `Produto`
- **Composite**: `Kit`
- **Client**: `Main`

## Vantagens

- Trata produtos e kits de forma uniforme, sem verificações de tipo.
- Facilita acrescentar novos tipos de item.
- A recursão simplifica operações sobre estruturas complexas (somar preço, exibir).

## Desvantagem

- A interface acaba ficando genérica demais, o que pode tornar o design excessivamente abstrato.
