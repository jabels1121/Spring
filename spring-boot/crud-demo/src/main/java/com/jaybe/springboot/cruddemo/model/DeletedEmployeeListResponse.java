package com.jaybe.springboot.cruddemo.model;

import com.jaybe.springboot.cruddemo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletedEmployeeListResponse {

    private Integer statusCode;
    private List<Integer> notFoundIds;
    private List<Employee> deletedEmployee;
    private Long timeStamp;

}
