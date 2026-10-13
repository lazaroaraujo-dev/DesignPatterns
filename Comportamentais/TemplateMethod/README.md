# Template Method - Processamento de Arquivos

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Template Method** para processar diferentes tipos de arquivos (clientes, produtos, vendas) seguindo **sempre o mesmo esqueleto** de execução.

## Sobre o padrão

O **Template Method** é um padrão comportamental que define o **esqueleto de um algoritmo** em um método, deixando alguns passos para as subclasses. O método `processarArquivo()` (`final`) na classe abstrata fixa a ordem das etapas; cada subclasse implementa apenas os passos que variam.

Neste projeto, o `ProcessadorArquivo` define as etapas:

```
abrirArquivo → validarEstrutura → lerDados → processarDados → salvarResultado → fecharArquivo
```

- `abrirArquivo`, `salvarResultado`, `fecharArquivo` → **concretos** (iguais para todos)
- `validarEstrutura`, `lerDados`, `processarDados` → **abstratos** (cada processador implementa)

## Estrutura

```
TemplateMethod/
└── src/
    ├── Main.java                  # Ponto de entrada
    ├── ProcessadorArquivo.java    # Abstract Class (template)
    ├── ProcessadorClientes.java   # Concrete Class
    ├── ProcessadorProdutos.java   # Concrete Class
    └── ProcessadorVendas.java     # Concrete Class
```

### Diagrama simplificado

```
        ┌──────────────────────────────────────────┐
        │          ProcessadorArquivo              │
        │  + processarArquivo() (final / template) │
        │    ├─ abrirArquivo()        (concreto)   │
        │    ├─ validarEstrutura()    (abstrato)   │
        │    ├─ lerDados()            (abstrato)   │
        │    ├─ processarDados()      (abstrato)   │
        │    ├─ salvarResultado()     (concreto)   │
        │    └─ fecharArquivo()       (concreto)   │
        └────────────────────▲─────────────────────┘
                             │ extends
        ┌────────────────────┼──────────────────────────┐
        ▼                    ▼                          ▼
┌───────────────────┐ ┌──────────────────┐ ┌────────────────────┐
│ProcessadorClientes│ │ProcessadorProdutos│ │ ProcessadorVendas │
└───────────────────┘ └──────────────────┘ └────────────────────┘
```

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd TemplateMethod
javac -d out src/*.java
java -cp out Main
```

Abra o projeto no IntelliJ IDEA e execute a classe `Main`.

### Saída esperada

```
Abrindo arquivo...
Validando informações do cliente.
Lendo dados do cliente.
Processando dados do cliente.
Salvando resultado...
Fechando arquivo...
Abrindo arquivo...
Validando dados do produto.
Lendo dados do produto.
Processando dados do produto.
Salvando resultado...
Fechando arquivo...
Abrindo arquivo...
Validando dados da venda.
Lendo dados da vendo.
Processando dados da venda.
Salvando resultado...
Fechando arquivo...
```

## Conceitos

- **Abstract Class**: `ProcessadorArquivo` (define o template)
- **Template Method**: `processarArquivo()`
- **Primitive Operations**: `validarEstrutura`, `lerDados`, `processarDados`
- **Concrete Class**: `ProcessadorClientes`, `ProcessadorProdutos`, `ProcessadorVendas`
- **Client**: `Main`

## Vantagens

- Reutiliza o esqueleto comum e evita duplicação entre os processadores.
- Garante a mesma ordem de execução para todos os tipos.
- As subclasses só se preocupam com o que realmente varia.

## Desvantagem

- O esqueleto fica rígido: subclasses não podem alterar a ordem das etapas.
