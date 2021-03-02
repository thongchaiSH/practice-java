# Spring boot ELK Basic
## Description
- Elasticsearch [port:9200]
- Kibana [http://localhost:5601]
- Logstash [port:5044]

## Concept
-  Spring boot send logs via logback then push to logstash , logstash will be fillter condition and insert data to elsaticeseach ,Kibana for virtualization data

## Spring boot
### Add dependency
```xml
<dependency>
	<groupId>net.logstash.logback</groupId>
	<artifactId>logstash-logback-encoder</artifactId>
	<version>6.6</version>
</dependency>
<dependency>
	<groupId>ch.qos.logback</groupId>
	<artifactId>logback-classic</artifactId>
	<version>1.2.3</version>
</dependency>
```
- Config logback.xml

## Run start.sh or docker-compose up
**Product Service**  
http://localhost:8081/products  
**Price Service**  
http://localhost:8080/products/price  