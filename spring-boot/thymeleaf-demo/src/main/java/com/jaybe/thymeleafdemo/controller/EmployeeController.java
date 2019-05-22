package com.jaybe.thymeleafdemo.controller;

import com.jaybe.thymeleafdemo.dao.EmployeeRepository;
import com.jaybe.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // add mapping for /GET list of employees
    @GetMapping(path = "/list")
    public String getAllEmployees(Model model) {
        // find all employees from repository
        List<Employee> allEmployees = employeeRepository.findAll();

        // add employees to the model
        model.addAttribute("employees", allEmployees);

        // return html with employees
        return "employee_list";
    }

}
