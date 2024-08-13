# Gift Giver (☕ Java Spring version)

## Dependencies

- Java JDK 11
- Java JRE 11
- Sqlite3
- Maven

## Start the application

```shell
cp src/main/resources/application.properties.sample src/main/resources/application.properties
./mvnw spring-boot:run
```

### Using Docker

Alternatively, you can use Docker to start the application.

```
cp src/main/resources/application.properties.sample src/main/resources/application.properties
docker run -it --rm -p 3000:3000 -v $(pwd):/app -w /app openjdk:11 ./mvnw spring-boot:run
```
