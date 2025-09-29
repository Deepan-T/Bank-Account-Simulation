Bank Account Simulation

A simple Java program to simulate basic banking operations: deposit, withdraw, and maintaining transaction history.

📋 Overview

. This project implements an Account class which supports:

. Depositing money

. Withdrawing money (with basic checks, e.g. insufficient funds)

. Keeping track of current balance

. Recording a history of all transactions (with timestamps)

. A demo (driver) class shows how to use the Account class.

. It is intended as a beginner-level OOP project, to illustrate encapsulation, state management, and basic method design.
🧱 Design & Classes
Account

Fields:

. accountId (String) — unique identifier for the account

. balance (double) — current money in the account

. transactionHistory (List<String>) — a log of all operations done (deposits, withdrawals, errors) along with timestamps

Constructor:

. Account(String accountId, double initialBalance) — initializes the account and records an initial “account created” transaction.

Methods:

. void deposit(double amount) — adds amount to balance if amount > 0; logs the transaction.

. void withdraw(double amount) — subtracts amount if sufficient funds are available; otherwise rejects and logs failure.

. List<String> getTransactionHistory() — returns the log.

. double getBalance() — returns current balance.

. void printStatement() — prints the entire transaction history and current balance.

Helper (private) methods:

. recordTransaction(String description) — prepends a timestamp and appends to transaction history.

. formatAmount(double amt) — for consistent formatting (e.g. two decimal places).

Demo / Driver class

 Contains a main(String[] args) which:

. Creates an Account instance with an initial balance.

. Performs a few deposits and withdrawals (including invalid operations to demonstrate error handling).

. Calls printStatement() to display all history and current balance.

. You might name this driver class something like AccountDemo or BankSimulator.

🛠 How to Use / Run

. Save your Java source files, e.g.:

Account.java
BankAccount.java


In terminal / command prompt, navigate to the folder containing these files.

Compile:

. javac Account.java BankAccount.java

. This produces .class files (bytecode).

Run the program:

java BankAccount
The main method in BankAccount will execute, performing simulated transactions and printing the statement.
💡 Possible Extensions & Improvements

. Here are some ideas to evolve this simple simulation into a more robust system:

. Replace transaction history List<String> with a Transaction class having fields like: timestamp, type (deposit/withdrawal/failure), amount, resulting balance.

. Add transfer functionality: transferTo(Account other, double amount).

. Introduce overdraft / minimum balance rules.

. Support multiple accounts with a manager class (e.g. Bank) that can find accounts by ID.

. Persist transaction logs or account data to file or database (so that state survives restarts).

. Add user interface (console menu, GUI, web) for interactive operations.
📝 Summary
This project is a foundational exercise in object-oriented programming with Java. It models a single bank
account with proper encapsulation, method behavior, and transaction logging. It’s a good base from which you can layer in more banking features as you grow the project.
. Make the class thread-safe if you simulate multiple concurrent transactions.
