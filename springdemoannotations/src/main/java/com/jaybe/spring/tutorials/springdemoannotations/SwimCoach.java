package com.jaybe.spring.tutorials.springdemoannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        System.out.println(">> SwimCoach: inside constructor");
        this.fortuneService = fortuneService;
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
