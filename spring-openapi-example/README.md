# OpenAPI with .yml

## Setup Project
```
mvn clean install
```

## Testing
### Request
```
http://localhost:8081/blog/example
```
### Response
```json
{
    id: 100,
    blogtitle: "Thongchai SH",
    content: "My content"
}
```

## Reference
- [API-First Development with Spring Boot and Swagger](https://reflectoring.io/spring-boot-openapi/)
