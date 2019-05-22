package com.jaybe.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {

    @GetMapping(path = "/hello")
    public String getServerTime(Model model) {

        model.addAttribute("theDate", new Date());

        return "helloworld";
    }

}
