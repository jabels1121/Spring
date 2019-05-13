package com.jaybe.springboot.cruddemo.controller;

import com.jaybe.springboot.cruddemo.entity.Employee;
import com.jaybe.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.jaybe.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            throw new EmployeeNotFoundException("Employee with passed ID - " + employeeId + " doesn't exist!");
        }

        return employee;
    }

    // add mapping for POST /employees for create new employee
    @PostMapping(path = "/employees", produces = "application/json", consumes = "application/json")
    public Employee createNewEmployee(@RequestBody Employee employee) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save a new item ... instead of update
        employee.setId(0);

        employeeService.save(employee);

        return employee;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping(path = "/employees", produces = "application/json", consumes = "application/json")
    public Employee updateExistingEmployee(@RequestBody Employee employee) {
        var greaterEmployeeId = employeeService.getGreaterEmployeeId();

        if (employee.getId() > greaterEmployeeId || employee.getId() < 0) {
            throw new EmployeeNotFoundException("Can't find employee for updating with ID - " + employee.getId() + ".");
        }
        employeeService.save(employee);
        return employee;
    }

}
