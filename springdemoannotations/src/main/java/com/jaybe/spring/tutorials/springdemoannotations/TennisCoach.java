package com.jaybe.spring.tutorials.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    /*@Qualifier("randomFortuneService")
    @Autowired // inject dependency by used field injection technique. Behind the scene used java Reflection mechanism.*/
    private FortuneService fortuneService;

    @Autowired // inject dependency by used class constructor
    public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
        System.out.println("TennisCoach: inside default constructor");
        this.fortuneService = fortuneService;
    }

    // define the init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside doMyStartupStuff()");
    }

    // define the destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside doMyCleanupStuff()");
    }

    /*@Autowired // inject dependency by used setter method
    public void setFortuneService(@Qualifier("unHappyFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
