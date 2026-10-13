# Command - Gerenciador de Tarefas com Undo e Fila

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Command** em um gerenciador de tarefas que suporta **desfazer** operações e **enfileirar** comandos para execução posterior.

## Sobre o padrão

O **Command** é um padrão comportamental que **encapsula uma requisição como um objeto**, permitindo parametrizar operações, enfileirá-las, registrá-las em histórico e desfazê-las.

Neste projeto cada operação (`adicionar`, `concluir`, `remover`) vira um objeto `Command` com os métodos `execute()` e `undo()`. O `PainelControle` é o *invoker*: mantém um **histórico** (pilha) para o undo e uma **fila** de comandos pendentes. O `GerenciadorTarefas` é o *receiver*, que de fato altera a lista de tarefas.

## Estrutura

```
Command/
├── Command.iml
└── src/
    ├── Main.java                       # Ponto de entrada
    ├── Command.java                    # Interface (execute/undo)
    ├── GerenciadorTarefas.java         # Receiver
    ├── PainelControle.java             # Invoker (histórico + fila)
    ├── AdicionarTarefaCommand.java     # ConcreteCommand
    ├── ConcluirTarefaCommand.java      # ConcreteCommand
    └── RemoverUltimaTarefaCommand.java # ConcreteCommand
```

### Diagrama simplificado

```
        ┌───────────────────────┐
        │   PainelControle      │  (Invoker)
        │   - historico: Stack  │
        │   - fila: Queue       │
        │   + executarComando() │
        │   + desfazerUltimo()  │
        │   + processarFila()   │
        └───────────┬───────────┘
                    │ executa
                    ▼
        ┌───────────────────────┐
        │   Command (interface) │
        │   + execute()         │
        │   + undo()            │
        └───────────▲───────────┘
                    │ implementa
     ┌──────────────┼───────────────────┐
     │              │                   │
┌───────────┐ ┌────────────┐ ┌────────────────────┐
│ Adicionar │ │  Concluir  │ │ RemoverUltimaTarefa│
└─────┬─────┘ └─────┬──────┘ └─────────┬──────────┘
      │             │                  │
      └─────────────┼──────────────────┘
                    ▼
        ┌───────────────────────┐
        │  GerenciadorTarefas   │  (Receiver)
        │  lista de tarefas     │
        └───────────────────────┘
```

## Comandos implementados

| Comando | `execute()` | `undo()` |
| ------- | ----------- | -------- |
| `AdicionarTarefaCommand` | Adiciona a tarefa | Remove a última tarefa |
| `ConcluirTarefaCommand` | Marca como `[Concluída]` | Volta para pendente |
| `RemoverUltimaTarefaCommand` | Remove a última tarefa | Restaura a tarefa removida |

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Command
javac -d out src/*.java
java -cp out Main
```

Ou abra o projeto no IntelliJ IDEA (arquivo `Command.iml`) e execute a classe `Main`.

### Saída esperada

```
Tarefa adicionada: Estudar Command
Tarefa adicionada: Implementar exercício
Tarefa concluída: Estudar Command

Desfazendo último comando...
Tarefa voltou para pendente: Estudar Command
Comando adicionado na fila.
Comando adicionado na fila.
Comando adicionado na fila.

Processando fila...
Tarefa adicionada: Revisar Big O
Tarefa adicionada: Estudar Chain of Responsibility
Tarefa concluída: Implementar exercício

Lista de tarefas:
- Estudar Command
- Implementar exercício [Concluída]
- Revisar Big O
- Estudar Chain of Responsibility
```

## Conceitos

- **Command**: `Command`
- **Concrete Command**: `AdicionarTarefaCommand`, `ConcluirTarefaCommand`, `RemoverUltimaTarefaCommand`
- **Invoker**: `PainelControle`
- **Receiver**: `GerenciadorTarefas`
- **Client**: `Main`

## Vantagens

- Desacopla quem pede a operação (`PainelControle`) de quem a executa (`GerenciadorTarefas`).
- Permite undo/redo, histórico e enfileiramento de operações.
- Novos comandos podem ser adicionados sem alterar o invoker.

## Desvantagem

- Cada operação exige uma classe nova, aumentando a quantidade de código.
