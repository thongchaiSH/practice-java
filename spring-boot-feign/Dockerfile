FROM openjdk:11.0.11-jre-slim

# copy jar file into container image under app directory
COPY target/feign-0.0.1-SNAPSHOT.jar app/appservice.jar

# expose server port accept connections
EXPOSE 8080

# start application
CMD ["java", "-jar", "app/appservice.jar"]