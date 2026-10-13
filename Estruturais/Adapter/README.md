# Adapter - Controle Universal (Mi Remote)

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Adapter** em um aplicativo de controle remoto que precisa comandar aparelhos com **APIs incompatíveis** entre si: TVs Samsung, TVs LG e um Ar-Condicionado.

## Sobre o padrão

O **Adapter** é um padrão estrutural que permite que objetos com **interfaces incompatíveis** trabalhem juntos. Ele converte a interface de uma classe (o *adaptee*) na interface que o cliente espera (o *target*).

Neste projeto, o app `MiRemoteApp` só conhece a interface `ControleUniversal` (`ligar`, `desligar`, `aumentarVolume`, `diminuirVolume`). Cada aparelho tem sua própria API com nomes diferentes — por isso são criados **adapters** que traduzem essas chamadas:

- `ControleUniversal` → interface esperada pelo cliente (*target*)
- `TvSamungApi`, `TvLgApi`, `ArCondicionadoApi` → interfaces existentes (*adaptees*)
- `SamsungAdapter`, `LgAdapter`, `ArCondicionadoAdapter` → adaptadores
- `MiRemoteApp` → cliente

## Estrutura

```
Adapter/
├── Adapter.iml
└── src/
    ├── Main.java                       # Ponto de entrada
    ├── ControleUniversal.java          # Target (interface do app)
    ├── MiRemoteApp.java                # Client
    ├── TvSamungApi.java                # Adaptee (API Samsung)
    ├── TvLgApi.java                    # Adaptee (API LG)
    ├── ArCondicionadoApi.java          # Adaptee (API Ar-Condicionado)
    ├── SamsungAdapter.java             # Adapter
    ├── LgAdapter.java                  # Adapter
    └── ArCondicionadoAdapter.java      # Adapter
```

### Diagrama simplificado

```
                ┌──────────────────────┐
                │   ControleUniversal  │  (Target)
                │  + ligar()           │
                │  + desligar()        │
                │  + aumentarVolume()  │
                │  + diminuirVolume()  │
                └──────────▲───────────┘
                           │ implements
        ┌──────────────────┼──────────────────┐
        │                  │                  │
┌───────────────┐  ┌───────────────┐  ┌──────────────────────┐
│ SamsungAdapter│  │   LgAdapter   │  │ ArCondicionadoAdapter│
└───────┬───────┘  └───────┬───────┘  └──────────┬───────────┘
        │ usa              │ usa                 │ usa
┌───────────────┐  ┌───────────────┐  ┌──────────────────────┐
│  TvSamungApi  │  │   TvLgApi     │  │  ArCondicionadoApi   │
│  powerOn()    │  │  ligarTv()    │  │ ligarArCondicionado()│
│  volumeUp()   │  │  aumentarSom()│  │ aumentarTemp()       │
└───────────────┘  └───────────────┘  └──────────────────────┘
```

## Mapeamento das chamadas

| `ControleUniversal` | `TvSamungApi` | `TvLgApi` | `ArCondicionadoApi` |
| ------------------- | ------------- | --------- | ------------------- |
| `ligar()`           | `powerOn()`   | `ligarTv()` | `ligarArCondicionado()` |
| `desligar()`        | `powerOff()`  | `desligarTv()` | `desligarArCondicionado()` |
| `aumentarVolume()`  | `volumeUp()`  | `aumentarSom()` | `aumentarTemp()` |
| `diminuirVolume()`  | `volumeDown()`| `reduzirSom()` | `diminuirTemp()` |

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Adapter
javac -d out src/*.java
java -cp out Main
```

Ou abra o projeto no IntelliJ IDEA (arquivo `Adapter.iml`) e execute a classe `Main`.

### Saída esperada

```
[Samsung] POWER ON
[Samsung] VOL +
[Mi Remote] Assistindo...
[Samsung] VOL -
[Samsung] POWER OFF
[Mi Remote] Encerrado.

[LG] Turning on TV.
[LG] increasing sound.
[Mi Remote] Assistindo...
[LG] reducing sound.
[LG] Turning off TV.
[Mi Remote] Encerrado.

Turning on air conditioning.
Temp + 1°
[Mi Remote] Assistindo...
Temp - 1°
Turning off air conditioning.
[Mi Remote] Encerrado.
```

## Conceitos

- **Target**: `ControleUniversal`
- **Client**: `MiRemoteApp`
- **Adaptee**: `TvSamungApi`, `TvLgApi`, `ArCondicionadoApi`
- **Adapter**: `SamsungAdapter`, `LgAdapter`, `ArCondicionadoAdapter`

## Vantagens

- O cliente (`MiRemoteApp`) passa a comandar **qualquer** aparelho sem conhecer as APIs específicas.
- As classes existentes (`TvSamungApi`, etc.) são reutilizadas **sem alteração**.
- Adicionar um novo aparelho exige apenas criar um novo adapter.

## Desvantagem

- Cada novo adaptee exige uma nova classe de adapter, aumentando a quantidade de código.
