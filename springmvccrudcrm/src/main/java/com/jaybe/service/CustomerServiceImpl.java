package com.jaybe.service;

import com.jaybe.DAO.CustomerDAO;
import com.jaybe.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    // need to inject customerDao because that customer service delegate the work with data to customerDAO
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional // Customer service manage the transaction instead customerDAO
    public List<Customer> getCustomers() {
        // delegate work with customer data to the customerDAO object
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        // delegate saving the customer to the customerDAO
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomer(customerId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        // delegate deleting the customer to the customerDAO impl
        customerDAO.deleteCustomer(customerId);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String customerName) {
        // delegate search the customers by name to the customerDAO
        return customerDAO.searchCustomers(customerName);
    }
}
