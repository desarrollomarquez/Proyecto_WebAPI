# Spring Boot, Postgres, JPA, Hibernate Rest API Tutorial

Build Restful CRUD API for a simple Note-Taking application using Spring Boot, Postgres, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Postgres - 9.5

## Steps to Setup

**1. Create Postgres database**
```bash
create database dbcloud
```

**3. Change postgres username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your postgres installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/Api_cloudPersistence-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/autos
    
    POST /api/autos
    
    GET /api//{autoId}
    
    PUT /api/autos/{autoId}
    
    DELETE /api/autos/{autoId}

You can test them using postman or any other rest client.

