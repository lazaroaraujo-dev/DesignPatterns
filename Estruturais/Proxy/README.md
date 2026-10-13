# Proxy - Acesso a Filme Premium por Plano

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Proxy** para controlar o acesso a um conteúdo premium conforme o **plano do usuário**.

## Sobre o padrão

O **Proxy** é um padrão estrutural que fornece um **substituto** ou **representante** de outro objeto para controlar o acesso a ele. Neste projeto usa-se um **proxy de proteção**, que verifica a autorização antes de delegar a chamada ao objeto real.

Neste projeto:

- `Conteudo` é a interface comum (`assistir(Usuario)`)
- `FilmePremium` é o **objeto real**
- `FilmePremiumProxy` é o **proxy** — verifica o plano do usuário e só então delega ao `FilmePremium`

## Estrutura

```
Proxy/
└── src/
    ├── Main.java                # Ponto de entrada
    ├── Conteudo.java            # Subject (interface)
    ├── FilmePremium.java        # Real Subject
    ├── FilmePremiumProxy.java   # Proxy (controle de acesso)
    └── Usuario.java             # Modelo (nome + plano)
```

### Diagrama simplificado

```
        ┌──────────────────────┐
        │  Conteudo (interface)│
        │   + assistir(usuario)│
        └──────────▲───────────┘
                   │ implementa
        ┌──────────┴────────────┐
        │                       │
┌───────────────┐     ┌────────────────────┐
│ FilmePremium  │◄────│ FilmePremiumProxy  │
│ (real subject)│ delega │ verifica plano │
└───────────────┘     └────────────────────┘
```

## Regras de negócio implementadas

| Condição | Resultado |
| -------- | --------- |
| Usuário `null` | Lança `IllegalArgumentException("Usuário inválido.")` |
| Plano `PREMIUM` | "Acesso liberado..." e reproduz o filme |
| Plano `BASICO` | "Acesso negado..." (não reproduz) |

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Proxy
javac -d out src/*.java
java -cp out Main
```

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

```
Acesso liberado para Carlos
Reproduzindo filme premium para Carlos

Acesso negado para Ana conteúdo disponível apenas para usuários PREMIUM.

Acesso liberado para Marina
Reproduzindo filme premium para Marina

Acesso negado para Pedro conteúdo disponível apenas para usuários PREMIUM.

Erro esperado: Usuário inválido.
```

## Conceitos

- **Subject**: `Conteudo`
- **Real Subject**: `FilmePremium`
- **Proxy**: `FilmePremiumProxy`
- **Client**: `Main`

## Vantagens

- Adiciona controle de acesso **sem alterar** o objeto real.
- O cliente continua tratando tudo pela mesma interface (`Conteudo`).
- Permite adicionar verificações extras (cache, log, validação) de forma transparente.

## Desvantagem

- Introduz uma indireção a mais na chamada, o que pode adicionar latência e complexidade.
