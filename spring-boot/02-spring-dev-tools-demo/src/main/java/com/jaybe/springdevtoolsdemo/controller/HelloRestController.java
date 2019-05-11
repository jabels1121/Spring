package com.jaybe.springdevtoolsdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!!! ... Server time is - " + LocalDateTime.now();
    }

    @GetMapping("/test")
    public String test() {
        return "Test-!!!";
    }

    @PostMapping(path = "/silly", consumes = "application/json", produces = "application/json")
    public ResponseEntity getSilly() {
        Map<String, String> body = new HashMap<>();
        body.put("param1", "value1");
        body.put("param2", "value1");
        body.put("param$", "value3");
        return new ResponseEntity(body, HttpStatus.OK);
    }

    @PostMapping("/testing")
    public String testingPostMapping() {
        return "TESTSTSTSTSTST";
    }

}
