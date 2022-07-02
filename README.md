
# Fleet management API

### Purpose of the application: 
to demonstrate the knowledge required to complete the junior enterprise backend developer training

## Description
#### This application allows the user to manage the organisation's vehicle fleet, assign cars to drivers and locations, 
#### and calculate the current value of vehicles.

Data stored in a PostgreSQL database.

### Entities:   
- car
- driver
- depot
- car value

### API docs
Interactive Swagger API documentation with UI can be found at http://localhost:8080/swagger-ui.html

Swagger API documentation in JSON can be found at http://localhost:8080/api-docs

### Installation requirements:
- docker
- docker compose
### Customize environment variables

SPRING_DATASOURCE_USERNAME=fleetmanager

SPRING_DATASOURCE_USERNAME=fleetmanager

SPRING_DATASOURCE_URL=jdbc:postgresql://fleetdb:5432/fleet

### You can run the API by using these commands:
- sudo sh start_application_1_fleetnet.sh
- sudo sh start_application_2_fleetdb.sh
- sudo sh start_application_3_fleetapp.sh

### Run Postman tests from command line to all endpoints:
First you need Newman. Install Newman: npm install -g newman
Run from command line from main directory: newman run FleetManagement.postman_collection.json 