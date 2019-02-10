package com.jaybe.spring.tutorials.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
public class TennisCoach implements Coach {

    @Qualifier("unHappyFortuneService")
    @Autowired // inject dependency by used field injection technique. Behind the scene used java Reflection mechanism.
    private FortuneService fortuneService;

    /*@Autowired // inject dependency by used class constructor
    public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

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
