# Memento - Versionamento de Documento

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Memento** para salvar e **restaurar versões** de um documento, permitindo desfazer alterações sem expor sua estrutura interna.

## Sobre o padrão

O **Memento** é um padrão comportamental que permite **capturar e externalizar o estado interno** de um objeto, de modo que ele possa ser **restaurado** posteriormente, **sem violar o encapsulamento**.

Neste projeto:

- `Documento` é o **Originator** — cria e restaura snapshots do seu estado via `salvar()` e `restaurar()`
- `MementoDocumento` é o **Memento** — guarda o estado (título, conteúdo, autor, data)
- `HistoricoDocumento` é o **Caretaker** — armazena a lista de mementos, mas nunca inspeciona seu conteúdo

## Estrutura

```
Memento/
└── src/
    ├── Main.java               # Ponto de entrada
    ├── Documento.java          # Originator
    ├── MementoDocumento.java   # Memento
    └── HistoricoDocumento.java # Caretaker
```

### Diagrama simplificado

```
        ┌────────────────────────┐         ┌──────────────────────────┐
        │      Documento         │         │  MementoDocumento        │
        │      (Originator)      │         │  (estado salvo)          │
        │  + editarConteudo()    │────────►│  titulo, conteudo,       │
        │  + salvar(): Memento   │  cria   │  autor, dataHora         │
        │  + restaurar(memento)  │◄────────│                          │
        └────────────────────────┘  restaura└────────────────────────┘
                   ▲                                   ▲
                   │                                   │ guarda
                   │                         ┌─────────┴────────────────┐
                   │                         │  HistoricoDocumento      │
                   │                         │  (Caretaker)             │
                   │                         │  List<MementoDocumento>  │
                   │                         └──────────────────────────┘
```

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Memento
javac -d out src/*.java
java -cp out Main
```

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

> A data/hora de modificação varia conforme o momento da execução.

```
ESTADO INICIAL
Título: Atividade Memento
Autor: Lázaro
Conteúdo: Texto inicial do documento.
Data de modificação: 13/10/2026 14:09
--------------------------------
ESTADO ATUAL
Título: Atividade Memento
Autor: Lázaro
Conteúdo: Segunda alteração do documento.
Data de modificação: 13/10/2026 14:09
--------------------------------
VERSÃO RESTAURADA
Título: Atividade Memento
Autor: Lázaro
Conteúdo: Primeira alteração do documento.
Data de modificação: 13/10/2026 14:09
--------------------------------
VERSÃO MAIS ANTIGA
Título: Atividade Memento
Autor: Lázaro
Conteúdo: Texto inicial do documento.
Data de modificação: 13/10/2026 14:09
--------------------------------
```

## Conceitos

- **Originator**: `Documento`
- **Memento**: `MementoDocumento`
- **Caretaker**: `HistoricoDocumento`
- **Client**: `Main`

## Vantagens

- Permite desfazer/reverter estados de forma simples.
- Preserva o encapsulamento: o Caretaker não acessa o conteúdo do estado salvo.
- A criação dos snapshots fica a cargo do Originator.

## Desvantagem

- Salvar muitos estados pode consumir bastante memória.
- O Caretaker precisa gerenciar quando descartar versões antigas.
