package com.jaybe.thymeleafcruddemo.service;

import com.jaybe.thymeleafcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void deleteById(int id);

    void save(Employee employee);

}
