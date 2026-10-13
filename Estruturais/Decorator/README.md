# Decorator - Bebidas com Adicionais

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Decorator** em uma cafeteria, onde bebidas podem receber **adicionais** (leite extra, canela, chantilly, calda) de forma combinável e dinâmica.

## Sobre o padrão

O **Decorator** é um padrão estrutural que permite **adicionar responsabilidades a um objeto dinamicamente**, envolvendo-o em objetos "decoradores" que implementam a mesma interface. Assim, em vez de criar uma subclasse para cada combinação de adicionais, os decoradores podem ser **empilhados**.

Neste projeto:

- `Bebida` é o componente (interface) com `getDescricao()` e `getPreco()`
- `Cafe`, `Capuccino`, `ChocolateQuente` são componentes concretos
- `LeiteExtraDecorator`, `CanelaDecorator`, `ChantilyDecorator`, `CaldaChocolateDecorator` são decoradores — cada um guarda uma `Bebida` e soma seu próprio adicional ao preço/descrição

## Estrutura

```
Decorator/
└── src/
    ├── Main.java                     # Ponto de entrada
    ├── Bebida.java                   # Component
    ├── Cafe.java                     # Concrete Component
    ├── Capuccino.java                # Concrete Component
    ├── ChocolateQuente.java          # Concrete Component
    ├── LeiteExtraDecorator.java      # Decorator (+ R$ 2,00)
    ├── CanelaDecorator.java          # Decorator (+ R$ 1,50)
    ├── ChantilyDecorator.java        # Decorator (+ R$ 3,00)
    └── CaldaChocolateDecorator.java  # Decorator (+ R$ 2,50)
```

### Diagrama simplificado

```
              ┌────────────────────────┐
              │   Bebida (interface)   │
              │   + getDescricao()     │
              │   + getPreco()         │
              └───────────▲────────────┘
                          │ implementa
     ┌────────────────────┼──────────────────────────┐
     │                    │                          │
┌─────────┐     ┌──────────────────┐        ┌──────────────────┐
│  Cafe   │     │ LeiteExtra       │        │  Canela          │
│Capuccino│     │ Chantily         │  ...   │  CaldaChocolate  │
│ Choc.   │     │ (decoradores)    │        │                  │
└─────────┘     └────────┬─────────┘        └──────────────────┘
                         │ envolve uma
                         ▼
                    Bebida (outra)
```

## Preços

| Bebida base / adicional | Preço |
| ----------------------- | ----- |
| Café | R$ 5,00 |
| Capuccino | R$ 8,00 |
| Chocolate Quente | R$ 7,00 |
| Leite Extra | + R$ 2,00 |
| Canela | + R$ 1,50 |
| Chantilly | + R$ 3,00 |
| Calda de chocolate | + R$ 2,50 |

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Decorator
javac -d out src/*.java
java -cp out Main
```

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

```
Café + Leite Extra
Preço: R$ 7.0

Cappucino + Canela + ChantilyDecorator
Preço: R$ 12.5

Chocolate Quente + Leite Extra + ChantilyDecorator + Calda de chocolate
Preço: R$ 14.5
```

## Conceitos

- **Component**: `Bebida`
- **Concrete Component**: `Cafe`, `Capuccino`, `ChocolateQuente`
- **Decorator**: `LeiteExtraDecorator`, `CanelaDecorator`, `ChantilyDecorator`, `CaldaChocolateDecorator`
- **Client**: `Main`

## Vantagens

- Adiciona comportamento sem alterar as classes existentes.
- Combina adicionais livremente, em qualquer ordem e quantidade.
- Evita a explosão de subclasses para cada combinação.

## Desvantagem

- Muitos decoradores pequenos podem dificultar o entendimento do fluxo e a depuração.
