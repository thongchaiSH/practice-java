# [Logbook](https://github.com/zalando/logbook)

## Add dependency
- pom.xml
```xml
        <dependency>
            <groupId>org.zalando</groupId>
            <artifactId>logbook-spring-boot-starter</artifactId>
            <version>2.9.0</version>
        </dependency>
        <dependency>
            <groupId>org.zalando</groupId>
            <artifactId>logbook-json</artifactId>
            <version>2.9.0</version>
        </dependency>
```

## Config include APIs
- application.yml
```yml
logbook:
  include:
    - /api/**
```

## Custom log request and response in single link
- CustomStrategy.java
```java
    @Override
    public void write(
            final Correlation correlation,
            final HttpRequest request,
            final HttpResponse response,
            final Sink sink) throws IOException {

        final int status = response.getStatus();
        if (status == 401 || status == 403) {
            sink.writeBoth(correlation, request.withoutBody(), response);
        } else {
            sink.writeBoth(correlation, request, response);
        }
    }
```
- LogstashLogbackSink.java
```java
    @Override
    public void writeBoth(Correlation correlation, HttpRequest request, HttpResponse response) throws java.io.IOException {
        JsonHttpLogFormatter formatter = new JsonHttpLogFormatter();
        String requestMarker = formatter.format(correlation, request);
        String responseMarker = formatter.format(correlation, response);


        MDC.put("duration",String.valueOf(correlation.getDuration().toMillis()));

        MDC.put("request.uri", request.getRequestUri());
        MDC.put("request.path", request.getPath());
        MDC.put("request.method", request.getMethod());
        MDC.put("request.body", request.getBodyAsString());
        MDC.put("request.query", request.getQuery());
//        MDC.put("request.source", requestMarker);

        MDC.put("response.status", String.valueOf(response.getStatus()));
        MDC.put("response.body",response.getBodyAsString());
        //        MDC.put("response.source", responseMarker);
        log.trace("request : {} response : {}", requestMarker, responseMarker);
        MDC.clear();
    }
```

## Config logback
- additivity log only profile "traceRequest"
```xml
    <logger name="com.spring.elk.util.LogstashLogbackSink" level="TRACE" additivity="false">
        <appender-ref ref="traceRequest"/>
    </logger>
```