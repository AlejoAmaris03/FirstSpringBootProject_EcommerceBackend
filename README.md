# 🛒 E-Commerce Backend API (Spring Boot)

This is a simple e-commerce backend API built using **Spring Boot**. It provides endpoints for managing products, users and orders. This project serves as an introductory backend for an online store, and it's my first full project using the Spring framework.

## 📌 Features

- ✅ User registration and login (JWT)
- 🛍️ Product catalog with CRUD operations
- 🗃️ Database integration with PostgreSQL
- 🔐 JWT-based authentication
- 📄 RESTful API using Spring Web

## ⚙️ Tech Stack

- **Java 24**
- **Spring Boot 3.4.4**
  - Spring Web
  - Spring Data JPA
  - Spring Security
- **PostgreSQL**
- **Lombok** for boilerplate code reduction
- **Maven** for dependency management

## 📁 Project Structure
src/
└── main/
├── java/
│ └── com.springboot.ecommerce_backend/
| ├── config/
│ ├── controllers/
| ├── dto/
│ ├── models/
│ ├── repositories/
| ├── security/
│ ├── service/
│ └── EcommerceBackendApplication.java
└── resources/
├── application.properties

## 🚀 Getting Started

### Prerequisites

- Java 23+
- Maven
- PostgreSQL

### Installation

1. **Clone the repo**
   ```bash
   git clone https://github.com/AlejoAmaris03/FirstSpringBootProject_EcommerceBackend.git
   cd FirstSpringBootProject_EcommerceBackend-main

2. Configure DB in application.properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
   spring.datasource.username=your_user
   spring.datasource.password=your_password

3. Run the project

4. The app should be running at:
   http://localhost:8080

### Example Endpoints
- GET /products – List all products
- POST /auth/registerCustomer – Register new user
