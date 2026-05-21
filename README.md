# Library Microservices System

A distributed microservices-based library management system developed using Spring Boot, Apache Kafka, MySQL, Docker, and GitHub Actions CI/CD.

---

# Project Architecture

```text
library-microservices
│
├── book-service
├── borrow-service
├── customer-service
├── payment-service
├── notification-service
│
├── docker-compose.yml
│
├── mysql
│   └── init.sql
│
└── .github
    └── workflows
        └── cicd.yml
```

---

# Technologies Used

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Apache Kafka
* Docker & Docker Compose
* GitHub Actions CI/CD
* Maven
* Postman

---

# System Overview

The project simulates a distributed library management system using Microservices Architecture.

Each service is responsible for a specific business functionality:

| Service              | Responsibility              |
| -------------------- | --------------------------- |
| book-service         | Manage books                |
| borrow-service       | Handle borrowing operations |
| customer-service     | Manage customers            |
| payment-service      | Process payments            |
| notification-service | Handle notifications        |

The services communicate using:

* REST APIs
* Apache Kafka Event-Driven Messaging

---

# Microservices Ports

| Service              | Port |
| -------------------- | ---- |
| borrow-service       | 8085 |
| book-service         | 8081 |
| customer-service     | 8084 |
| payment-service      | 8082 |
| notification-service | 8083 |

---

# Databases

Each microservice uses its own independent MySQL database.

| Service              | Database        |
| -------------------- | --------------- |
| book-service         | book_db         |
| borrow-service       | borrow_db       |
| customer-service     | customer_db     |
| payment-service      | payment_db      |
| notification-service | notification_db |

---

# Kafka Communication

The system uses Apache Kafka for asynchronous communication.

## Kafka Topics

| Topic              | Description               |
| ------------------ | ------------------------- |
| payment-topic      | Payment processing events |
| notification-topic | Notification events       |

---

# How the System Works

1. A customer requests to borrow a book.
2. borrow-service checks book availability from book-service using REST API.
3. If the book is available:

   * A payment event is sent to Kafka.
   * A notification event is sent to Kafka.
4. payment-service consumes the payment event.
5. notification-service consumes the notification event.
6. Data is stored in separate databases.

---

# REST API Endpoints

## Book Service

### Add Book

```http
POST /books
```

### Get Book

```http
GET /books/{id}
```

---

## Customer Service

### Add Customer

```http
POST /customers
```

### Get Customer

```http
GET /customers/{id}
```

---

## Borrow Service

### Borrow Book

```http
POST /borrow
```

---

# Example API Requests

## Add Book

```json
{
  "id":"B101",
  "title":"Clean Code",
  "available":true,
  "quantity":5
}
```

---

## Add Customer

```json
{
  "id":"C001",
  "name":"Eman",
  "email":"eman@email.com"
}
```

---

## Borrow Book

```json
{
  "customerId":"C001",
  "bookId":"B101"
}
```

---

# Running the Project

## Option 1 —  Hybrid Execution

### Run Infrastructure Using Docker

```bash
docker compose up -d
```

This starts:

* MySQL
* Kafka
* Zookeeper

---

### Run Spring Boot Services from IntelliJ

Run the following applications:

* BookServiceApplication
* BorrowServiceApplication
* CustomerServiceApplication
* PaymentServiceApplication
* NotificationServiceApplication

---

## Option 2 — Full Docker Deployment

### Build JAR Files

```bash
mvn clean package
```

---

### Start All Containers

```bash
docker compose up --build
```

This starts:

* MySQL
* Kafka
* Zookeeper
* All Microservices

---

# Docker Configuration

Each microservice contains its own Dockerfile.

Example:

```dockerfile
FROM openjdk:17

COPY target/book-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
```

---

# Docker Compose

The project uses Docker Compose to manage:

* MySQL
* Kafka
* Zookeeper
* All microservices

---

# Database Initialization

File:

```text
mysql/init.sql
```

Example:

```sql
CREATE DATABASE IF NOT EXISTS book_db;
CREATE DATABASE IF NOT EXISTS borrow_db;
CREATE DATABASE IF NOT EXISTS customer_db;
CREATE DATABASE IF NOT EXISTS payment_db;
CREATE DATABASE IF NOT EXISTS notification_db;
```

---

# GitHub Actions CI/CD

The project includes a CI/CD pipeline using GitHub Actions.

Location:

```text
.github/workflows/cicd.yml
```

The pipeline automatically:

* Checks out the repository
* Configures Java 17
* Builds all microservices
* Verifies successful compilation

---

# Running CI/CD

Whenever code is pushed to GitHub:

```bash
git add .
git commit -m "Final microservices project"
git push
```

GitHub Actions automatically runs the pipeline.

---

# Postman Testing

The APIs were tested using Postman.

## Tested Operations

* Add Book
* Add Customer
* Borrow Book
* Kafka Event Processing
* Database Persistence

---

# Example Kafka Logs

## Payment Service

```text
Payment Processed: Payment Request Created
```

---

## Notification Service

```text
Notification Received
```

---

# Project Features

* Microservices Architecture
* REST API Communication
* Event-Driven Architecture using Kafka
* Independent Databases
* Docker Containerization
* Full Docker Compose Deployment
* CI/CD Automation
* Distributed System Design
* Service Isolation
* Scalable Architecture



