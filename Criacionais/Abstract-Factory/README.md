# Abstract Factory - Checkout E-commerce

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Abstract Factory** em um cenário de checkout de e-commerce que precisa atender fornecedores **nacionais** e **internacionais**.

## Sobre o padrão

O **Abstract Factory** é um padrão de criação que fornece uma interface para criar **famílias de objetos relacionados** sem especificar suas classes concretas.

Neste projeto, cada tipo de fornecedor (nacional/internacional) representa uma "família" de produtos:

- `Pagamento`
- `Frete`
- `NotaFiscal`

O `CheckoutService` não conhece as classes concretas — ele apenas usa a interface `FornecedorFactory`. Isso garante que um checkout nacional nunca misture acidentalmente um frete internacional, por exemplo.

## Estrutura

```
src/
├── Main.java                         # Ponto de entrada (executa os dois cenários)
├── factory/
│   ├── FornecedorFactory.java        # Abstract Factory (interface)
│   ├── FornecedorNacionalFactory.java
│   └── FornecedorInternacionalFactory.java
├── produto/
│   ├── Pagamento.java                # Produto abstrato
│   ├── Frete.java                    # Produto abstrato
│   ├── NotaFiscal.java               # Produto abstrato
│   ├── nacional/
│   │   ├── PagamentoNacional.java
│   │   ├── FreteNacional.java
│   │   └── NotaFiscalNacional.java
│   └── internacional/
│       ├── PagamentoInternacional.java
│       ├── FreteInternacional.java
│       └── NotaFiscalInternacional.java
└── service/
    └── CheckoutService.java          # Client — depende só das abstrações
```

### Diagrama simplificado

```
                  ┌──────────────────────┐
                  │  FornecedorFactory   │  (Abstract Factory)
                  │  + criarPagamento()  │
                  │  + criarFrete()      │
                  │  + criarNotaFiscal() │
                  └──────────┬───────────┘
                             │ implements
              ┌──────────────┴──────────────┐
              │                             │
┌─────────────────────────┐   ┌─────────────────────────────┐
│ FornecedorNacional      │   │ FornecedorInternacional     │
│ Factory                 │   │ Factory                     │
└────────────┬────────────┘   └──────────────┬──────────────┘
             │ cria                          │ cria
   ┌─────────┴──────────┐           ┌────────┴───────────┐
   │ PagamentoNacional  │           │ PagamentoInternac. │
   │ FreteNacional      │           │ FreteInternacional │
   │ NotaFiscalNacional │           │ NotaFiscalInternac.│
   └────────────────────┘           └────────────────────┘
```

## Regras de negócio implementadas

| Produto      | Nacional                          | Internacional                        |
| ------------ | --------------------------------- | ------------------------------------ |
| Pagamento    | Aprovação nacional                | Aprovação com taxa                    |
| Frete        | `15.0 + (pesoKg * 2.0)`           | `40.0 + (pesoKg * 5.0)`              |
| Nota Fiscal  | `NF - NAC - <pedidoId>`           | `NF - INT - <pedidoId>`              |

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd AbstractFactory
javac -d out src/**/*.java
java -cp out Main
```

Ou abra o projeto no IntelliJ IDEA (arquivo `AbstractFactory_ecommerce.iml`) e execute a classe `Main`.

### Saída esperada

```
== CHECKOUT pedido PED-10 ==
Frete calculado: 21.0
Total: 111.0
[NACIONAL] Pagamento aprovado
NF gerada: NF - NAC - PED-10
Compra finalizada!

-----------------------------
== CHECKOUT pedido PED-10 ==
Frete calculado: 55.0
Total: 145.0
[INTERNACIONAL] Pagamento aprovado com taxa
NF gerada: NF - INT - PED-10
Compra finalizada!
```

## Conceitos

- **Abstract Factory**: `FornecedorFactory`
- **Concrete Factory**: `FornecedorNacionalFactory`, `FornecedorInternacionalFactory`
- **Abstract Product**: `Pagamento`, `Frete`, `NotaFiscal`
- **Concrete Product**: implementações `...Nacional` e `...Internacional`
- **Client**: `CheckoutService`

## Vantagens

- Isolamento das classes concretas: o cliente só conhece as interfaces.
- Consistência entre produtos de uma mesma família.
- Facilidade para adicionar uma nova família (ex.: `FornecedorRegionalFactory`) sem alterar o cliente.

## Desvantagem

- Adicionar um **novo tipo de produto** exige alterar a interface `FornecedorFactory` e todas as fábricas concretas.
