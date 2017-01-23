# Spring Boot MySQL

## Stack
* Spring
  * Spring Boot 
  * Spring Data
  * Spring MVC
  * Spring JPA
* Swagger 2
* MySQL
* Gradle

## Requirements
* Java 7+
* MySQL instantie
  * see [application.properties](src/main/resources/application.properties) for mysql configuration
  
## How to run
* Make sure the mysql instance is running
  * if under linux, and docker is installed, you can run run-mysql-docker.sh
    * this will start a mysql instance conforming to the configuration in the application.properties 
    
* Gradlew bootRun
  * Will execute the Spring Boot tomcat @ port 18086

## How to add data
* The applicatione contains some Rest services, which can be used by any client (/user)
* Or you can use the Swagger2 UI, @http://localhost:18086/swagger-ui.html#/
