package com.jaybe.spring.tutorials.springdemoannotations;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "That is your lucky day!";
    }

    @Override
    public String getFortuneTest() {
        return "Test Fortune";
    }
}
