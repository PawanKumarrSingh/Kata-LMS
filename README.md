# Kata-LMS (Library Management System)

Kata-LMS is a Library Management System built using **Spring Boot**, **Microservices**, and **RESTful APIs**. The system allows users to perform essential operations like adding, borrowing, returning, and retrieving books, leveraging efficient data management techniques. The project is designed following industry-standard practices for maintainability, scalability, and ease of integration.

## Features
- **Add Book**: Allows adding new books to the library system.
- **Borrow Book**: Facilitates borrowing books by users, with tracking capabilities.
- **Return Book**: Enables users to return borrowed books.
- **Retrieve All Books**: Retrieve a list of all books available in the library.

## Technologies Used
- **Spring Boot**: Core framework for building the backend.
- **Spring REST**: Used to build RESTful APIs for managing library operations.
- **Microservices**: Each library functionality is implemented as a microservice for scalability.
- **Lombok**: For reducing boilerplate code in POJOs.
- **Swagger**: For API documentation and testing.
- **H2 Database**: Database for storing book data and user interactions.
- **JUnit**: Unit testing for validating application functionality.
- **List Data Structure**: Used for efficient management and retrieval of book records.

## Architecture
The application follows a **microservices** architecture with clear separation of concerns:
- **Controller Layer**: Handles incoming HTTP requests and routes them to the appropriate service.
- **Service Layer**: Contains the core business logic for book management.
- **Repository Layer**: Interacts with the database to fetch and store book data.
- **Model Layer**: Defines the book and user data models used throughout the application.

## Project Structure
- **controller**: Manages API requests.
- **service**: Handles the business logic.
- **repository**: Responsible for database interactions.
- **model**: Contains the data models (e.g., Book, User).
  
## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/PawanKumarrSingh/Kata-LMS.git
