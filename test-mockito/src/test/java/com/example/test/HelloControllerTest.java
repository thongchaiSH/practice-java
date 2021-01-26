package com.example.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
@DisplayName("Demo Spring Boot with JUnit 5 + Mockito")
class HelloControllerTest {


    @InjectMocks
    private HelloController helloController;

    @BeforeEach
    void setUp() {
        System.out.println("Setup !!");
    }

    @Test
    @DisplayName("Test Hello world")
    void testHelloWorld() {
        assertEquals("hello world", helloController.helloWorld());
    }


}