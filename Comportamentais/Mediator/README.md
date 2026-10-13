# Mediator - Fluxo de Atendimento de uma Clínica

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Mediator** para coordenar a comunicação entre os setores de uma clínica (recepção, médico, laboratório, enfermagem e paciente) sem que eles se conheçam diretamente.

## Sobre o padrão

O **Mediator** é um padrão comportamental que **centraliza a comunicação** entre objetos. Em vez de cada parte conhecer e chamar todas as outras (gerando um emaranhado de dependências), todos falam apenas com o **mediador**, que decide quem deve receber cada mensagem.

Neste projeto, a `CentralAtendimentoClinica` é o mediador. Cada participante estende `Participante` e envia mensagens via `mediador.enviarMensagem(...)`. A central identifica o **remetente** e encaminha a mensagem ao próximo setor correto, encadeando o fluxo:

```
Paciente → Recepção → Médico → Laboratório → Enfermagem → Recepção
```

## Estrutura

```
Mediator/
└── src/
    ├── Main.java                      # Ponto de entrada
    ├── MediadorClinica.java           # Mediator (interface)
    ├── CentralAtendimentoClinica.java # Concrete Mediator
    ├── Participante.java              # Colleague (abstrato)
    ├── Recepcao.java                  # Colleague
    ├── Medico.java                    # Colleague
    ├── Laboratorio.java               # Colleague
    ├── Enfermagem.java                # Colleague
    └── Paciente.java                  # Colleague
```

### Diagrama simplificado

```
        Paciente   Recepcao   Medico   Laboratorio   Enfermagem
            \         |         |          |            /
             \        |         |          |           /
              ▼       ▼         ▼          ▼          ▼
             ┌────────────────────────────────────────┐
             │        MediadorClinica (interface)      │
             │        + enviarMensagem(msg, remetente) │
             └────────────────────▲───────────────────┘
                                  │ implementa
             ┌────────────────────┴───────────────────┐
             │        CentralAtendimentoClinica        │
             │  decide o próximo destinatário          │
             └────────────────────────────────────────┘
```

## Fluxo de negócio implementado

| Remetente | Mensagem encaminhada a |
| --------- | ---------------------- |
| `Paciente` | `Recepcao` — "Paciente chegou para atendimento." |
| `Recepcao` | `Medico` — "Paciente encaminhado ao médico." |
| `Medico` | `Laboratorio` — "Realizar exame solicitado." |
| `Laboratorio` | `Enfermagem` — "Exame pronto. Preparar paciente." |
| `Enfermagem` | `Recepcao` — "Paciente pronto. Finalizar atendimento." |

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Mediator
javac -d out src/*.java
java -cp out Main
```

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

```
[PACIENTE]
Lázaro chegou à clínica.

[CENTRAL]
Mensagem recebida: Paciente chegou.
[RECEPÇÃO]
Paciente chegou para atendimento.
[RECEPÇÃO]
Iniciando atendimento.

[CENTRAL]
Mensagem recebida: Atendimento iniciado.
[MÉDICO]
Paciente encaminhado ao médico.
[MÉDICO]
Solicitando exame.

[CENTRAL]
Mensagem recebida: Solicitação de exame.
[LABORATÓRIO]
Realizar exame solicitado.
[LABORATÓRIO]
Exame realizado.

[CENTRAL]
Mensagem recebida: Resultado do exame pronto.
[ENFERMAGEM]
Exame pronto. Preparar paciente.
[ENFERMAGEM]
Preparando paciente.

[CENTRAL]
Mensagem recebida: Paciente preparado.
[RECEPÇÃO]
Paciente pronto. Finalizar atendimento.
```

## Conceitos

- **Mediator**: `MediadorClinica`
- **Concrete Mediator**: `CentralAtendimentoClinica`
- **Colleague**: `Participante` e suas subclasses (`Paciente`, `Recepcao`, `Medico`, `Laboratorio`, `Enfermagem`)
- **Client**: `Main`

## Vantagens

- Reduz o acoplamento entre os participantes — ninguém conhece os outros diretamente.
- Centraliza as regras de comunicação em um único ponto.
- Facilita alterar o fluxo sem mexer nas classes dos participantes.

## Desvantagem

- O mediador pode se tornar um "objeto-deus" com muita lógica concentrada.
