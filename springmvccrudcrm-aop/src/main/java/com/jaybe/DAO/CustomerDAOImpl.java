package com.jaybe.DAO;

import com.jaybe.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // create a query for get list customers
        Query<Customer> theQuery =
                session.createQuery("from Customer order by lastName", Customer.class);

        // execute the query
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        // get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // save/update the customer object to DB
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int customerId) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // get customer from DB by received customer Id
        Customer customer = currentSession.get(Customer.class, customerId);

        // return the retrieved customer
        return customer;
    }

    @Override
    public void deleteCustomer(int customerId) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create HQL query for deleting customer
        Query<Customer> query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", customerId);

        // execute the query that delete the customer by id
        query.executeUpdate();

        /*// get customer by using customer id for deleting him later
        Customer customer = currentSession.get(Customer.class, customerId);

        // delete the customer by received customer id
        currentSession.delete(customer);*/
    }

    @Override
    public List<Customer> searchCustomers(String customerName) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> query = null;

        //
        // only search by name if theSearchName is not empty
        //
        if (customerName != null && customerName.trim().length() > 0) {
            // if customer name not equal null and not empty then create a query that return relevant customers list by customer name
            // search for firstName or lastName ... case insensitive
            query = currentSession.createQuery("from Customer where lower(firstName) like :name " +
                    "or lower(lastName) like :name order by lastName", Customer.class);
            query.setParameter("name", "%" + customerName.toLowerCase() + "%");

        } else {// retrieving all customers if customerName null or empty
            // create query that return all customers
            query = currentSession.createQuery("from Customer order by lastName", Customer.class);
        }

        // execute the query
        List<Customer> customers = query.getResultList();

        // return the list of customers
        return customers;
    }
}
