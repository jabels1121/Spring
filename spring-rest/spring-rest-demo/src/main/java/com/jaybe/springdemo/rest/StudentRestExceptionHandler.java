package com.jaybe.springdemo.rest;

import com.jaybe.springdemo.exception.StudentNotFoundException;
import com.jaybe.springdemo.model.StudentErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.lang.System.currentTimeMillis;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // add exception handling code here

    // create Exception handler for throwing StudentNotFoundException
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> catchStudentNotFound(StudentNotFoundException exc) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(currentTimeMillis());

        return new ResponseEntity<>(error, NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(currentTimeMillis());

        return new ResponseEntity<>(error, BAD_REQUEST);
    }

}
