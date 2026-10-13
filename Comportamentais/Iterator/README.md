# Iterator - Fila de Atendimento

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Iterator** para percorrer uma fila de senhas de atendimento **sem expor** a estrutura interna de armazenamento.

## Sobre o padrão

O **Iterator** é um padrão comportamental que fornece uma forma de **acessar sequencialmente** os elementos de uma coleção sem revelar sua representação interna (lista, vetor, árvore...).

Neste projeto:

- `FilaAtendimento` é a **coleção** — internamente usa uma `List<SenhaAtendimento>`
- `IteratorSenha` é a **interface de iteração** (`temProximo()` / `proxima()`)
- `FilaAtendimentoIterator` é o **iterador concreto**, que guarda a posição atual
- A `Main` percorre a fila usando apenas o iterador, controlando o avanço pelo teclado (ENTER)

## Estrutura

```
Iterator/
└── src/
    ├── Main.java                     # Ponto de entrada (percorre a fila)
    ├── SenhaAtendimento.java         # Elemento da coleção
    ├── FilaAtendimento.java          # Aggregate (cria o iterator)
    ├── IteratorSenha.java            # Iterator (interface)
    └── FilaAtendimentoIterator.java  # Concrete Iterator
```

### Diagrama simplificado

```
        ┌──────────────────────────┐        ┌──────────────────────────┐
        │    FilaAtendimento       │        │   IteratorSenha          │
        │  - senhas_fila: List     │        │   + temProximo()         │
        │  + adicionarNaFila()     │───────►│   + proxima()            │
        │  + criarIterator()       │  cria  └───────────▲──────────────┘
        └──────────────────────────┘                     │ implementa
                                             ┌───────────┴──────────────┐
                                             │ FilaAtendimentoIterator  │
                                             │ - posicao: int           │
                                             └──────────────────────────┘
```

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Iterator
javac -d out src/*.java
java -cp out Main
```

> O programa pede que você pressione **ENTER** para mostrar cada próxima pessoa da fila.

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

```
Pressione ENTER para mostrar a próxima pessoa da fila.
Maria - A001
Pressione ENTER para mostrar a próxima pessoa da fila.
João - A002
Pressione ENTER para mostrar a próxima pessoa da fila.
Carlos - A003
Pressione ENTER para mostrar a próxima pessoa da fila.
Ana - A004
Pressione ENTER para mostrar a próxima pessoa da fila.
Pedro - A005
```

## Conceitos

- **Iterator**: `IteratorSenha`
- **Concrete Iterator**: `FilaAtendimentoIterator`
- **Aggregate**: `FilaAtendimento`
- **Client**: `Main`

## Vantagens

- Percorre a coleção sem expor sua estrutura interna.
- Permite múltiplos iteradores independentes sobre a mesma coleção.
- A coleção pode mudar de implementação sem afetar quem a percorre.

## Desvantagem

- Adiciona classes extras que, para coleções simples, podem ser uma complexidade desnecessária.
