package com.jaybe.thymeleafcruddemo.controller;

import com.jaybe.thymeleafcruddemo.entity.Employee;
import com.jaybe.thymeleafcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for /GET list of employees
    @GetMapping(path = "/list")
    public String getAllEmployees(Model model) {
        // find all employees from repository
        List<Employee> allEmployees = employeeService.findAll();

        // add employees to the model
        model.addAttribute("employees", allEmployees);

        // return html with employees
        return "employees/employee_list";
    }

    // add mapping for /GET for show employee html form
    @GetMapping(path = "/addNewEmployeeForm")
    public String showEmployeeForm(Model model) {
        // create Employee object for model
        Employee employee = new Employee();

        // add employee object to the model
        model.addAttribute("employee", employee);

        return "employees/employee_form";
    }

    // add mapping for /POST for save new employee to db
    @PostMapping(path = "/save")
    public String saveNewEmployee(@ModelAttribute("employee") Employee employee) {
        // save to db retrieved employee
        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    // add mapping for /GET for update existing employee
    @GetMapping(path = "/update")
    public String updateExistingEmployee(@RequestParam int employeeId, Model model) {
        // get the employee by retrieved id
        var employee = employeeService.findById(employeeId);

        // add retrieved employee to the model attribute
        model.addAttribute("employee", employee);

        return "employees/employee_form";
    }

    // add mapping for /DELETE for deleting existing employee

}
