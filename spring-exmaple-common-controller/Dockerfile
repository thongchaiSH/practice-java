FROM openjdk:8-alpine

ENV TZ=Asia/Bangkok

RUN mkdir -m 777 -p /usr/src/fwdapp/
RUN mkdir -m 777 -p /logs

COPY apps-target/fwd-is-connector-th.jar /usr/src/fwdapp/fwd-is-connector-th.jar
COPY apps-config /usr/src/fwdapp/apps-config
COPY apps-config/pdf /usr/src/fwdapp/pdf

WORKDIR /usr/src/fwdapp

ENV LOG_DIR=/logs
ENV CONFIG_DIR=/usr/src/fwdapp/apps-config

#!/bin/bash

#CMD java $JAVA_OPTS -jar /usr/src/fwdapp/fwd-is-connector-th.jar
CMD ["/usr/bin/java", "-jar", "-Xms256m", "-Xmx512m", "-Djasypt.encryptor.password=P@ssw0rd123", "-Dspring.config.location=/usr/src/fwdapp/apps-config/fwd-is-connector/application.yml",  "/usr/src/fwdapp/fwd-is-connector-th.jar"]


