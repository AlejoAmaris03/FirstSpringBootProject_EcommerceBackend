# 🛒 E-Commerce Backend API (Spring Boot)

This is a simple e-commerce backend API built using **Spring Boot**. It provides endpoints for managing products, users and orders. This project serves as an introductory backend for an online store, and it's my first full project using the Spring framework.

> 💡 You can find the frontend here: [E-Commerce Frontend (Angular)](https://github.com/AlejoAmaris03/FirstAngularProject_EcommerceFrontend)

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

### Access with Default Admin Credentials
  > 📝 You can log in with the following default administrator account, which is automatically created when the application starts.

👤 Username: admin  
🔑 Password: 123
 
- This account has full access to manage users, products and sales.
