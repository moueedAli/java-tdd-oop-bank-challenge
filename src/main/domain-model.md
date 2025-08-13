# Domain model for Bank challenge

## BankAccount 
| Classes     | Member                                        | Methods                 | Scenario                           | Output                                                            |
|-------------|-----------------------------------------------|-------------------------|------------------------------------|-------------------------------------------------------------------|
| BankAccount |                                               |                         |                                    |                                                                   |
|             | balance: double                               |                         |                                    |                                                                   |
|             | accountNumber: int                            |                         |                                    |                                                                   |
|             | transactions: HashMap<LocalDate, Transaction> |                         |                                    |                                                                   |
|             |                                               | deposit(double amount)  | amount > 0                         | deposit amount, update balance                                    |
|             |                                               |                         | amount = 0                         | nothing happens to balance                                        |
|             |                                               | withdraw(double amount) | amount < balance                   | amount is withdrawn, update balance                               |
|             |                                               |                         | amount > balance                   | amount is not withdrawn, user is told that amount exceeds balance |
|             |                                               | generateBankStatement() | transactions is empty              | no statement is returned                                          |
|             |                                               |                         | transactions has at least one item | generate statement                                                |


## CurrentAccount
| Classes        | Member                                        | Methods                 | Scenario                           | Output                                                            |
|----------------|-----------------------------------------------|-------------------------|------------------------------------|-------------------------------------------------------------------|
| CurrentAccount |                                               |                         |                                    |                                                                   |
|                | balance: double                               |                         |                                    |                                                                   |
|                | accountNumber: int                            |                         |                                    |                                                                   |
|                | transactions: HashMap<LocalDate, Transaction> |                         |                                    |                                                                   |
|                |                                               | deposit(double amount)  | amount > 0                         | deposit amount, update balance                                    |
|                |                                               |                         | amount = 0                         | nothing happens to balance                                        |
|                |                                               | withdraw(double amount) | amount < balance                   | amount is withdrawn, update balance                               |
|                |                                               |                         | amount > balance                   | amount is not withdrawn, user is told that amount exceeds balance |
|                |                                               | generateBankStatement() | transactions is empty              | no statement is returned                                          |
|                |                                               |                         | transactions has at least one item | generate statement                                                |

## SavingsAccount
| Classes        | Member                                        | Methods                 | Scenario                             | Output                                                            |
|----------------|-----------------------------------------------|-------------------------|--------------------------------------|-------------------------------------------------------------------|
| CurrentAccount |                                               |                         |                                      |                                                                   |
|                | balance: double                               |                         |                                      |                                                                   |
|                | accountNumber: int                            |                         |                                      |                                                                   |
|                | transactions: HashMap<LocalDate, Transaction> |                         |                                      |                                                                   |
|                |                                               | deposit(double amount)  | amount > 0                           | deposit amount, update balance                                    |
|                |                                               |                         | amount = 0                           | nothing happens to balance                                        |
|                |                                               | withdraw(double amount) | amount < balance                     | amount is withdrawn, update balance                               |
|                |                                               |                         | amount > balance                     | amount is not withdrawn, user is told that amount exceeds balance |
|                |                                               | generateBankStatement() | transactions is empty                | no statement is returned                                          |
|                |                                               |                         | transactions has at least one item   | generate statement                                                |

## Transaction
| Classes     | Member               | Methods               | Scenario                                                                                       | Output                |
|-------------|----------------------|-----------------------|------------------------------------------------------------------------------------------------|-----------------------|
| Transaction |                      |                       |                                                                                                |                       |
|             | date: LocalDate      |                       |                                                                                                |                       |
|             | double: creditAmount |                       |                                                                                                |                       |
|             | double: debitAmount  |                       |                                                                                                |                       |
|             | double: amount       |                       |                                                                                                |                       |
|             |                      | generateTransaction() | localDate not empty && (creditAmount not empty \|\| debitAmount not empty) && amount not empty | generate trans        |
|             |                      |                       | localDate empty \|\| (creditAmount  empty \|\| debitAmount  empty) \|\| amount   empty         | do not generate trans |                
