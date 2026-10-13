# State - Ciclo de Vida de um Chamado

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **State** para modelar o **ciclo de vida de um chamado** de suporte, em que o comportamento muda conforme o estado atual.

## Sobre o padrão

O **State** é um padrão comportamental que permite que um objeto **altere seu comportamento quando seu estado interno muda**. Em vez de usar muitos `if/else`, cada estado é uma classe que sabe quais transições são válidas.

Neste projeto:

- `Chamado` é o **Context** — delega as ações ao estado atual (`estadoAtual`)
- `EstadoChamado` é a interface dos estados
- Estados concretos: `EstadoAberto`, `EstadoEmAtendimento`, `EstadoAguardandoCliente`, `EstadoResolvido`, `EstadoCancelado`
- Cada ação (`iniciarAtendimento`, `aguardarCliente`, `responderCliente`, `resolver`, `cancelar`) é tratada pelo estado, que pode efetuar a transição via `chamado.setEstado(...)`

Um chamado novo sempre começa em `EstadoAberto`.

## Estrutura

```
State/
└── src/
    ├── Main.java                    # Ponto de entrada
    ├── Chamado.java                 # Context
    ├── EstadoChamado.java           # State (interface)
    ├── EstadoAberto.java            # Concrete State
    ├── EstadoEmAtendimento.java     # Concrete State
    ├── EstadoAguardandoCliente.java # Concrete State
    ├── EstadoResolvido.java         # Concrete State
    └── EstadoCancelado.java         # Concrete State
```

### Diagrama simplificado

```
                          ┌──────────────────────────┐
                          │        Chamado           │
                          │  - estadoAtual           │
                          │  + iniciarAtendimento()  │
                          │  + aguardarCliente()     │
                          │  + responderCliente()    │
                          │  + resolver()/cancelar() │
                          └────────────▲─────────────┘
                                       │ delega
                                       ▼
                          ┌──────────────────────────┐
                          │   EstadoChamado (iface)  │
                          └────────────▲─────────────┘
        ┌──────────┬─────────┼──────────────┬─────────────┐
        ▼          ▼         ▼              ▼             ▼
   ┌────────┐ ┌─────────┐ ┌───────────┐ ┌────────┐ ┌──────────┐
   │ Aberto │ │Em Atend.│ │Aguardando │ │Resolv. │ │Cancelado │
   └────────┘ └─────────┘ └───────────┘ └────────┘ └──────────┘
```

## Transições válidas

| Estado atual | Ação | Novo estado |
| ------------ | ---- | ----------- |
| Aberto | `iniciarAtendimento` | Em Atendimento |
| Aberto | `cancelar` | Cancelado |
| Em Atendimento | `aguardarCliente` | Aguardando Cliente |
| Em Atendimento | `resolver` | Resolvido |
| Em Atendimento | `cancelar` | Cancelado |
| Aguardando Cliente | `responderCliente` | Em Atendimento |
| Aguardando Cliente | `cancelar` | Cancelado |
| Resolvido | — | (não permite novas transições) |
| Cancelado | — | (não permite novas transições) |

Demais combinações imprimem "Não é possível fazer essa transição...".

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd State
javac -d out src/*.java
java -cp out Main
```

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

```
Não é possível fazer essa transição (Aberto -> Resolver)
Em aberto -> Em atendimento
Em atendimento -> Aguardando Cliente
Não é possível fazer essa transição (Aguardando Cliente -> Resolvido)
Aguardando Cliente -> Em atendimento
Em atendimento -> Resolvido
Não é possível cancelar um chamado resolvido.
Em aberto -> Cancelado
Não é possível atender um chamado cancelado.
```

## Conceitos

- **Context**: `Chamado`
- **State**: `EstadoChamado`
- **Concrete State**: `EstadoAberto`, `EstadoEmAtendimento`, `EstadoAguardandoCliente`, `EstadoResolvido`, `EstadoCancelado`
- **Client**: `Main`

## Vantagens

- Elimina grandes blocos de `if/switch` sobre o estado.
- Cada estado encapsula suas próprias regras de transição, facilitando manutenção e testes.
- Adicionar um novo estado não exige alterar o `Chamado`.

## Desvantagem

- Aumenta o número de classes (uma por estado), o que pode ser excessivo para fluxos simples.
