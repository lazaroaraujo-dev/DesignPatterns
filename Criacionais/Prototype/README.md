# Prototype - Clonagem de Provas (Template)

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Prototype** para gerar diferentes versões de uma prova a partir de um **modelo (template)**, copiando objetos em vez de recriá-los do zero.

## Sobre o padrão

O **Prototype** é um padrão de criação que permite **copiar objetos existentes** (protótipos) sem depender de suas classes concretas nem repetir inicializações custosas. A cópia pode ser feita via um método `copiar()` (clonagem manual).

Neste projeto:

- `Prova` e `Questao` são os **protótipos**, cada um com um método `copiar()`
- `Prova.copiar()` faz uma **cópia profunda** (*deep copy*): copia também cada `Questao` da lista
- `Main` cria um `template` e, a partir dele, gera `prova1` e `prova2`, alterando turma, data, versão e trocando questões — **sem afetar o template original**

## Estrutura

```
Prototype/
├── Prototype.iml
└── src/
    ├── Main.java      # Ponto de entrada
    ├── Prova.java     # Prototype (copia profundamente)
    └── Questao.java   # Prototype
```

### Diagrama simplificado

```
        ┌───────────────────────────┐
        │          Prova            │
        │  titulo, turma, data,     │
        │  versao, List<Questao>    │
        │  + copiar(): Prova  ───┐  │
        └────────────┬───────────┘  │
                     │ contém       │ deep copy
                     ▼              ▼
        ┌───────────────────────────┐   ┌─────────────────────┐
        │         Questao           │   │  nova Prova + novas │
        │  id, enunciado, pontos    │──►│  Questões copiadas  │
        │  + copiar(): Questao      │   └─────────────────────┘
        └───────────────────────────┘
```

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Prototype
javac -d out src/*.java
java -cp out Main
```

Ou abra o projeto no IntelliJ IDEA (arquivo `Prototype.iml`) e execute a classe `Main`.

### Saída esperada

```
 TEMPLATE
Título: Prova POO - Template
Turma: TEMPLATE
Data: 2026-03-10
Versão: BASE
Total de pontos: 10
Questões:
- Q1 (3 pontos)
- Q2 (3 pontos)
- Q3 (4 pontos)

=== PROVA 1 ===
Título: Prova POO - Template
Turma: 2º INFO A
Data: 2026-03-20
Versão: V1
Total de pontos: 10
Questões:
- Q1 (3 pontos)
- Q2 (3 pontos)
- Q3 (4 pontos)

=== PROVA 2 ===
Título: Prova POO - Template
Turma: 2º INFO B
Data: 2026-03-21
Versão: V1
Total de pontos: 11
Questões:
- Q1 (3 pontos)
- Q2 (3 pontos)
- Q3 (5 pontos)

 TEMPLATE APÓS ALTERAÇÃO NA PROVA 1
Título: Prova POO - Template
Turma: TEMPLATE
Data: 2026-03-10
Versão: BASE
Total de pontos: 10
Questões:
- Q1 (3 pontos)
- Q2 (3 pontos)
- Q3 (4 pontos)

 PROVA 1 APÓS ALTERAÇÃO
Título: Prova POO - Template
Turma: 2º INFO A
Data: 2026-03-20
Versão: V1
Total de pontos: 10
Questões:
- Q1 (3 pontos)
- Q2 (3 pontos)
- Q3 (4 pontos)
```

> Observe que alterar a `prova1` **não** afeta o `template` — a cópia é profunda.

## Conceitos

- **Prototype**: `Prova`, `Questao`
- **Client**: `Main`

## Vantagens

- Cria novos objetos a partir de um modelo, evitando código de inicialização repetitivo.
- Permite gerar variantes independentes com uma cópia profunda.
- Adicionar/remover tipos de questão não exige alterar o processo de clonagem da prova.

## Desvantagem

- Implementar uma **cópia profunda** correta de estruturas complexas (listas de objetos) exige cuidado.
