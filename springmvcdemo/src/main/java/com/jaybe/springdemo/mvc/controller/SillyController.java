package com.jaybe.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class SillyController {

    @RequestMapping("/showForm")
    public String displayTheForm() {
        return "silly";
    }

}
