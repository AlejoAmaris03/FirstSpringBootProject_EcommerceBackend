# 🛒 E-Commerce Backend API (Spring Boot)

This is a simple e-commerce backend API built using **Spring Boot**. It provides endpoints for managing products, users and orders. This project serves as an introductory backend for an online store, and it's my first full project using the Spring framework.

> 💡 You can find the frontend here: [E-Commerce Frontend (Angular)](https://github.com/AlejoAmaris03/FirstSpringBootProject_EcommerceFrontend)

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
![image](https://github.com/user-attachments/assets/dfe8759b-af8e-4e13-8e9a-9a08c0df3daf)

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

2. **Configure DB in application.properties**
   ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
    spring.datasource.username=your_user
    spring.datasource.password=your_password
    jwt.key=your_generated_key
  To generate a secure JWT key, open a terminal (CMD o PowerShell) and run:
  ```bash
    openssl rand -base64 32
  ```
  Copy the generated key and replace *your_generated_key* with it.

4. Run the project

5. The app should be running at: http://localhost:8080

### Example Endpoints
- 🟢 **GET** /products – List all products
- 🟢 **GET** /categories – List all categories
- 🟡 **POST** /auth/registerCustomer – Register new user

### Create an Admin Account
> 📝 Note: To access administrative features, you need to create a user with admin privileges. You can do this directly in the database or via the API (e.g., using Postman).

- 🔸 **Option 1: Using SQL (Manual Insert in PostgreSQL)**
    ```sql
      INSERT INTO users (name, surname, username, email, password, role_id)
      VALUES ('admin', 'admin surname', 'admin', 'admin@example.com', 'hashed_password_here', 1);
    ```
  
   - Replace hashed_password_here with a password encrypted using BCrypt 12.
   - If you're unsure how to generate a BCrypt password, you can use an online tool like [bcrypt-generator.com](https://www.browserling.com/tools/bcrypt).

- 🔸 **Option 2: Using Postman**
  - Method: POST
  - URL: http://localhost:8080/auth/registerCustomer
  - Body (raw JSON):
    ```json
    {
      "name": "admin",
      "surname": "admin surname",
      "username": "admin"
      "email": "admin@example.com",
      "password": "123",
      "role": { "id": 1 }
    }
