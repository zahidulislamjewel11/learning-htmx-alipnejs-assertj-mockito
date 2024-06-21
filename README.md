# Spring HTMX AlpineJS JUnit AssertJ Mockito POC

This project is a proof of concept (POC) for integrating the HTMX and Alpine.js libraries with a Spring Boot application, utilizing JUnit, AssertJ, and Mockito for testing. It showcases how these libraries can be used to enhance the frontend experience with minimal JavaScript code and demonstrates effective testing strategies.

## Project Structure

- **Spring Boot**: The backend framework used to create RESTful web services.
- **Thymeleaf**: The server-side template engine used for rendering HTML.
- **HTMX**: A library that allows you to access AJAX, CSS Transitions, WebSockets, and Server-Sent Events directly in HTML.
- **Alpine.js**: A lightweight JavaScript framework for composing behavior directly in your HTML templates.
- **JUnit**: A testing framework for Java applications.
- **AssertJ**: A fluent assertion library for Java.
- **Mockito**: A mocking framework for unit tests in Java.

## Requirements

- Java 21
- Maven

## Getting Started

### Prerequisites

Ensure you have the following installed:

- JDK 21
- Maven

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/zahidulislamjewel11/spring-htmx-alpinejs.git
    cd spring-htmx-alpinejs
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

4. Run using custom bash (included):
    ```bash
    ./run.sh
    ```

The application will start on `http://localhost:8082`.

## Project Dependencies

The project uses the following dependencies:

- **spring-boot-starter-thymeleaf**: Thymeleaf integration with Spring Boot.
- **thymeleaf-layout-dialect**: Thymeleaf layout dialect for reusable templates.
- **spring-boot-starter-web**: Spring Boot starter for building web applications.
- **spring-boot-devtools**: Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
- **lombok**: Java library that automatically plugs into your editor and build tools, removing boilerplate code.
- **spring-boot-starter-tomcat**: Provides Tomcat as the default embedded container.
- **spring-boot-starter-test**: Starter for testing Spring Boot applications.
- **mockito-core**: Mockito core for creating mock objects.
- **htmx-spring-boot**: Integration of HTMX with Spring Boot.
- **htmx-spring-boot-thymeleaf**: HTMX Thymeleaf integration.

## Configuration

The main configuration file is `application.properties`, located in `src/main/resources`.

## Usage

This project demonstrates basic usage of HTMX and Alpine.js. Here are some key concepts:

### HTMX

HTMX allows you to send AJAX requests directly from your HTML and update parts of the page without reloading.

Example:
```html
<button hx-get="/endpoint" hx-target="#response">Click me</button>
<div id="response"></div>
