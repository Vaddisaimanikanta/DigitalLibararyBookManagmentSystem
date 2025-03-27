# Digital Library Book Management System

## Internship Assignment Submission

This project is part of an **internship assignment** for building a **Digital Library Book Management System** using **Spring MVC, Thymeleaf, and MySQL**. The goal is to develop a simple and efficient book management system that allows librarians to **add, update, search, and delete books**, ensuring proper availability status.

---

## Objective

The purpose of this assignment is to:

- Develop a **modular and scalable** web-based application.
- Ensure **data validation** and proper **exception handling**.

---

## Features Implemented

- **Add a Book** (Book ID, Title, Author, Genre, Availability Status)
- **View All Books** (List of books with details)
- **Search Book** by ID or Title
- **Update Book Details** (Modify availability status, title, or author)
- **Delete a Book Record**
- **Exit System** (Close application)

---

## Technologies Used

- **Spring Boot (Spring MVC, Spring Data JPA, Thymeleaf)**
- **Java 17**
- **MySQL Database**
- **HTML, CSS (Thymeleaf Templates)**
- **Maven (for dependency management)**

---

## Setup & Installation

### Prerequisites

- Java 17 or later installed
- MySQL database installed
- Maven installed

### Dependencies
1.Spring Boot Starter Web
2.Spring Boot Starter Thymeleaf
3.Spring Boot Starter Data JPA
4.MySQL Connector
5.Spring Boot Devtools
6.Spring Boot Starter Test
### Steps to Run the Project

1. **Clone the Repository:**
   ```sh
   git clone https://github.com/Vaddisaimanikanta/DigitalLibararyBookManagmentSystem.git
   cd digital-library
   ```
2. **Configure the Database:**
   - Open `src/main/resources/application.properties`
   - Update database credentials:
   ```properties
   spring.application.name=DigitalLibraryBookManagementSystem 
   spring.mvc.view.prefix=classpath:/templates/
   spring.mvc.view.suffix=.html
   spring.thymeleaf.enabled=true

   spring.datasource.url=jdbc:mysql://localhost:3307/DigitalLibraryBookManagementSystemApplication?createDatabaseIfNotExist=true
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   spring.jpa.hibernate.ddl-auto=create
   spring.jpa.show-sql=true
   ```
3. **Build and Run the Application:**
   ```sh
      Run as Springbootapp
   ```
4. **Access the Application:**
   - Local Access: `http://localhost:8080/books`

---

## Folder Structure

```
digital-library/
│── src/main/java/com/library
│   ├── Controller/          # Controllers for handling web requests
│   ├── Exception/           # Custom exception handling
│   ├── Models/              # Entity class for Book
│   ├── Repository/          # Book repository interface
│   ├── Service/             # Business logic implementation
│── src/main/resources/
│   ├── static/css/          # CSS files for styling
│   ├── templates/           # Thymeleaf frontend pages
│── pom.xml                  # Maven dependencies
│── README.md                # Project documentation
```

---

## Endpoints

### Book Management

- **View All Books:** `GET /books`
- **Add New Book Form:** `GET /books/add``
- **Edit Book Form:** `GET /books/edit/{id}`
- **Update Book:** `POST /books/update/{id}`
- **Delete Book:** `GET /books/delete/{id}`
- **Search by Title:** `GET /books/search/title?title={title}`

---

## Challenges Faced

- **Ensuring Data Integrity:** Implemented constraints such as unique Book ID, non-empty Title and Author, and valid availability status.
- **Exception Handling:** Used exceptions to manage errors effectively.
- **Integration of Thymeleaf:** Managing frontend rendering dynamically with backend data.
- **Database Configuration:** Setting up and maintaining MySQL connection.

## Improvements for Future Development

- Implement **user authentication** (Admin & Librarian roles).
- Add **REST API endpoints** for external integration.
- Enhance UI/UX using **React.js or Angular**.

---

## Final Notes

This project demonstrates the ability to build a functional web-based system using **Spring MVC** while following best practices in **modular coding, exception handling, and database management**.

📌 **Completion Status:** ✅ Successfully Developed and Tested

Let me know if any modifications are required! 🎯

