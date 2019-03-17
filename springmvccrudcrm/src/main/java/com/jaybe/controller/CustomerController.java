package com.jaybe.controller;

import com.jaybe.entity.Customer;
import com.jaybe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        // get List of customers from the customer service
        List<Customer> customers = customerService.getCustomers();

        // add the customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/customerForm")
    public String addCustomerForm(Model model) {
        // create the customer object for add them to the Model
        Customer customer = new Customer();

        // add customer object to the Model for using them in HTML, our jsp page.
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        // Save the received customer using the customerService object
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        // get the customer from the database
        Customer customer = customerService.getCustomer(id);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);

        // send over to our form
        return "customer-form";
    }

    @RequestMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id) {
        // delete the customer using customerSerivce
        customerService.deleteCustomer(id);

        // return link to the list of customers after deleting the customer
        return "redirect:/customer/list";
    }

}
