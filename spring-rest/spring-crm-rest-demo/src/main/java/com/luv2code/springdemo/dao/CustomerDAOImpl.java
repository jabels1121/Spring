package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private final SessionFactory sessionFactory;

	// need to inject the session factory
	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by id",
											Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}

    @Override
    public List<Customer> searchCustomers(String customerName) {

	    // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create Query
        Query<Customer> query;

        // only search if customerName is not empty
        if (customerName != null && customerName.trim().length() > 0) {
            // if customer name not equal null and not empty then create a query that return relevant customers list by customer name
            // search for firstName or lastName ... case insensitive
            query = currentSession.createQuery(
                    "from Customer where lower(firstName) like :name or " +
                            "lower(lastName) like :name order by id", Customer.class);

            query.setParameter("name", customerName);
        } else {
            query = currentSession.createQuery("from Customer order by id", Customer.class);
        }

        // execute the query
        List<Customer> resultList = query.getResultList();

        // return the list of customers
        return resultList;
    }
}











