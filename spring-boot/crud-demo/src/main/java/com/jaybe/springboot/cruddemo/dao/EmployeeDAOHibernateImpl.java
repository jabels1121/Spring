package com.jaybe.springboot.cruddemo.dao;

import com.jaybe.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees() {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> resultList = query.getResultList();

        // return the results
        return resultList;
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // create a query
        /*Query<Employee> query =
                session.createQuery("from Employee where id=:employeeId", Employee.class)
                .setParameter("employeeId", employeeId);*/

        // execute query and get Employee object
        var employee = session.get(Employee.class, employeeId);

        // return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // save employee
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int employeeId) {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // delete object by primary key
        Query query =
                session.createQuery("delete from Employee where id=:employeeId");

        // set parameter to the query
        query.setParameter("employeeId", employeeId);

        // execute query
        query.executeUpdate();
    }
}
