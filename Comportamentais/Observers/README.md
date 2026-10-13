# Observer - Notificação de Mudança de Status de Pedido

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Observer** para notificar automaticamente vários serviços quando o **status de um pedido** muda.

## Sobre o padrão

O **Observer** é um padrão comportamental que define uma dependência **um-para-muitos**: quando um objeto (o *subject*) muda de estado, todos os seus dependentes (*observers*) são **notificados automaticamente**.

Neste projeto:

- `Pedido` é o **Subject** concreto — guarda uma lista de observers e, ao mudar de status (`atualizarStatus`), notifica todos
- `PedidoSubject` é a interface do subject (`adicionar`, `remover`, `notificar`)
- `PedidoObserver` é a interface dos observers (`atualizar`)
- `EmailService`, `LogService`, `DashboardService`, `EstoqueService`, `FaturamentoService` são **observers concretos**

## Estrutura

```
Observers/
├── Observer.iml
└── src/
    ├── Main.java                  # Ponto de entrada
    ├── PedidoSubject.java         # Subject (interface)
    ├── PedidoObserver.java        # Observer (interface)
    ├── Pedido.java                # Subject concreto
    ├── Cliente.java               # Modelo
    ├── EmailService.java          # Observer
    ├── LogService.java            # Observer
    ├── DashboardService.java      # Observer
    ├── EstoqueService.java        # Observer
    └── FaturamentoService.java    # Observer
```

### Diagrama simplificado

```
        ┌──────────────────────┐         ┌──────────────────────┐
        │    PedidoSubject     │         │   PedidoObserver     │
        │ + adicionarObserver()│         │  + atualizar(pedido) │
        │ + removerObserver()  │         └──────────▲───────────┘
        │ + notificarObservers()│                   │ implementa
        └──────────▲───────────┘         ┌──────────┼───────────────────────────┐
                   │ implementa          │          │          │        │        │
        ┌──────────┴───────────┐   ┌─────────┐ ┌────────┐ ┌────────┐ ┌───────┐ ┌──────────┐
        │       Pedido         │   │ Email   │ │  Log   │ │Dashboard│ │Estoque│ │Faturamento│
        │  - status            │──►│ Service │ │Service │ │Service  │ │Service│ │ Service  │
        │  + atualizarStatus() │   └─────────┘ └────────┘ └────────┘ └───────┘ └──────────┘
        └──────────────────────┘        notifica todos
```

## Reação dos observers por status

| Observer | `PAGO` | `CANCELADO` | Outros (ex.: `EM_SEPARACAO`, `ENVIADO`) |
| -------- | ------ | ----------- | --------------------------------------- |
| `EmailService` | Avisa o cliente | Avisa o cliente | Avisa o cliente |
| `LogService` | Registra | Registra | Registra |
| `DashboardService` | Atualiza painel | Atualiza painel | Atualiza painel |
| `EstoqueService` | Reserva itens | Devolve itens | — |
| `FaturamentoService` | Gera lançamento | Estorna valores | — |

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Observers
javac -d out src/*.java
java -cp out Main
```

Ou abra o projeto no IntelliJ IDEA (arquivo `Observer.iml`) e execute a classe `Main`.

### Saída esperada

```
--- PAGO ---
EMAIL: Cliente Lázaro avisado sobre status PAGO
LOG: Pedido PED-001 alterado para PAGO
DASHBOARD: Atualizando painel do pedido PED-001 com status PAGO
ESTOQUE: Reservando itens do pedido PED-001
FATURAMENTO: Gerando lançamento financeiro do pedido PED-001

--- EM_SEPARACAO ---
EMAIL: Cliente Lázaro avisado sobre status EM_SEPARACAO
LOG: Pedido PED-001 alterado para EM_SEPARACAO
DASHBOARD: Atualizando painel do pedido PED-001 com status EM_SEPARACAO

--- ENVIADO ---
EMAIL: Cliente Lázaro avisado sobre status ENVIADO
LOG: Pedido PED-001 alterado para ENVIADO
DASHBOARD: Atualizando painel do pedido PED-001 com status ENVIADO

--- CANCELADO ---
EMAIL: Cliente Lázaro avisado sobre status CANCELADO
LOG: Pedido PED-001 alterado para CANCELADO
DASHBOARD: Atualizando painel do pedido PED-001 com status CANCELADO
ESTOQUE: Devolvendo itens ao estoque do pedido PED-001
FATURAMENTO: Estornando valores do pedido PED-001
```

## Conceitos

- **Subject**: `PedidoSubject`
- **Concrete Subject**: `Pedido`
- **Observer**: `PedidoObserver`
- **Concrete Observer**: `EmailService`, `LogService`, `DashboardService`, `EstoqueService`, `FaturamentoService`
- **Client**: `Main`

## Vantagens

- Baixo acoplamento: o `Pedido` não conhece as classes concretas dos serviços, só a interface.
- Fácil adicionar/remover serviços interessados no status sem alterar o `Pedido`.
- Notificação automática garante que todos os interessados reajam à mudança.

## Desvantagem

- A ordem das notificações não é garantida e pode impactar efeitos colaterais.
- Vazamentos de memória se observers não forem removidos quando não necessários.
