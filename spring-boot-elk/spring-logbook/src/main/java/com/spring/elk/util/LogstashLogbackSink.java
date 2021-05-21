package com.spring.elk.util;

import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.marker.RawJsonAppendingMarker;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.*;
import org.zalando.logbook.json.JsonHttpLogFormatter;

import java.io.IOException;
import java.util.logging.Logger;


@Slf4j
@Configuration
public class LogstashLogbackSink implements Sink {

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

    @Override
    public void write(Precorrelation precorrelation, HttpRequest request) throws IOException {
        //not implement
    }

    @Override
    public void write(Correlation correlation, HttpRequest request, HttpResponse response) throws IOException {
        //not implement
    }

}
