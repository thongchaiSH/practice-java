# Java Spring MVC Spring Cloud Config Client

## Running The Cloud Config Server
```
docker run -it \
      -p 8888:8888 \
      -e SPRING_PROFILES_ACTIVE=native \
      -v /Users/Thongchai/MyProject/practice-java/spring-mvc-cloud-config-client/app-config/:/config \
      hyness/spring-cloud-config-server
```
## Set Environment
```
SPRING_APPLICATION_NAME=spring-cloud
SPRING_CLOUD_CONFIG_URI=http://localhost:8888
SPRING_PROFILES_ACTIVE=DEV
```

## Testing
```
mvn jetty:run
http://localhost:8080/
```