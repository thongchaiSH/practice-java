package com.is.reg.controller.exception;

import com.is.reg.model.base.BaseResponseWithData;
import com.is.reg.model.base.StatusType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler=new GlobalExceptionHandler();

    @BeforeEach
    void setUp() {
    }

    @Test
    void Should_ThrowStatus500_When_Exception() {
        //given
        String errorMessage=UUID.randomUUID().toString();
        Exception exception=new Exception(errorMessage);
        //when
        ResponseEntity response=handler.toResponse(exception);
        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

        Object  bodyObj= response.getBody();
        BaseResponseWithData baseResponse=(BaseResponseWithData)bodyObj;
        assertThat(baseResponse.getStatusCode()).isEqualTo(StatusType.internal_system_error.getStatusCode());
        assertThat(baseResponse.getMessage()).contains(errorMessage);
        assertThat(baseResponse.getData()).isNull();
    }
}