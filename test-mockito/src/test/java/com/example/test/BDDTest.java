package com.example.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.BDDMockito.*;

//Behavior Driven Development
@ExtendWith(MockitoExtension.class)
public class BDDTest {
    @Mock
    List<Integer> mock;


    @Test
    @DisplayName("Mockito")
    void demo(){
        when(mock.size()).thenReturn(3);
        int size=mock.size();

        verify(mock).size();
        Assertions.assertEquals(3,size);
    }

    @Test
    @DisplayName("BDD Mockito")
    void demoBDD(){
        //Given == Mock
        given(mock.size()).willReturn(3); //given() = จะทำการ mock method ว่าจะ return อะไรออกมา

        //When == Perform the test
        int size=mock.size(); //when() = จะเป็นการ perform method ที่เราต้องการ test

        //Then
        then(mock).should().size(); //then() = จะเป็นการ Assert ว่าสิ่งที่เราต้องการนั้นได้ผลลัพธ์ทีต้องการไหม
        Assertions.assertEquals(3,size);
    }
}
