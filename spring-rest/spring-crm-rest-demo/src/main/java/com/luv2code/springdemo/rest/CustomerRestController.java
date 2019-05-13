package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.exceptions.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private static final String CUSTOMER_NOT_FOUND = "Customer with id - %s doesn't exist";

    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers() {
        // get list of Customers
        return customerService.getCustomers();
    }

    @GetMapping(value = "/customers/{customerId}")
    public Customer getCustomerById(@PathVariable Integer customerId) {
        // validate customerId
        if (customerId <= 0) {
            throw new CustomerNotFoundException("Customer id must be greater than zero.");
        }

        // get Customer by retrieved customer id
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerId));
        }

        //  get the customer from service
        return customer;
    }

    // add mapping for POST /customers - add new customer
    @PostMapping(value = "/customers", consumes = "application/json")
    public Customer addCustomer(@RequestBody Customer customer) {
        // also just in case the pass an id in JSON ... set id to 0
        // this is force a save of new item ... instead of update
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }

    // add mapping for PUT /customers - update an existing customer
    @PutMapping(value = "/customers", consumes = "application/json")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);

        return customer;
    }

    // add mapping for DELETE /customers - delete an existing customer by id
    @DeleteMapping(value = "/customers/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId) {
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerId));
        }

        customerService.deleteCustomer(customerId);

        return "Deleted customer with id - " + customerId + ".";
    }

}
