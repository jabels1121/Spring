package com.jaybe.springboot.cruddemo.controller;

import com.jaybe.springboot.cruddemo.dao.EmployeeDAO;
import com.jaybe.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.jaybe.springboot.cruddemo.entity.Employee;
import com.jaybe.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.jaybe.springboot.cruddemo.service.EmployeeService;
import com.jaybe.springboot.cruddemo.service.EmployeeServiceImpl;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.lang.reflect.Method;
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
        return employeeService.findAllEmployees();
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
    public ResponseEntity<Map<String, Object>> deleteFewEmployees(@RequestBody int[] employeeIds) {
        for (int i = 0; i < employeeIds.length; i++) {
            System.out.println(employeeIds[i]);
        }

        checkPassedIdsArray(employeeIds);

        Map<String, Object> response = new HashMap<>();
        List<Integer> deletedEmployeeIds = new ArrayList<>();

        Arrays.stream(employeeIds)
                .forEach(e -> {
                    employeeService.deleteById(e);
                    Employee employeeById = employeeService.findEmployeeById(e);
                    if (employeeById == null) {
                        deletedEmployeeIds.add(e);
                    }
                });

        response.put("statusCode", HttpStatus.OK.value());
        response.put("deletedEmployeeIds", deletedEmployeeIds);
        response.put("timeStamp", System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void checkPassedIdsArray(int[] employeeIds) {
        Arrays.stream(employeeIds)
                .forEach(this::checkExistenceOfEmployee);
    }

    private Employee checkExistenceOfEmployee(int employeeId) {
        if (employeeId <= 0) {
            throw new EmployeeNotFoundException("Employee id must be greater than zero");
        }

        var employee = employeeService.findEmployeeById(employeeId);

        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with passed ID - " + employeeId + " doesn't exist!");
        }

        return employee;
    }

}
