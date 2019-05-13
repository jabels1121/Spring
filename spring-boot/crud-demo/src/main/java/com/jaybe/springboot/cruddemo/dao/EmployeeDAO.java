package com.jaybe.springboot.cruddemo.dao;

import com.jaybe.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAllEmployees();

    Employee findEmployeeById(int employeeId);

    void save(Employee employee);

    void deleteById(int employeeId);
}
