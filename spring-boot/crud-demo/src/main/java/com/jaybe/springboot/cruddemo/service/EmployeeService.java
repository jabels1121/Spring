package com.jaybe.springboot.cruddemo.service;

import com.jaybe.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();

    Employee findEmployeeById(int employeeId);

    void save(Employee employee);

    void deleteById(int employeeId);
}
