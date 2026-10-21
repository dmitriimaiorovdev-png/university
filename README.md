# University Management REST API

A RESTful API for managing university students, built with Java, Spring Boot, Spring Data JPA, and PostgreSQL.

This project was developed as part of my Java Backend Development learning journey.

## Technologies

- Java
- Spring Boot
- Spring Web MVC
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven
- Postman (API testing)

## Features

The application currently supports CRUD operations for students:

- Create a new student
- Retrieve all students
- Retrieve a student by ID
- Update student information
- Delete a student

## REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get a student by ID |
| POST | `/students` | Create a new student |
| PUT | `/students/{id}` | Update an existing student |
| DELETE | `/students/{id}` | Delete a student |

## Example Request

**POST** `/students`

```json
{
  "fullName": "Max Weber",
  "email": "max.weber@example.com",
  "groupName": "IT-103",
  "enrolledYear": 2026,
  "scholarship": true
}
```

The application automatically generates the student ID and creation timestamp.

## Running the Project Locally

1. Install Java, Maven, and PostgreSQL.
2. Clone the repository.
3. Create a PostgreSQL database named `university_db`.
4. Configure the database connection in `application.properties`.
5. Set the `DB_PASSWORD` environment variable to your local PostgreSQL password.
6. Run `UniversityApplication.java` from IntelliJ IDEA.

The application runs at `http://localhost:8080` by default.

## Project Structure

```text
src/main/java/com/example/university/
├── controller/
│   └── StudentController.java
├── service/
│   └── StudentService.java
├── repository/
│   └── StudentRepository.java
├── model/
│   └── Student.java
└── UniversityApplication.java
```

## Future Improvements

- Add instructor management
- Add course management
- Implement student enrollment in courses
- Add DTOs and request validation
- Improve exception handling
- Add automated tests

## Project Status

Learning project — under active development.
