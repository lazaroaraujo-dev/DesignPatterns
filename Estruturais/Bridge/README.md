# Bridge - Relatórios (Financeiro / Vendas) com Exportação

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Bridge** para desacoplar dois eixos que variam independentemente: o **tipo de relatório** e o **formato de exportação**.

## Sobre o padrão

O **Bridge** é um padrão estrutural que **separa uma abstração de sua implementação**, permitindo que as duas variem de forma independente. Em vez de criar uma classe para cada combinação (`RelatorioFinanceiroPDF`, `RelatorioFinanceiroExcel`, `RelatorioVendasPDF`, ...), a hierarquia é dividida em duas:

- **Abstração** (`Relatorio`) e suas refinadas (`RelatorioFinanceiro`, `RelatorioVendas`)
- **Implementação** (`Exportador`) e suas concretas (`ExportadorPDF`, `ExportadorExcel`)

A abstração guarda uma **referência** (`exportador`) para a implementação e delega o trabalho de exportação a ela.

## Estrutura

```
Bridge/
├── Bridge.iml
└── src/
    ├── Main.java                    # Ponto de entrada
    ├── Relatorio.java               # Abstração
    ├── RelatorioFinanceiro.java     # Abstração refinada
    ├── RelatorioVendas.java         # Abstração refinada
    ├── Exportador.java              # Implementação (interface)
    ├── ExportadorPDF.java           # Implementação concreta
    ├── ExportadorExcel.java         # Implementação concreta
    └── ItemRelatorio.java           # Item (descrição + valor)
```

### Diagrama simplificado

```
        ┌────────────────────────────┐
        │   Relatorio (abstract)     │
        │   - exportador: Exportador │
        │   + adicionarItem()        │
        │   + gerar()                │
        └────────────▲───────────────┘
                     │ extends
        ┌────────────┴─────────────┐
        │                          │
┌──────────────────────┐  ┌──────────────────────┐
│ RelatorioFinanceiro  │  │   RelatorioVendas    │
└──────────┬───────────┘  └──────────┬───────────┘
           │ usa                     │ usa
           ▼                         ▼
        ┌────────────────────────────────┐
        │      Exportador (interface)    │
        │      + exportar(...)           │
        └───────────────▲────────────────┘
                        │ implements
           ┌────────────┴─────────────┐
           │                          │
  ┌──────────────────┐      ┌──────────────────┐
  │  ExportadorPDF   │      │  ExportadorExcel │
  └──────────────────┘      └──────────────────┘
```

## Regras de negócio implementadas

| Regra | Comportamento |
| ----- | ------------- |
| `gerar()` | Gera o relatório com **todos** os itens (`detalhado = true`) |
| `gerar(true)` | Exporta **todos** os itens |
| `gerar(false)` | Exporta apenas itens com valor `>= 100` (modo resumido) |
| Total | Soma dos valores dos itens exportados |

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Bridge
javac -d out src/*.java
java -cp out Main
```

Ou abra o projeto no IntelliJ IDEA (arquivo `Bridge.iml`) e execute a classe `Main`.

### Saída esperada

```
=== EXPORTANDO PDF ===
[ Relatório Financeiro ]
Itens:
 - Produto B | R$ 200.0
 - Produto C | R$ 150.0
Total: R$ +350.0
==================

=== EXPORTANDO EXCEL ===
Titulo: Relatório Financeiro
Itens:
 - Produto A | R$ 50.0
 - Produto B | R$ 200.0
 - Produto C | R$ 150.0
Total; +400.0
==================

=== EXPORTANDO PDF ===
[ Relatório de Vendas ]
Itens:
 - Produto A | R$ 50.0
 - Produto B | R$ 200.0
 - Produto C | R$ 150.0
Total: R$ +400.0
==================

=== EXPORTANDO EXCEL ===
Titulo: Relatório de Vendas
Itens:
 - Produto B | R$ 200.0
 - Produto C | R$ 150.0
Total; +350.0
==================
```

## Conceitos

- **Abstraction**: `Relatorio`
- **Refined Abstraction**: `RelatorioFinanceiro`, `RelatorioVendas`
- **Implementor**: `Exportador`
- **Concrete Implementor**: `ExportadorPDF`, `ExportadorExcel`

## Vantagens

- Desacopla tipo de relatório e formato de exportação.
- Novos formatos (ex.: CSV) exigem só um novo `Exportador`, sem mexer nos relatórios.
- Novos relatórios exigem só uma nova classe de abstração refinada.
- Evita a explosão combinatória de classes.

## Desvantagem

- Introduz uma indireção a mais, tornando o código um pouco mais complexo de entender.
