# Project Overview

This project is a RESTful API built using Java and the Spring Boot framework. It follows a typical layered architecture pattern, with separate layers for the entity, controller, service, and repository. The project uses Maven as a build tool and JPA for database interaction.

![image](https://github.com/baderbenlhachemi/restcrudmysql/assets/88034249/b5ed6657-792c-4b5f-a359-c123a7b220f3)

## Entity

The entity in this project is `Employee`. It is a simple Java class annotated with JPA annotations to map it to a database table. The `Employee` class has fields for `id`, `firstName`, `lastName`, and `email`, which correspond to columns in the `employee` table.

```java
@Entity
@Table(name = "employee")
public class Employee {
    // fields, constructors, getters and setters
}
```

## Repository

The `EmployeeRepository` interface extends `JpaRepository`, which provides methods for standard CRUD operations. This interface interacts directly with the database.

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```

## Service

The `EmployeeService` interface defines the business logic for operations on `Employee` objects. The `EmployeeServiceImpl` class implements this interface and uses `EmployeeRepository` to perform the actual database operations.

```java
public interface EmployeeService {
    // method declarations
}

@Service
public class EmployeeServiceImpl implements EmployeeService  {
    // method implementations
}
```

## Controller

The `EmployeeRestController` class is a REST controller that handles HTTP requests. It uses `EmployeeService` to perform operations and return responses.

```java
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    // endpoints
}
```

## Database Interaction

The interaction with the database is handled by Spring Data JPA. The `EmployeeRepository` interface extends `JpaRepository`, which provides methods for CRUD operations. These methods are used by the `EmployeeService` to interact with the database.

The `Employee` entity is mapped to a database table using JPA annotations. The `id` field is annotated with `@Id` and `@GeneratedValue` to indicate that it is the primary key and is auto-generated.

## Conclusion

This project demonstrates a typical Spring Boot application structure, with a clear separation of concerns between the entity, repository, service, and controller layers. This structure makes the code easier to understand, test, and maintain.
