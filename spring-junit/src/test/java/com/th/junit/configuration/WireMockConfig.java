package com.th.junit.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.context.annotation.Bean;

/**
 * @author Thongchai
 * @date 2021/09/27
 */
@TestConfiguration
public class WireMockConfig {

    @Autowired
    private WireMockServer wireMockServer;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer mockBooksService() {
        return new WireMockServer(9561);
    }
}
