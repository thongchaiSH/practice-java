package com.its.app.ws.mobile.exceptions;

import java.util.Date;

import com.its.app.ws.mobile.ui.model.response.ErrorMessage;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    // Any Exception
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String errorEessage = ex.getLocalizedMessage();
        if (errorEessage == null) {
            errorEessage = ex.toString();
        }
        ErrorMessage errorMessage = ErrorMessage.builder().message(errorEessage).timestamp(new Date()).build();
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Null Pointer , UserService Exception 
    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleSpecificException(Exception ex, WebRequest request) {
        String errorEessage = ex.getLocalizedMessage();
        if (errorEessage == null) {
            errorEessage = ex.toString();
        }
        ErrorMessage errorMessage = ErrorMessage.builder().message(errorEessage).timestamp(new Date()).build();
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
