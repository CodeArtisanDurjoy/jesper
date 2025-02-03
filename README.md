# Jesper - Spring Security Application

## Overview

Jesper is a Spring Boot application that implements security features using Spring Security, JWT authentication, and PostgreSQL as the database. This application provides a secure API for managing user authentication and file downloads.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [License](#license)
- [Contact](#contact)

## Features

- JWT-based authentication
- Role-based access control
- File management APIs
- Swagger UI for API documentation
- PostgreSQL database integration

## Installation

To set up the project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/CodeArtisanDurjoy/jesper.git
cd jesper
./mvnw install

server.port=9090
spring.datasource.url=jdbc:postgresql://your-database-url
spring.datasource.username=your-username
spring.datasource.password=your-password
app.jwt.secret=your-secret-key
app.jwt.expiration=86400000


Security Configuration
The application uses Spring Security for authentication. The SecurityConfig class configures the security filter chain and JWT authentication.

JWT Configuration
The JwtTokenProvider class handles the generation and validation of JWT tokens. Ensure that you set the app.jwt.secret property in your application.properties.

Contact
Durjoy Acharjya
Email: da-durjoy@outlook.com
GitHub: CodeArtisanDurjoy


### Instructions for Use
1. Save this content in a file named `README.md` in the root of your GitHub repository.
2. Make sure to replace any placeholder values (like database URL, username, password, and JWT secret) with your actual configuration details.

This README provides a comprehensive overview of your project, making it easier for others to understand and use your application.
