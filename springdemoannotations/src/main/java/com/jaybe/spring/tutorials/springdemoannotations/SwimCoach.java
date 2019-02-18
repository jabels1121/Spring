package com.jaybe.spring.tutorials.springdemoannotations;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;
    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    public SwimCoach(FortuneService fortuneService) {
        System.out.println(">> SwimCoach: inside constructor");
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @PostConstruct
    private void doMyStartupStuff() {
        System.out.println(">> SwimCoach: inside  doMyStartupStuff()");
    }

    @PreDestroy
    private void doMyCleanupStuff() {
        System.out.println(">> SwimCoach: inside  doMyCleanupStuff()");
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
