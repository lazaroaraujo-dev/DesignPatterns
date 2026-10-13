# Visitor - Inspeções em Setores da Empresa

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Visitor** para aplicar diferentes **inspeções** (segurança, limpeza) sobre os setores de uma empresa **sem alterar as classes dos setores**.

## Sobre o padrão

O **Visitor** é um padrão comportamental que permite **adicionar novas operações** a uma estrutura de objetos sem modificar as classes desses objetos. A operação (o "visitante") é separada da estrutura visitada.

O mecanismo usa **duplo despacho**: o `Setor` recebe o visitante em `aceitar(visitante)` e chama `visitante.visitar(this)`; assim cada setor executa a sobrecarga correta do visitante.

Neste projeto:

- `Setor` é a **interface do elemento** (`aceitar(VisitanteSetor)`)
- `Armazem`, `Administrativo`, `Frota`, `Producao` são **elementos concretos**
- `VisitanteSetor` é a **interface do visitante** (sobrecargas de `visitar` para cada setor)
- `InspecaoSeguranca` e `AvaliacaoLimpeza` são **visitantes concretos**

## Estrutura

```
Visitor/
└── src/
    ├── Main.java                 # Ponto de entrada
    ├── Setor.java                # Element (interface)
    ├── Armazem.java              # Concrete Element
    ├── Administrativo.java       # Concrete Element
    ├── Frota.java                # Concrete Element
    ├── Producao.java             # Concrete Element
    ├── VisitanteSetor.java       # Visitor (interface)
    ├── InspecaoSeguranca.java    # Concrete Visitor
    └── AvaliacaoLimpeza.java     # Concrete Visitor
```

### Diagrama simplificado

```
        ┌──────────────────────┐        ┌──────────────────────────┐
        │   Setor (interface)  │        │  VisitanteSetor (iface)  │
        │  + aceitar(v)        │        │  + visitar(Armazem)      │
        └──────────▲───────────┘        │  + visitar(Administrat.) │
                   │ implementa         │  + visitar(Frota)        │
   ┌───────────┬───┴───────┬──────────┐ │  + visitar(Producao)     │
   ▼           ▼           ▼          ▼ └──────────▲───────────────┘
┌────────┐ ┌──────────┐ ┌───────┐ ┌─────────┐     │ implementa
│Armazem │ │Administr.│ │Frota  │ │Producao │  ┌──┴───────────────────┐
└────────┘ └──────────┘ └───────┘ └─────────┘  │ InspecaoSeguranca    │
   v.visitar(this)  ──► duplo despacho          │ AvaliacaoLimpeza     │
                                               └──────────────────────┘
```

## Regras implementadas

| Visitante | Armazém | Frota | Produção |
| --------- | ------- | ----- | -------- |
| `InspecaoSeguranca` | Alerta se `> 50` equipamentos | Verifica manutenção em dia | Verifica uso de EPI |
| `AvaliacaoLimpeza` | Verifica se está organizado | Avalia veículos | Limpeza reforçada se risco `> 7` |
| Ambos | `Administrativo`: documentos/emergências e mesas |

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Visitor
javac -d out src/*.java
java -cp out Main
```

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

```
===== INSPEÇÃO DE SEGURANÇA =====
Inspeção no Armazém
Muitos equipamentos. Atenção à segurança.

Inspeção no Administrativo
Saídas de emergência verificadas.

Inspeção na Frota
Existem veículos com manutenção atrasada.

Inspeção na Produção
Funcionários utilizando EPIs.

===== AVALIAÇÃO DE LIMPEZA =====
Avaliação de limpeza no Armazém
Armazém desorganizado.

Avaliação de limpeza no Administrativo
Mesas e documentos avaliados.

Avaliação de limpeza na Frota
Veículos avaliados.

Avaliação de limpeza na Produção
Área exige limpeza reforçada.
```

## Conceitos

- **Element**: `Setor`
- **Concrete Element**: `Armazem`, `Administrativo`, `Frota`, `Producao`
- **Visitor**: `VisitanteSetor`
- **Concrete Visitor**: `InspecaoSeguranca`, `AvaliacaoLimpeza`
- **Client**: `Main`

## Vantagens

- Adiciona novas operações (novas inspeções) sem tocar nas classes dos setores.
- Reúne lógicas relacionadas (ex.: toda a inspeção de segurança) em uma só classe.
- Aplica o princípio da responsabilidade única separando estrutura de operação.

## Desvantagem

- Adicionar um **novo elemento** (novo setor) exige alterar a interface `VisitanteSetor` e **todos** os visitantes.
