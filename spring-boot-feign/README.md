## Dependency
```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
```

## Call Todos APIs
- https://jsonplaceholder.typicode.com/todos

## Example
- http://localhost:8080/todo-list

## Build Image
```
docker image build -t search-service:latest .

docker run -it -p 8080:8080 --name app-container demo-app
```
## Nginx Image
```
docker image build -t custom-nginx:latest Dockerfiles/Nginx/.
```

## Docker compose
```
docker-compose up
```


## Referent
- [Making a RESTful API Creation Easy in Spring Boot](https://betterprogramming.pub/making-a-restful-api-creation-easy-in-spring-boot-dc56c0ede725)  
- [Deploying Spring Boot Applications
](https://medium.com/swlh/deploying-spring-boot-applications-15e14db25ff0)