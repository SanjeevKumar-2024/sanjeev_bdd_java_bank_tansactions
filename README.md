# Manage Bank Transactions

## Description
A Cucumber and Rest Assured project in Java for managing bank account transactions and balances.

## Prerequisites
- Eclipse
- Cucumber
- RestAssured
- Java
- JUnit
- Maven

## Installation
1. Clone the repository.
2. Open the project in Eclipse.
3. Download the prerequisites jars and configure into the project.
4. Build and run the project.

## Usage
1. Set up your test scenarios in Cucumber feature files.
2. Run the scenarios to test bank transactions.

## Features
1. A user can have as many accounts as they want.
2. A user can create and delete accounts.
3. A user can deposit and withdraw from accounts.
4. An account cannot have less than $100 at any time in an account.
5. A user cannot withdraw more than 90% of their total balance from an account in a single transaction.
6. A user cannot deposit more than $10,000 in a single transaction.

## Tests:
CREATE:
- Create user account with valid details
- Create user account with missing fields
- Create user account with empty field values
- Create user account with duplicate account details
- Create user account with Deleted existing account details

DELETE:
- Delete user account with valid details
- Delete user account with missing fields
- Delete invalid / non existing user account
- Delete user account with account balance >=$1

DEPOSIT:
- Deposit minimum amount $100 into valid user account
- Deposit <$100 (e.g $1 / $50 / $99) amount into valid user account
- Deposit maximum amount $10000 into valid user account
- Deposit >$10000 amount into valid user account
- Deposit >=$100 and <=$10000 amount in between this range multiple times into valid user account
- Deposit minimum amount $100 into invalid user account
- Deposit <$100 (e.g $1 / $50 / $99) amount into invalid user account
- Deposit maximum amount $10000 into invalid user account
- Deposit >$10000 amount into invalid user account
- Deposit >=$100 and <=$10000 amount in between this range multiple times into invalid user account

WITHDRAW:
- Withdraw $1 valid amount from user account (e.g Account balance: $101)
- Withdraw $1 invalid amount from user account when the newly created user account before any deposit (e.g Account balance: $0)
- Withdraw $1000 invalid amount (withdraw amount > account balance) from user account (e.g Account balance: $100)
- Withdraw $900 valid amount (<=90% account balance and >=min. balance $100-> check (withdraw amount <= (account balance * 0.9) & account balance >=100)) from user account in single transaction (e.g Account balance: $1000)
- Withdraw $1011 invalid amount (>=90% account balance and >=min. balance $100-> check (withdraw amount <= (account balance * 0.9) & account balance >=100)) from user account in single transaction (e.g Account balance: $1111)
- Withdraw any valid amount (<=90% account balance and >=min. balance $100-> check (withdraw amount <= (account balance * 0.9) & account balance >=100)) from user account in multiple transaction (e.g Account balance: $200)
- Withdraw any valid amount (<=90% account balance and <=min. balance $100-> check (withdraw amount <= (account balance * 0.9) & account balance >=100)) from user account in multiple transaction (e.g Account balance: $200)

