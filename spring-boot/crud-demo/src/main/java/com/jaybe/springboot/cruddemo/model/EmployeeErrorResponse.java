package com.jaybe.springboot.cruddemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeErrorResponse {

    private Integer statusCode;
    private String message;
    private Long timeStamp;

}
