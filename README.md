# Employee Management -Spring Boot, Microservices

## Steps to Setup

**1. Clone the Application**

```bash
git clone https://github.com/attrayadas/employee-management-springboot-microservices
```

**2. Create MySQL Databases**

Create the required MySQL databases for the microservices.
```bash
create database employee_db;
```
```bash
create database organization_db;
```
```bash
create database department_db;
```

**3. Update MySQL Configuration**

+ For the department-service, employee-service, and organization-service microservices, navigate to their respective application.properties files.
+ Update the MySQL database username and password to match your local MySQL installation. Locate and update the following properties

```bash
spring.datasource.username=your-username
```
```bash
spring.datasource.password=your-password
```
**4. Running the Microservices**
   
**4.1 Service Registry:**
  
+ Navigate to the `service-registry` directory.
+ Run the Spring Boot application to start the Eureka Service Registry.

**4.2 Config Server:**
  
+ Navigate to the `config-server` directory.
+ Run the Spring Boot application to start the Config Server.

**4.3 RabbitMQ (Docker):**
  
+ Ensure you have Docker installed.
+ Open a terminal and run the following command to start RabbitMQ in a Docker container:

```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
```

**4.4 API Gateway:**
  
+ Navigate to the `api-gateway` directory.
+ Run the Spring Boot application to start the API Gateway.

**4.5 Department Service:**
  
+ Navigate to the `department-service` directory.
+ Run the Spring Boot application to start the Department Service.

**4.6 Organization Service:**
  
+ Navigate to the `organization-service` directory.
+ Run the Spring Boot application to start the Organization Service.

**4.7 Employee Service:**
  
+ Navigate to the `employee-service` directory.
+ Run the Spring Boot application to start the Employee Service.

**4.8 React Frontend:**
  
+ Navigate to the `react-frontend` directory.
+ Run the React application to start the frontend.


Each microservice should be running on its respective port as configured in the application properties. The API Gateway will handle routing requests to the appropriate services.

## Services and Port Numbers

|   **Service Name**   | **Port Number** |                    **Description**                   |
|:--------------------:|:---------------:|:----------------------------------------------------:|
| Service Registry     | 8761            | Eureka Service Registry                              |
| Config Server        | 8888            | Spring Cloud Config Server                           |
| RabbitMQ (Docker)    | 5672, 15672     | Message Broker in Docker container                   |
| Zipkin Server        | 9411            | Zipkin Server for distributed tracing and monitoring |
| API Gateway          | 9191            | Gateway for routing requests                         |
| Department Service   | 8080            | Manages department information                       |
| Employee Service     | 8081            | Manages employee information                         |
| Organization Service | 8083            | Manages organization information                     |
| React Frontend       | 3000            | React frontend application                           |

## Swagger Documentation URLs
1. Department Service Swagger Documentation: http://localhost:8080/swagger-ui.html

2. Organization Service Swagger Documentation: http://localhost:8083/swagger-ui.html

3. Employee Service Swagger Documentation: http://localhost:8081/swagger-ui.html
