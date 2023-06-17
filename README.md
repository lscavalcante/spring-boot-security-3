# Spring Booot Security 3

Project Name is a web application built with Java 17 and Spring Boot 3, incorporating JWT (JSON Web Tokens) for authentication, Swagger for documentation and Spring Security for managing security aspects.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Features

- User authentication using JWT
- Role-based access control (RBAC) for endpoints
- Customizable security configurations
- API documentation using Swagger

## Prerequisites

To run this project, you need to have the following installed:

- Java Development Kit (JDK) 17
- Maven (for building and managing dependencies)
- Your preferred IDE (IntelliJ, Eclipse, etc.)

## Getting Started

1. Clone the repository:
    - git clone <repository-url>
2. Build the project using Maven:
   - cd project-name
   - mvn clean install

3. Run the application:
   - mvn spring-boot:run


The application will be accessible at `http://localhost:8080`.

## Configuration

The project provides several configuration options that can be customized according to your needs. The main configuration files are:

- `application.properties`: Contains general application configurations.
- `application.yml`: Contains configurations related to database connections, logging, etc.
- `SecurityConfiguration.java`: Configures the security aspects of the application using Spring Security.
- `JwtAuthenticationFilter.java`: Handles the JWT authentication process.
- `JwtAuthenticationEntryPoint.java`: Handles unauthorized access exceptions.
- `GlobalExceptionHandler.java`: Handles exceptions and returns appropriate error responses.

Feel free to modify these files based on your project requirements.

## Usage

1. Register a new user by sending a `POST` request to `auth/register` with the required information.
2. Obtain an access token by sending a `POST` request to `auth/login` with the user credentials. The response will include the access token.
3. Include the access token in the `Authorization` header of subsequent requests as a bearer token (`Authorization: Bearer <access_token>`).
4. Access the protected endpoints by providing the valid access token.

## API Documentation

The API documentation is generated using Swagger. You can access it by visiting `http://localhost:8080/swagger-ui.html` in your browser. The documentation provides details about the available endpoints, request/response formats, and authentication requirements.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

