# Factory Method - Geração de Documentos

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Factory Method** para gerar documentos em diferentes formatos (PDF, Word e Planilha) sem que o cliente conheça as classes concretas.

## Sobre o padrão

O **Factory Method** é um padrão de criação que define uma **interface para criar um objeto**, mas deixa que as **subclasses decidam qual classe instanciar**. O método de criação (`criarDocumento()`) é declarado na fábrica abstrata e implementado por cada fábrica concreta.

Neste projeto:

- `Documento` é o **produto** (interface com `gerar()`)
- `PDF`, `Word`, `Planilha` são **produtos concretos**
- `FabricaDocumento` é a **criadora abstrata** (declara `criarDocumento()`)
- `FabricaPDF`, `FabricaWord`, `FabricaPlanilha` são **criadoras concretas**

## Estrutura

```
Factory-Method/
├── Factory-Method.iml
└── src/
    ├── Main.java                     # Ponto de entrada
    ├── documentos/
    │   ├── Documento.java            # Product (interface)
    │   ├── PDF.java                  # Concrete Product
    │   ├── Word.java                 # Concrete Product
    │   └── Planilha.java             # Concrete Product
    └── fabricas/
        ├── FabricaDocumento.java     # Creator (abstract)
        ├── FabricaPDF.java           # Concrete Creator
        ├── FabricaWord.java          # Concrete Creator
        └── FabricaPlanilha.java      # Concrete Creator
```

### Diagrama simplificado

```
        ┌────────────────────────┐        ┌────────────────────────┐
        │   FabricaDocumento     │        │   Documento (interface)│
        │   (abstract)           │        │   + gerar()            │
        │   + criarDocumento()   │───────►│                        │
        └───────────▲────────────┘  cria  └───────────▲────────────┘
                    │ extends                         │ implements
     ┌──────────────┼──────────────┐       ┌──────────┼──────────┐
     │              │              │       │          │          │
┌─────────┐  ┌──────────┐  ┌─────────────┐ │      ┌───────┐ ┌─────────┐
│Fabrica  │  │Fabrica   │  │Fabrica      │ │      │ PDF   │ │ Word    │
│PDF      │  │Word      │  │Planilha     │ └─────►│       │ │Planilha │
└─────────┘  └──────────┘  └─────────────┘        └───────┘ └─────────┘
```

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Factory-Method
javac -d out $(find src -name "*.java")
java -cp out Main
```

Ou abra o projeto no IntelliJ IDEA (arquivo `Factory-Method.iml`) e execute a classe `Main`.

### Saída esperada

```
== TESTE: PDF ==
Gerando documento PDF...
== TESTE: Word ==
Gerando documento Word...
== TESTE: Planilha ==
Gerando documento Planilha...
```

## Conceitos

- **Product**: `Documento`
- **Concrete Product**: `PDF`, `Word`, `Planilha`
- **Creator**: `FabricaDocumento`
- **Concrete Creator**: `FabricaPDF`, `FabricaWord`, `FabricaPlanilha`
- **Client**: `Main`

## Vantagens

- O cliente trabalha apenas com as abstrações `FabricaDocumento` e `Documento`.
- Adicionar um novo formato exige criar a classe do documento e sua fábrica, sem alterar o código existente.
- Aplica o princípio "aberto para extensão, fechado para modificação".

## Desvantagem

- Aumenta o número de classes (uma fábrica por produto).
