package com.jaybe.springboot.cruddemo.dao;

import com.jaybe.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAllEmployees() {
        // create a query
        Query query =
                entityManager.createQuery("from Employee");

        // execute query and get result list
        List<Employee> resultList = query.getResultList();

        // return result list
        return resultList;
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        // get employee
        Employee employee = entityManager.find(Employee.class, employeeId);

        // return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // save or update the employee
        Employee dbEmployee = entityManager.merge(employee);

        // update with id from db ... so we can get generated id for save/insert
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int employeeId) {
        // delete object with primary key
        Query query =
                entityManager.createQuery("delete from Employee where id=:theId");

        query.setParameter("theId", employeeId);

        query.executeUpdate();
    }

    @Override
    public int getGreaterEmployeeId() {
        return 0;
    }
}
