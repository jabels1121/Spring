package com.jaybe.restdatademo.dao;

import com.jaybe.restdatademo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "members") <- change the REST endpoint name from /employees to /members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
