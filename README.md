# BankAPI

A RESTful banking API built with **Java and Spring Boot**, designed to manage bank accounts and financial transactions.

This project is currently under development and serves as a practical backend development project.

## Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Spring Security
- Maven

## Database Structure

The application currently uses two main database tables:

### 1. Accounts
Stores account information, including:
- Account number
- First name
- Last name
- Password
- Account balance

### 2. Transactions
Stores transaction records, including:
- Transaction ID
- Sender account
- Receiver account
- Transaction amount
- Transaction date and time
- Transaction status

## Authentication

The application uses database-based authentication through the Accounts table, with Spring Security handling authentication.

## API Endpoints

The API provides endpoints for basic account and transaction operations.

### Accounts
- Retrieve account information.

### Transactions
- Perform a transaction between accounts.
- Retrieve transaction records.
- Retrieve transaction records associated with accounts.

*Endpoints and functionality are subject to change as development progresses.*

## Running the Project

1. Clone the repository:

   git clone <repository-url>

2. Configure your MySQL database and update the database credentials in `application.properties`.

3. Build the project:

   mvn clean install
   
4. Run the application:

   mvn spring-boot:run

## Project Status

**Under Development**

New features, improvements, and additional functionality are being implemented as the project evolves.
