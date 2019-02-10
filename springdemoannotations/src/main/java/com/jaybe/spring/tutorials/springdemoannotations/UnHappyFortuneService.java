package com.jaybe.spring.tutorials.springdemoannotations;

import org.springframework.stereotype.Component;

@Component
public class UnHappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "That is very bad day for you!";
    }

    @Override
    public String getFortuneTest() {
        return "Test unhappy fortune";
    }
}
