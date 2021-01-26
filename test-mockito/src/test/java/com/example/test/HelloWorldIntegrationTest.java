package com.example.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // for restTemplate
//@ActiveProfiles("test")
public class HelloWorldIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Integration test of the BarService")
    void testHello() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/hello").toString(), String.class);

        assertEquals("hello world", response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("Testing json service")
    void testJson() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/hello/json").toString(), String.class);
        String expect = "{title:Title,value:Value}";
        JSONAssert.assertEquals(expect, response.getBody(), true); //fields must match will
//        JSONAssert.assertEquals(expect, response.getBody(), false); //some fields doesn't matter

    }

}
