# Flyweight - Blocos de um Mundo Estilo Minecraft

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Flyweight** para representar milhares de blocos de um jogo estilo Minecraft compartilhando os dados comuns (tipo, textura, solidez) entre instâncias.

## Sobre o padrão

O **Flyweight** é um padrão estrutural focado em **economia de memória**. Ele separa o estado de um objeto em:

- **Estado intrínseco** (*intrinsic*): dados compartilhados, iguais para muitas instâncias → fica no flyweight (`TipoBloco`)
- **Estado extrínseco** (*extrinsic*): dados que variam por instância → passado nos métodos (`exibir(x, y, z)`)

Neste projeto, `TipoBloco` (Pedra, Grama, Madeira) é o **flyweight**: uma única instância por combinação de nome/textura/sólido. A `BlocoFactory` mantém um cache (`Map`) e devolve sempre o **mesmo objeto** para a mesma chave. A **posição** de cada bloco é o estado extrínseco, informada na chamada de `exibir`.

## Estrutura

```
Flyweight/
└── Flyweight/
    ├── Bloco.java          # Flyweight (interface) — exibir(x, y, z)
    ├── TipoBloco.java      # Concrete Flyweight (estado intrínseco)
    ├── BlocoFactory.java   # Flyweight Factory (cache de tipos)
    └── Main.java           # Ponto de entrada
```

### Diagrama simplificado

```
              ┌────────────────────────────┐
              │     Bloco (interface)      │
              │   + exibir(x, y, z)        │
              └────────────▲───────────────┘
                           │ implementa
              ┌────────────┴───────────────┐
              │        TipoBloco           │  (Flyweight)
              │  - nome, textura, solido    │  estado intrínseco
              └────────────────────────────┘
                           ▲
                           │ cria/cacheia
              ┌────────────┴───────────────┐
              │       BlocoFactory         │
              │  Map<String, TipoBloco>    │
              │  + getBloco(nome, ...)     │
              └────────────────────────────┘
```

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Flyweight
javac -d . *.java
java -cp . Flyweight.Main
```

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

```
Bloco Pedra | textura: pedra.png | sólido: true | posição: (10,64,20)
Bloco Pedra | textura: pedra.png | sólido: true | posição: (11,64,20)
Bloco Pedra | textura: pedra.png | sólido: true | posição: (12,64,20)
Bloco Grama | textura: grama.png | sólido: true | posição: (15,64,22)
Bloco Grama | textura: grama.png | sólido: true | posição: (16,64,22)
Bloco Madeira | textura: madeira.png | sólido: true | posição: (30,65,10)
pedra1 e pedra2 são o mesmo objeto? true
```

> A última linha comprova o compartilhamento: `pedra1` e `pedra2` são a **mesma instância**.

## Conceitos

- **Flyweight**: `Bloco`
- **Concrete Flyweight**: `TipoBloco`
- **Flyweight Factory**: `BlocoFactory`
- **Estado intrínseco**: nome, textura, sólido (em `TipoBloco`)
- **Estado extrínseco**: posição `x, y, z` (parâmetros de `exibir`)

## Vantagens

- Reduz drasticamente o consumo de memória quando há muitos objetos repetidos.
- Centraliza a criação/cache de objetos compartilhados em uma fábrica.

## Desvantagem

- Aumenta a complexidade: é preciso separar estado intrínseco do extrínseco e gerenciar o cache com cautela.
