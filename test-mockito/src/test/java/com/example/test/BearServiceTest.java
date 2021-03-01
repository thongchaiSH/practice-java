package com.example.test;


import com.example.test.model.Bear;
import com.example.test.service.BearService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BearServiceTest {
    @Mock
    Bear bear;

    @InjectMocks
    BearService bearService;

    @Test
    @DisplayName("Testing bear say hello")
     void testItShouldReturnHelloFromBear(){
        when(bear.roar()).thenReturn("Grrrrr!");
        String actual= bearService.say();
        assertEquals("Grrrrr!", actual);
//        assertEquals("Hello",actual); //it will be fail
        verify(bear,times(1)).roar();
    }
}
