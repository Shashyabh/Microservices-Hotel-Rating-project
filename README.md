# Spring Boot Microservices Project

### This repository contains a Spring Boot microservices project for a hotel management application. 
### The project utilizes various microservices to handle different functionalities of the application. 
### The microservices included in this project are as follows:

### ApiGateway: 
  Serves as the entry point for the application, routing requests to the appropriate microservices.
### ConfigServer:
  Manages the centralized configuration for all microservices.
### HotelService:
  Handles hotel-related operations such as managing hotel information and room availability.
### RatingService:
  Manages ratings and reviews for hotels.
### ServiceRegistory:
  Registers and tracks the available services in the system.
### UserService:
  Handles user management and authentication.


## Technologies Used


### The project utilizes the following technologies and frameworks:

### Java
### Spring Boot
### Spring Cloud
### Netflix Zuul (API Gateway)
### Spring Cloud Config (Config Server)
### MySQL
### Hibernate
### Eureka Server (Service Registry)
### Spring Security
### Swagger

## Microservices Overview
### ApiGateway
The ApiGateway microservice serves as the entry point for the application and handles requests from clients. It acts as a reverse proxy, routing requests to the appropriate microservices based on the URL patterns. It provides a centralized endpoint for all API requests and helps to ensure security and scalability.

### ConfigServer
The ConfigServer microservice is responsible for managing the centralized configuration for all microservices in the system. It stores the configuration files externally, allowing for dynamic configuration changes without redeploying the microservices. The ConfigServer provides a reliable and scalable approach to handle application configuration.

### HotelService
The HotelService microservice handles hotel-related operations. It provides functionalities to manage hotel information, room availability, and other hotel-related data. It communicates with the database and exposes RESTful APIs for the clients to interact with the hotel management features.

### RatingService
The RatingService microservice manages ratings and reviews for hotels. It allows users to submit ratings and reviews for the hotels they have stayed at. It handles the storage and retrieval of ratings, and provides APIs to retrieve average ratings, reviews, and other related information.

### ServiceRegistry
The ServiceRegistry microservice acts as a service registry and discovery mechanism for all microservices in the system. It keeps track of the available services and their network locations. It allows microservices to register themselves upon startup and provides an interface for other microservices to discover and communicate with each other.

### UserService
The UserService microservice handles user management and authentication. It provides APIs for user registration, login, and user profile management. It integrates with the database to store and retrieve user information securely. The UserService ensures proper authentication and authorization for accessing protected resources.

### Getting Started
To run the microservices locally, follow these steps:

## Clone the repository:

### shell
### Copy code
```
  git clone https://github.com/Shashyabh/springboot-microservices-project.git
```
### Ensure you have Java and Maven installed on your system.

### Configure the necessary properties in the configuration files of each microservice. For example, configure the database connection details, port numbers, and other environment-specific settings.

Build the project using Maven:

shell
Copy code
```
cd springboot-microservices-project
mvn clean install
```
### Start each microservice individually by navigating into the respective microservice directory and running the following command:


shell
Copy code
```
mvn spring-boot:run
```
### Start the microservices in the following order:

### ConfigServer
### ServiceRegistory
### ApiGateway
### HotelService
### RatingService
### UserService

Access the APIs and documentation through Swagger UI or other API testing tools.\
Use the base URLs and ports of each microservice to interact with the available endpoints.

## Contributing
Contributions to the project are welcome. If you find any issues or would like to propose improvements, feel free to open an issue or submit a pull request.


### Note: The instructions provided above assume a basic understanding of Spring Boot and microservices architecture. Please refer to the respective microservice directories for more detailed instructions and additional configuration settings.
