# accountapi
Spring Boot Jpa example Rest service using Docker postgreSql

## desc
Created example SpringBoot CRUD Rest service that connects up PostGres database (which is running in Docker). 
Using initialization script to create some tables (DDL) and some test data (DML). So each time you start docker instance, should have populated DB to run service against. 

!When you stop docker instance, any data changes will be lost!

### docker commands
#### start instance
	docker-compose -f docker-compose.yml  up 

	or

	docker-compose up -d (where yml file is in same dir.)

#### stop instance
	docker-compose down

