package com.spring.elk.util;

import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.*;

import java.io.IOException;

@Configuration
public  class CustomStrategy implements Strategy {
    @Override
    public void write(
            final Precorrelation precorrelation,
            final HttpRequest request,
            final Sink sink) {
        // defer request logging until response is available
    }

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
}
