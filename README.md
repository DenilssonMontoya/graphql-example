# Graphql server - query example

**Learn how to create a Graphql server using spring.**

## Prerequistes
- Java 17.

## Run Locally

Execute following commands to build and run the Graphql server.

```bash
# Build project & install dependencies
./gradlew build

# Run project 
./gradlew bootRun
```


## Testing

This project uses a H2 database that serves as a source for the Person object that will be exposed using Graphql, to include additional information to query you need to modify resources/data.sql file and include new INSERT statements. 

By using a GraphQL client like Postman we will be able to query our API. GraphQl server endpoint will be available at http://localhost:8080/graphql .

Query examples:

- Query to obtain full Person object information
```javascript
query personDetails {
  personById(id: 1) {
    id    
    name
    lastName
    gender
  }
}
```

![postman01.png](img%2Fpostman01.png)


- Query to obtain just some attributes of Person object.
```javascript
query personDetails {
  personById(id: 1) {
    id    
    name
  }
}
```
![postman02.png](img%2Fpostman02.png)

And just like that we got only the attributes that we need from our API.




