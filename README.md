# Padrões de Projeto (Design Patterns)

Repositório da disciplina de **Padrões de Projeto** com implementações dos padrões **GoF** (Gang of Four) em **Java**, organizadas por categoria: **Criacionais**, **Estruturais** e **Comportamentais**.

Cada padrão vive em sua própria pasta, com um `README.md` explicando o conceito, a estrutura, o diagrama e como executar.

## Categorias

| Categoria | Objetivo |
| --------- | -------- |
| **Criacionais** | Abstraem o processo de **criação** de objetos, tornando o sistema independente de como seus objetos são criados, compostos e representados. |
| **Estruturais** | Tratam da **composição** de classes e objetos, formando estruturas maiores e mais flexíveis. |
| **Comportamentais** | Tratam da **interação e distribuição de responsabilidades** entre objetos, focando na comunicação e no fluxo de controle. |

## Padrões disponíveis

### Criacionais

| Padrão | Descrição | Projeto |
| ------ | --------- | ------- |
| [Abstract Factory](Criacionais/Abstract-Factory/README.md) | Cria famílias de objetos relacionados sem especificar suas classes concretas. | Checkout E-commerce |
| [Builder](Criacionais/Builder_PadraoDeProjeto/README.md) | Constrói objetos complexos passo a passo, separando a construção da representação. | Montagem de Pedidos (Lanchonete) |
| [Factory Method](Criacionais/Factory_Method/README.md) | Define uma interface para criar objetos, deixando as subclasses decidirem a classe concreta. | Geração de Documentos |
| [Prototype](Criacionais/Prototype/README.md) | Cria novos objetos clonando instâncias existentes (protótipos). | Clonagem de Provas (Template) |

### Estruturais

| Padrão | Descrição | Projeto |
| ------ | --------- | ------- |
| [Adapter](Estruturais/Adapter/README.md) | Permite que interfaces incompatíveis trabalhem juntas, convertendo uma na outra. | Controle Universal (Mi Remote) |
| [Bridge](Estruturais/Bridge/README.md) | Desacopla uma abstração de sua implementação para que variem independentemente. | Relatórios (Financeiro / Vendas) |
| [Composite](Estruturais/Composite/README.md) | Compõe objetos em estruturas de árvore para tratar itens individuais e grupos de forma uniforme. | Itens de Loja (Produtos e Kits) |
| [Decorator](Estruturais/Decorator/README.md) | Adiciona responsabilidades a objetos dinamicamente, envolvendo-os. | Bebidas com Adicionais |
| [Facade](Estruturais/Facade/README.md) | Fornece uma interface simplificada para um subsistema complexo. | Reserva de Viagem |
| [Flyweight](Estruturais/Flyweight/README.md) | Compartilha estado comum entre muitos objetos para reduzir uso de memória. | Blocos de um Mundo Estilo Minecraft |
| [Proxy](Estruturais/Proxy/README.md) | Fornece um substituto/representante que controla o acesso a outro objeto. | Acesso a Filme Premium por Plano |

### Comportamentais

| Padrão | Descrição | Projeto |
| ------ | --------- | ------- |
| [Chain of Responsibility](Comportamentais/Chain_of_Responsability/README.md) | Encadeia objetos receptores para tratar uma requisição até que um a processe. | Pipeline de Middlewares |
| [Command](Comportamentais/Command/README.md) | Encapsula uma requisição como objeto, permitindo parametrizar, enfileirar e desfazer operações. | Gerenciador de Tarefas com Undo e Fila |
| [Iterator](Comportamentais/Iterator/README.md) | Percorre os elementos de uma coleção sem expor sua estrutura interna. | Fila de Atendimento |
| [Mediator](Comportamentais/Mediator/README.md) | Centraliza a comunicação entre objetos, reduzindo o acoplamento direto entre eles. | Fluxo de Atendimento de uma Clínica |
| [Memento](Comportamentais/Memento/README.md) | Captura e restaura o estado interno de um objeto sem violar seu encapsulamento. | Versionamento de Documento |
| [Observer](Comportamentais/Observers/README.md) | Notifica dependentes automaticamente quando um objeto muda de estado. | Notificação de Mudança de Status de Pedido |
| [State](Comportamentais/State/README.md) | Permite que um objeto altere seu comportamento quando seu estado interno muda. | Ciclo de Vida de um Chamado |
| [Template Method](Comportamentais/TemplateMethod/README.md) | Define o esqueleto de um algoritmo, deixando passos para as subclasses. | Processamento de Arquivos |
| [Visitor](Comportamentais/Visitor/README.md) | Adiciona novas operações a uma estrutura de objetos sem alterar suas classes. | Inspeções em Setores da Empresa |

## Estrutura do repositório

```
DesignPatterns/
├── Criacionais/
│   ├── Abstract-Factory/
│   ├── Builder_PadraoDeProjeto/
│   ├── Factory_Method/
│   └── Prototype/
├── Estruturais/
│   ├── Adapter/
│   ├── Bridge/
│   ├── Composite/
│   ├── Decorator/
│   ├── Facade/
│   ├── Flyweight/
│   └── Proxy/
└── Comportamentais/
    ├── Chain_of_Responsability/
    ├── Command/
    ├── Iterator/
    ├── Mediator/
    ├── Memento/
    ├── Observers/
    ├── State/
    ├── TemplateMethod/
    └── Visitor/
```

Cada pasta contém:

- `README.md` — explicação do padrão, estrutura, diagrama e saída esperada.
- `src/` — código-fonte Java (alguns projetos usam uma subpasta com o nome do projeto).
- `.iml` / `.idea/` — configuração do projeto no IntelliJ IDEA.

## Como executar

Pré-requisito: **JDK 8+**.

Cada exemplo compila e roda de forma independente. Entre na pasta do padrão e compile todas as classes:

```bash
cd Criacionais/Factory_Method/Factory-Method
javac -d out $(find src -name "*.java")
java -cp out Main
```

Ou abra o projeto (arquivo `.iml`) no **IntelliJ IDEA** e execute a classe `Main`.

## Requisitos

- Java Development Kit (JDK) 8 ou superior.
- IntelliJ IDEA (opcional, para abrir os projetos `.iml`).

## Referências

- Gamma, E. et al. *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
- [Refactoring Guru — Design Patterns](https://refactoring.guru/design-patterns)
