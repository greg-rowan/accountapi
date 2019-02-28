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

### Actuator Endpoint
	http://localhost:9001/actuator/health

### Sample Postman Test Data

POST

http://localhost:9001/accounts
Content-type: application/json

{
	"user_id": 123,
	"username": "Greg",
	"password": "qwerty",
	"email": "greg@gmail.com",
	"created_on": "2019-02-26T14:10:25.893+0000",
	"last_login": "2019-02-26T14:10:25.893+0000"
},
{
	"user_id": 111,
	"username": "Bill",
	"password": "qwerty",
	"email": "bill@gmail.com",
	"created_on": "2019-02-26T14:10:25.893+0000",
	"last_login": "2019-02-26T14:10:25.893+0000"
}
