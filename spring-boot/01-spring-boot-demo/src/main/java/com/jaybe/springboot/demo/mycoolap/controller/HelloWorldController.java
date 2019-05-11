package com.jaybe.springboot.demo.mycoolap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloWorldController {

    // expose "/" that return "Hello World" page

    @GetMapping(path = "/")
    public String helloWorld() {
        return "Hello world!!! ... Server time is: " + LocalDateTime.now();
    }

}
