package com.luv2code.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerErrorResponse {

    private Integer statusCode;
    private String message;
    private Long timeStamp;

}
