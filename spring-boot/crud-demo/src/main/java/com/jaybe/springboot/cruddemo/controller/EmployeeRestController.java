package com.jaybe.springboot.cruddemo.controller;

import com.jaybe.springboot.cruddemo.entity.Employee;
import com.jaybe.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.jaybe.springboot.cruddemo.model.DeletedEmployeeListResponse;
import com.jaybe.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping(path = "/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return checkExistenceOfEmployee(employeeId);
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
        checkExistenceOfEmployee(employee.getId());

        employeeService.save(employee);

        return employee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete existing employee
    @DeleteMapping(path = "/employees/{employeeId}")
    public ResponseEntity<Map<String, Object>> deleteExistingEmployeeById(@PathVariable int employeeId) {
        checkExistenceOfEmployee(employeeId);

        employeeService.deleteById(employeeId);

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.OK.value());
        response.put("message", "Employee with id - " + employeeId + " was deleted.");
        response.put("timeStamp", System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/employees/deleting")
    public DeletedEmployeeListResponse deleteFewEmployees(@RequestBody int[] employeeIds) {
        DeletedEmployeeListResponse response = new DeletedEmployeeListResponse();
        List<Integer> notFoundIds = new ArrayList<>();
        List<Employee> deleteCandidate = new ArrayList<>();

        Arrays.stream(employeeIds)
                .forEach(e -> {
                    if (e < 0) {
                        throw new EmployeeNotFoundException("Employee id must be greater than zero");
                    }
                    var employee = employeeService.findById(e);
                    if (employee == null) {
                        notFoundIds.add(e);
                    } else deleteCandidate.add(employee);
                });

        deleteCandidate.stream()
                .map(Employee::getId)
                .forEach(employeeService::deleteById);

        response.setStatusCode(HttpStatus.OK.value());
        response.setNotFoundIds(notFoundIds);
        response.setDeletedEmployee(deleteCandidate);
        response.setTimeStamp(System.currentTimeMillis());

        return response;
    }

    private Employee checkExistenceOfEmployee(int employeeId) {
        if (employeeId <= 0) {
            throw new EmployeeNotFoundException("Employee id must be greater than zero");
        }

        var employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with passed ID - " + employeeId + " doesn't exist!");
        }

        return employee;
    }

}
