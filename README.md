
# Fleet management API

### Purpose of the application: 
An introduction to the skills required to complete the junior enterprise backend developer training

## Description
This application allows the user to manage the organisation's vehicle fleet, assign cars to drivers and locations, 
and calculate the current value of vehicles.

### Entities:   
- car
- driver
- depot
- car value


#### Used technologies:
Sping Boot, JPA Hibernate, Flyway, Swagger, Docker containers

Data stored in a PostgreSQL database.

### Installation requirements:
- docker
- docker compose
- flyway

### Customize environment variables

SPRING_DATASOURCE_USERNAME=fleetmanager

SPRING_DATASOURCE_USERNAME=fleetmanager

SPRING_DATASOURCE_URL=jdbc:postgresql://fleetdb:5432/fleet

### You can run the API in docker by using these commands:
- sudo sh start_application_1_fleetnet.sh
- sudo sh start_application_2_fleetdb.sh
- sudo sh start_application_3_fleetapp.sh


### API docs
Interactive Swagger API documentation with UI can be found at http://localhost:8080/swagger-ui.html

Swagger API documentation in JSON can be found at http://localhost:8080/api-docs


### Run Postman tests from command line to all endpoints:
First you need Newman. Install Newman: 

npm install -g newman

Run from command line from the project main directory: 

newman run FleetManagement.postman_collection.json 

### Steps for running integration and unit tests with coverage in IntelliJ:
 - fleet_management_api/src/test/java  
 - right click  
 - More/Run Debug  
 - Run 'All Tests' with Coverage
 (before running, you may need to type in a command line to run the tests correctly: flyway clean)
