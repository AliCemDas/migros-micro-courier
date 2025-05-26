# MIGROS COURIER MICROSERVICE PROJECT

This project handles courier location tracking and store notifications.

## API Documentation

You can explore and test the API using Postman via the link below:

[Postman API Documentation](https://documenter.getpostman.com/view/31370856/2sB2qcCgRW)


## Technologies, Libraries, and Tools Used in the Project

This project is built using a modern microservices architecture designed for scalability, reliability, and maintainability. Below is an overview of the key technologies, libraries, and tools that we have utilized:

- **Java 17**  
  The programming language and version used across all microservices. Java 17 is a Long-Term Support (LTS) release that offers performance improvements, enhanced language features, and long-term stability.

- **Spring Boot**  
  The core framework for building microservices. It provides easy setup and configuration, dependency injection, and production-ready features.

- **Spring Cloud**  
  Facilitates building distributed systems with components such as Eureka (for service discovery), Config Server (for centralized configuration), and API Gateway (for routing and security).

- **Eureka Server (Discovery Service)**  
  A service registry where all microservices register themselves. It enables dynamic service discovery, allowing services to find and communicate with each other without hardcoding addresses.  
  ➤ Accessible at: [http://localhost:8761](http://localhost:8761)

- **Spring Security & JWT (Auth-Service)**  
  Provides authentication and authorization mechanisms using JSON Web Tokens (JWT), ensuring secure access control across services.

- **Docker**  
  Used for containerizing each microservice, enabling consistent and portable deployment environments. Docker images are maintained in the deployment module.

- **Feign Client**  
  A declarative HTTP client used to simplify inter-service communication by abstracting REST API calls between microservices.

- **Lombok**  
  Reduces boilerplate code in Java by auto-generating getters, setters, constructors, and builders through annotations.

- **Hibernate / JPA**  
  Used for Object-Relational Mapping (ORM) to interact with relational databases in a clean and efficient way.

- **Spring Data JPA**  
  Simplifies database operations and repository implementation.

- **Maven**  
  The build automation tool used for project management, dependency resolution, and lifecycle handling.

- **IntelliJ IDEA**  
  The Integrated Development Environment (IDE) used for efficient coding, debugging, and project management.

- **Zipkin**  
  A distributed tracing system used to monitor and troubleshoot latency issues by tracking requests as they propagate through microservices.  
  ➤ Accessible at: [http://localhost:9411](http://localhost:9411)

- **PostgreSQL**  
  The relational database management system used for storing persistent data in various services.

- **Elasticsearch**  
  Used for centralized logging and fast search capabilities, helping to collect, store, and analyze log data from different microservices.

- **Swagger (OpenAPI)**  
  Provides interactive API documentation, making it easier for developers and clients to understand and test the microservices endpoints.  

  **Note:** Swagger is integrated as an example only in the *store-service* microservice. You can access the Swagger UI for the store-service at the following URL ([http://localhost:8082/swagger-ui/index.html#/](http://localhost:8082/swagger-ui/index.html#/)):  


- **Centralized Logging (Log-Service)**  
  A dedicated microservice that collects logs from other services for easier monitoring and troubleshooting.

- **Spring Cloud Config Server**  
  Provides a centralized external configuration management across all environments and microservices.

---

## Modules and Service Endpoints

- **auth-service**  
  Responsible for authentication and authorization using JWT.  
  ➤ Base URL: `http://localhost:8081`

- **gateway-service**  
  Serves as the entry point for all external requests. Routes requests to appropriate microservices and enforces security checks.  
  ➤ Base URL: `http://localhost:8080`

- **store-service**  
  Manages store-related data such as store locations and metadata (e.g., coordinates, names).  
  ➤ Base URL: `http://localhost:8082`

- **discovery-service**  
  Implements Eureka Server for service discovery.  
  ➤ Base URL: `http://localhost:8761`

- **location-service**  
  Tracks and manages real-time courier location updates. Checks proximity to stores and logs entry events.  
  ➤ Base URL: `http://localhost:8083`

- **log-service**  
  Receives and stores application logs sent from other microservices.  
  ➤ Base URL: `http://localhost:8084`

- **config-service**  
  Provides centralized configuration using Spring Cloud Config.  
  ➤ Base URL: `http://localhost:8888`

- **deployment**  
  Contains Docker-related configuration and Dockerfiles for each microservice. This module is used only for building and managing Docker images and is not a microservice itself.
  
  
  
  
  ## Request Flow in the Microservice Architecture

Below is a simplified flow diagram showing how an external request is processed through the system:

```text
+-------------+
|   Client    |
+-------------+
      |
      v
+-----------------+
| Gateway Service |
+-----------------+
      |
      v
+----------------+
|  Auth Service  |<-----+
+----------------+      |
      | Valid JWT?      |
      +-----------------+
      |
      v
+--------------------------+
|   Target Microservice    |
|  (e.g., store-service,   |
|   location-service, etc) |
+--------------------------+

```

Explanation
The Client sends a request (e.g., API call).

The request first hits the Gateway Service, which acts as a single entry point for all traffic.

The Gateway forwards the authentication part (typically the JWT token) to the Auth Service.

If the token is valid, the Gateway forwards the request to the intended microservice (like store-service or location-service).

If the token is invalid or missing, the request is rejected with an unauthorized error.