package com.jaybe.springboot.cruddemo.aop;

import com.jaybe.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.jaybe.springboot.cruddemo.model.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> employeeNotFound(EmployeeNotFoundException exc) {
        // create employee error response object
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();

        // fill the error response fields
        if (exc.getMessage().contains("not found")) {
            errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        }
        if (exc.getMessage().contains("greater than zero")) {
            errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        }
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, exc.getMessage().contains("not found") ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {
        // create employee error response object
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();

        if (exc.getMessage().contains("Failed to convert value of type 'java.lang.String'")) {
            errorResponse.setMessage("Employee id must be a number!");
        } else {
            errorResponse.setMessage(exc.getMessage());
        }
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
