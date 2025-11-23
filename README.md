ATM Simulator
===============

Simulador de caixa eletrônico (ATM) escrito em Java. Este projeto demonstra o uso dos padrões de projeto: State, Chain of Responsibility e Factory Method.

**Objetivo:** implementar uma simulação utilizando com padrões de projeto aplicados a um domínio realista (ATM).

**Destaque dos Padrões**

- **State:** usado para modelar os diferentes estados do ATM (sem cartão, com cartão, autenticado, sem dinheiro). Cada estado encapsula o comportamento do ATM para ações como inserir cartão, autenticar, sacar e depositar.
- **Chain Of Responsibility:** usado para montar a cadeia de dispensadores de notas que tentam fornecer a quantia solicitada dividindo-a em cédulas disponíveis (200, 100, 50, 20, 10, 5, 2, 1, etc.). A cadeia percorre os handlers até que o valor seja atendido ou ocorra uma falha.
- **Factory Method:** usado para criar objetos que representam notas (`INote` / `ConcreteNote`) de forma desacoplada (fábrica centralizada que instancia as notas corretas com base em um `NoteValue`).

Mapeamento rápido das classes

- Padrão State:
  - `classes/atm/ATM.java`
  - `StateNoCard.java`
  - `StateWithCard.java`
  - `StateAuthenticated.java`
  - `StateNoMoney.java`
  - Interface: `interfaces/ATMState.java`

- Padrão Chain Of Responsibility:
  - `classes/chainOfResponsability/AbstractHandler.java`
  - `classes/chainOfResponsability/HandlerChainBuilder.java`
  - Handlers: `handlers/Handler1.java`, `Handler2.java`, `Handler5.java`, `Handler10.java`, `Handler20.java`, `Handler50.java`, `Handler100.java`, `Handler200.java`
  - Interface: `classes/interfaces/IHandler.java`

- Padrão Factory (Notas):
  - `classes/notes/NoteFactory.java`
  - `classes/notes/ConcreteNote.java`
  - Interface: `classes/interfaces/INote.java`
  - Enum: `classes/enums/NoteValue.java`

Outros componentes importantes

- Exceções específicas: `classes/exceptions/` (ex.: `DepositLessZeroException`, `RemoveMoreHaveException`)
- Classe principal/entrypoint: `App.java`

Exemplos de fluxo (resumo)

- Retirada usando State + Chain:
  1. Usuário insere cartão → `ATM` delega para o estado atual (ex.: `StateNoCard`) para aceitar o cartão.
  2. Usuário autentica → `StateWithCard` passa para `StateAuthenticated` após validação.
  3. Usuário solicita saque → `StateAuthenticated` verifica saldo e delega ao `HandlerChain` (montado por `HandlerChainBuilder`).
  4. Cada `Handler` da cadeia tenta atender a parte do valor; se algum valor não puder ser dispensado, a exceção `CantDispense` é lançada.

- Depósito usando Factory:
  1. Ao depositar notas, o projeto pode usar `NoteFactory` para criar instâncias de `INote` conforme o valor das notas recebidas.

Como compilar e executar

Pré-requisito: Java 11+ e Maven instalados.

Compilar o projeto:

```bash
mvn package
```

Executar a aplicação (classe principal `App` no pacote default):

```bash
java -cp target/classes App
```

ou, se preferir com o plugin de execução do Maven

```bash
mvn exec:java
```

Observações

- O código foi organizado para enfatizar a separação de responsabilidades e a extensibilidade. Por exemplo, novos handlers de notas podem ser adicionados à cadeia sem modificar as classes existentes; novos estados podem ser adicionados ou modificados isoladamente; e a fábrica central de notas permite alterar a representação das notas sem impactar o cliente.
