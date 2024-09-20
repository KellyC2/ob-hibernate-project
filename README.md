# ob-hibernate-project

This project was developed using **Spring Boot** and integrates several essential modules to create a robust and scalable web application.

## Technologies Used

The project is built on the following technologies and tools:

- **Spring Boot**: Framework for building Java applications.
- **Spring Web**: For creating controllers and exposing REST services.
- **MySQL Driver**: For connecting to and manipulating a MySQL database.
- **Spring Data JPA**: For managing persistence operations using ORM.
- **Spring DevTools**: To accelerate the development cycle with automatic reloads.

## Implemented Features

- **Entities**: Defined **5 different entities** in the persistence layer, each mapped to a table in the MySQL database.
- **Relationships**: Implemented relationships between entities, managing associations such as **one-to-one** , **one-to-many** and **many-to-many**.
- **REST Controllers**: Designed controllers for each entity to enable CRUD operations (Create, Read, Update, Delete) via **HTTP requests**.
  - Entity creation operations are handled with **POST requests**.
- **Repositories**: Each controller interacts with repositories that extend `JpaRepository`, handling persistence operations in the database.

## Postman Testing

- **Postman Tests**: Each entity has been tested thoroughly using **Postman** to ensure that all REST endpoints perform CRUD operations correctly.
- A **Postman collection** containing these tests has been exported and added to the project. You can find this collection in the root directory of the project under the file `Postman_Collection.json`.
- To run the tests, import the collection into Postman:
  1. Open Postman.
  2. Click on the **Import** button and select the `HibernateProject.postman_collection.json` file from the root folder.
  3. Run the tests to interact with the REST endpoints.

## Project Structure

The project follows a layered architecture that separates responsibilities into the following sections:

1. **Controllers**: Handle HTTP requests and respond with JSON data.
2. **Services**: Implement business logic and facilitate communication between controllers and repositories.
3. **Repositories**: Manage data access and persistence operations with the database.
