# Chain of Responsibility - Pipeline de Middlewares

Exercício da disciplina de **Padrões de Projeto**, demonstrando a aplicação do padrão **Chain of Responsibility** em um pipeline de processamento de requisições, no estilo de middlewares de frameworks web.

## Sobre o padrão

O **Chain of Responsibility** é um padrão comportamental que permite passar uma requisição por uma **cadeia de handlers**. Cada handler decide se **processa** a requisição e/ou se a **repassa** ao próximo. Se um handler reprova a requisição, a cadeia é interrompida.

Neste projeto a cadeia é:

```
Auth → Permissão → Validação → Log → Controller
```

Cada elo estende `Middleware` e, quando aprova, chama `chamarProximo(req)` para seguir adiante.

## Estrutura

```
Chain_of_Responsability/
├── Chain_of_Responsability.iml
└── src/
    ├── Main.java                    # Ponto de entrada (monta a cadeia e testa)
    ├── Middleware.java              # Handler abstrato (guarda o próximo)
    ├── AuthMiddleware.java          # Valida token
    ├── PermissaoMiddleware.java     # Exige perfil ADMIN
    ├── ValidacaoMiddleware.java     # Verifica dados válidos
    ├── LogMiddleware.java           # Registra a requisição
    ├── ControllerMiddleware.java    # Elo final — processa
    └── Requisicao.java              # Dados da requisição
```

### Diagrama simplificado

```
┌──────────────┐   ┌──────────────┐   ┌──────────────┐   ┌──────────────┐   ┌──────────────┐
│  Auth        │──►│ Permissão    │──►│ Validação    │──►│   Log        │──►│  Controller  │
│ token válido?│   │ é ADMIN?     │   │ dados ok?    │   │ registra     │   │ processa     │
└──────┬───────┘   └──────┬───────┘   └──────┬───────┘   └──────┬───────┘   └──────────────┘
       │ não               │ não               │ não             │
       ▼                   ▼                   ▼                 ▼
   interrompe          interrompe          interrompe        segue (retorna true)
```

## Regras de negócio implementadas

| Handler | Regra | Falha |
| ------- | ----- | ----- |
| `AuthMiddleware` | `req.token == "valido"` | "AUTH: Token inválido → acesso negado" |
| `PermissaoMiddleware` | `req.permissao == "ADMIN"` | "PERMISSÃO: Acesso negado" |
| `ValidacaoMiddleware` | `req.dadosValidos == true` | "VALIDAÇÃO: Dados inválidos" |
| `LogMiddleware` | sempre registra e segue | — |
| `ControllerMiddleware` | sempre processa (elo final) | — |

## Como executar

Pré-requisito: **JDK 8+**.

```bash
cd Chain_of_Responsability
javac -d out src/*.java
java -cp out Main
```

Ou abra o projeto no IntelliJ IDEA (arquivo `Chain_of_Responsability.iml`) e execute a classe `Main`.

### Saída esperada

```
CENÁRIO 1:
LOG: Requisição processada
CONTROLLER: Requisição processada com sucesso

CENÁRIO 2:
AUTH: Token inválido → acesso negado

CENÁRIO 3:
PERMISSÃO: Acesso negado

CENÁRIO 4:
VALIDAÇÃO: Dados inválidos
```

## Cenários testados

| Cenário | Token | Permissão | Dados válidos | Resultado |
| ------- | ----- | --------- | ------------- | --------- |
| 1 | válido | ADMIN | true | Passa por toda a cadeia |
| 2 | inválido | ADMIN | true | Barra no `Auth` |
| 3 | válido | USER | true | Barra na `Permissão` |
| 4 | válido | ADMIN | false | Barra na `Validação` |

## Conceitos

- **Handler**: `Middleware`
- **Concrete Handler**: `AuthMiddleware`, `PermissaoMiddleware`, `ValidacaoMiddleware`, `LogMiddleware`, `ControllerMiddleware`
- **Client**: `Main`

## Vantagens

- Encadeia responsabilidades de forma flexível, definida em tempo de execução.
- Fácil adicionar/remover/reordenar middlewares sem alterar os demais.
- Princípio da responsabilidade única: cada elo cuida de uma verificação.

## Desvantagem

- Não há garantia de que a requisição será processada (pode sair da cadeia sem resposta).
- Depurar uma cadeia longa pode ser mais difícil.
