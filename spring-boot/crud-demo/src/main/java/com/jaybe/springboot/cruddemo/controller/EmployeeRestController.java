package com.jaybe.springboot.cruddemo.controller;

import com.jaybe.springboot.cruddemo.entity.Employee;
import com.jaybe.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.jaybe.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping(path = "/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        if (employeeId <= 0) {
            throw new EmployeeNotFoundException("Employee id must be greater than zero");
        }

        var employee = employeeService.findEmployeeById(employeeId);

        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with passed ID not found!");
        }

        return employee;
    }

    // add mapping for POST /employees for create new employee
}
