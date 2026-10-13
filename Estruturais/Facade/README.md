# Facade - Reserva de Viagem

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Facade** para simplificar a reserva de uma viagem, que internamente envolve vários subsistemas (voo, hotel, transporte, comprovante e notificação).

## Sobre o padrão

O **Facade** é um padrão estrutural que fornece uma **interface única e simplificada** para um conjunto de subsistemas complexos. O cliente não precisa conhecer nem orquestrar cada serviço individualmente.

Neste projeto, o cliente chama apenas `ViagemFacade.reservasViagem(cliente, destino)`, e a fachada coordena toda a sequência: reserva de voo → hotel → transporte → geração de comprovante → envio de confirmação.

## Estrutura

```
Facade/
└── src/
    ├── Main.java                 # Ponto de entrada (client)
    ├── ViagemFacade.java         # Facade (orquestra tudo)
    ├── VooService.java           # Subsistema
    ├── HotelService.java         # Subsistema
    ├── TransportService.java     # Subsistema
    ├── ComprovanteService.java   # Subsistema
    ├── NotificacaoService.java   # Subsistema
    ├── Cliente.java              # Modelo
    └── Reserva.java              # Modelo
```

### Diagrama simplificado

```
                 ┌─────────────────────┐
                 │       Main          │  (Client)
                 └──────────┬──────────┘
                            │ só conhece a fachada
                            ▼
                 ┌─────────────────────┐
                 │   ViagemFacade      │  (Facade)
                 │ reservasViagem()    │
                 └──────────┬──────────┘
                            │ delega
     ┌──────────────┬───────┼──────────┬──────────────────┐
     ▼              ▼       ▼          ▼                  ▼
┌─────────┐  ┌─────────┐ ┌────────┐ ┌────────────┐ ┌────────────────┐
│  Voo    │  │ Hotel   │ │ Transp.│ │ Comprovante│ │ Notificacao    │
└─────────┘  └─────────┘ └────────┘ └────────────┘ └────────────────┘
```

## Fluxo executado pela fachada

1. `voo.reservarVoo(destino)`
2. `hotel.reservarHotel(destino)`
3. `transporte.reservarTransporte(destino)`
4. `comprovante.gerarComprovante(destino)` → gera `Reserva` com código `RES 123`
5. `confirmacao.enviarConfirmacao(cliente, reserva)`

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Facade
javac -d out src/*.java
java -cp out Main
```

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

```
Voo reservado para Recife
Hotel reservado em Recife
Transporte reservado no destino Recife
Comprovante gerado.
Confirmação enviada para cliente1@exemplo.com com código RES 123
Voo reservado para São Paulo
Hotel reservado em São Paulo
Transporte reservado no destino São Paulo
Comprovante gerado.
Confirmação enviada para cliente2@exemplo.com com código RES 123
```

## Conceitos

- **Facade**: `ViagemFacade`
- **Subsystem**: `VooService`, `HotelService`, `TransportService`, `ComprovanteService`, `NotificacaoService`
- **Client**: `Main`

## Vantagens

- Simplifica o uso de um conjunto complexo de subsistemas.
- Reduz o acoplamento entre cliente e subsistemas.
- Centraliza a ordem correta das operações.

## Desvantagem

- A fachada pode virar um "objeto-deus" se acumular regras de negócio demais.
