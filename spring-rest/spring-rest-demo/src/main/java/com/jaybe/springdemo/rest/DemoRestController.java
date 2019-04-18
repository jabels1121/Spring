package com.jaybe.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    private Logger logger = Logger.getLogger(getClass().getSimpleName());

    // add code for the "/hello" endpoint

    @GetMapping("/hello")
    public String sayHello() {
        logger.info(">>>> called from sayHello() method");

        return "Hello World!";
    }

}
