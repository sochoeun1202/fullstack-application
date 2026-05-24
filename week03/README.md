# Spring Boot REST API - Microservice

This project is a Spring Boot-based microservice designed with a clean, layered architecture and consistent design patterns to ensure maintainability, scalability, and clarity.

## 🏗️ Architecture & Design Patterns

The project follows a **Layered Architecture** pattern, ensuring a clear separation of concerns:

1.  **Controller Layer**: Handles HTTP requests and returns standardized responses using `ResponseEntity`.
2.  **Service Layer**: Contains business logic, defined by interfaces for loose coupling.
3.  **Repository Layer**: Manages data persistence using Spring Data JPA.
4.  **DTO (Data Transfer Object) Pattern**: Uses separate objects for requests (`ProductRequest`) and responses (`ProductResponse`) to decouple the internal entity structure from the external API.
5.  **Mapper Pattern**: Employs explicit mapper components (`@Component`) for manual, type-safe conversion between entities and DTOs.
6.  **Unified Response Wrapper**: All API responses are wrapped in a generic `MessageResponse<T>` to provide consistent metadata (success status, message, error codes) across the entire API.
7.  **Global Exception Handling**: Employs `@RestControllerAdvice` to centrally manage exceptions, ensuring that even in error scenarios, the API returns a standardized `MessageResponse` structure.

## 📁 Project Structure

```text
src/main/java/com/sochoeun/microservice/
├── controllers/     # REST Controllers (API Endpoints)
├── services/        # Service Interfaces & Implementations
│   └── impl/        # Concrete Service Implementations
├── repositories/    # Spring Data JPA Repositories
├── entities/        # JPA Entities (Database Models)
├── dto/             # Data Transfer Objects
│   ├── request/     # Input Request DTOs
│   └── response/    # Output Response DTOs
├── mappers/         # Data Mappers (Entity <-> DTO)
└── exception/       # Global Exception Handler & Response Wrappers
```

## 🚀 Key Components

### Unified Response Wrapper (`MessageResponse`)
All endpoints return a standardized JSON structure:
```json
{
  "data": { ... },
  "success": true,
  "message": "Operation successful",
  "errorCode": "200"
}
```

### Global Exception Handling
Custom exceptions (`ApiException`) are caught by the `GlobalExceptionHandler` to return a consistent error response:
```json
{
  "data": null,
  "success": false,
  "message": "Error message details",
  "errorCode": "ERR_CODE"
}
```

### Mapper Component
Mappings are handled by dedicated components using Lombok's `@Builder`:
```java
@Component
public class ProductMapper {
    public ProductEntity toEntity(ProductRequest request) { ... }
    public ProductResponse toResponse(ProductEntity entity) { ... }
}
```

## 🛠️ API Endpoints (Product API)

**Base URL:** `/api/v1/products`

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/` | Fetch all products |
| `GET` | `/{productId}` | Fetch a single product by ID |
| `POST` | `/create` | Create a new product |
| `PATCH` | `/update?productId={id}` | Update an existing product |
| `DELETE` | `/delete?productId={id}` | Delete a product |

## ⚙️ Technologies Used

- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2/PostgreSQL/MySQL** (as configured)
- **Lombok** (to reduce boilerplate)
- **Spring Web**
