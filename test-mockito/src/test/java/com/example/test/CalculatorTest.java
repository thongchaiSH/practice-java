package com.example.test;

import com.example.test.model.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
    @Mock
    Calculator calculator;

    /*
    * Story : Multiply

            As a user,
            I want to multiply numbers,
            So that I can get multiply result

            Scenario: double result
            Given a variable x with value 2
            When I multiply x by 2
            Then x should equal 4

            Scenario: triple result
            Given a variable x with value 3
            When I multiply x by 3
            Then x should equal 9

            โดย User story ข้างต้น จะมีความหมายดังนี้
    * */

    @Test
    @DisplayName("Multiply zero")
    void testMultiply(){
        given(calculator.multiply(3,3)).willReturn(9.0);

        double actual=calculator.multiply(3,3);

        then(calculator).should().multiply(3,3);
        Assertions.assertEquals(9,actual);
    }

    @Test
    void  testMultiply2(){
        calculator=new Calculator();
        double actual=calculator.multiply(3,3);
        Assertions.assertEquals(9,actual);
    }
}
