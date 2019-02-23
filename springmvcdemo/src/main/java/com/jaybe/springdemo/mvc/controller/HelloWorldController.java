package com.jaybe.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

// 2. Add @Controller annotation
@Controller
// 1. Create Hello world controller
public class HelloWorldController {

    // 3. Need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // 4. Need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String shoutMessage(HttpServletRequest request, Model model) {
        // get parameter from request and assign them to variable
        String name = request.getParameter("studentName");

        // update retrieved parameter to uppercase
        name = name.toUpperCase();
        String result = "Yo! " + name;

        // assign updated parameter to the model object
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormV3")
    public String processFormV3(
            //get parameter from request and assign them to variable used Spring annotation @RequestParam
            @RequestParam("studentName")String name, Model model) {

        // update retrieved parameter to uppercase
        name = name.toUpperCase();
        String result = "Yo from v3! " + name;

        // assign updated parameter to the model object
        model.addAttribute("message", result);

        return "helloworld";
    }

}
