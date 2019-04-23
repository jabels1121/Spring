package com.luv2code.springdemo.aop;

import com.luv2code.springdemo.exceptions.CustomerNotFoundException;
import com.luv2code.springdemo.model.CustomerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> customerNotFound(CustomerNotFoundException exc) {
        // create CustomerErrorResponse object
        CustomerErrorResponse errorResponse = new CustomerErrorResponse();

        // fill the error response fields
        if (exc.getMessage().contains("greater than zero")) {
            errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        }
        if (exc.getMessage().contains("doesn't exist")) {
            errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        }
        errorResponse.setTimeStamp(System.currentTimeMillis());
        errorResponse.setMessage(exc.getMessage());

        // return ResponseEntity with status based on exception message
        return new ResponseEntity<>(errorResponse, exc.getMessage().contains("exist") ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {
        // create customerErrorResponse
        CustomerErrorResponse errorResponse =
                new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
