📚 Library Management System

A basic Library Management System built using Spring Boot and MongoDB, exposing RESTful Web APIs only.
The project focuses on core backend functionality such as user management, book management, and borrowing logic.

🚀 Tech Stack

Language: Java

Framework: Spring Boot

Build Tool: Maven

Database: MongoDB

API Type: REST (HTTP APIs only)

✅ Features
👤 User Management

User signup

User login

Password hashing using BCrypt

🛡️ Admin Support

Role-based users (ADMIN, USER)

Admins can add books to the library

📖 Book Management

List all books available in the library

Each book can be borrowed by only one user at a time

🔁 Borrowing System

Users can borrow books

Users can view books they have borrowed

Users can return borrowed books

⏱️ Book Policies

Expiry-based books: Returned automatically after expiry time

In-library-only books: Automatically returned at the end of the day (10 PM)

🌐 REST API Endpoints
Authentication

POST /api/auth/signup – Register a new user

POST /api/auth/login – Login user

Books

POST /api/admin/books – Add a new book (Admin)

GET /api/books – List all books

Borrowing

POST /api/user/books/{bookId}/borrow – Borrow a book

POST /api/user/books/{bookId}/return – Return a book

GET /api/user/books/borrowed – List borrowed books by user

🧱 Project Structure
src/main/java/com/example/library
├── config
├── controller
├── dto
├── model
├── repository
├── service
└── LibraryApplication.java

▶️ Running the Application
Prerequisites

Java 17+

MongoDB running locally

Start the application
./mvnw spring-boot:run


or

./gradlew bootRun


Application runs on:

http://localhost:8080


Health check:

GET /api/health

✨ Notes

This is a backend-only application

Authentication is basic (no JWT)

Designed for clarity and correctness of core logic

Suitable for learning, assignments, and backend practice

📌 Conclusion

This project implements a functional library management backend with:

User authentication

Admin-managed books

Borrowing and return logic

Policy-based book handling

The system is simple, clean, and focused on core requirements.
