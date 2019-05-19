package com.jaybe.springboot.cruddemo.service;

import com.jaybe.springboot.cruddemo.dao.EmployeeRepository;
import com.jaybe.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository= employeeRepository;
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> byId = employeeRepository.findById(employeeId);
        return byId.orElse(null);
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
