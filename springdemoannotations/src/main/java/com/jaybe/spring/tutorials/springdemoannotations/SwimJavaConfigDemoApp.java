package com.jaybe.spring.tutorials.springdemoannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        try (// load spring config file
             AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(SportConfig.class)){

            // retrieve bean from spring container
            Coach theCoach = context.getBean("swimCoach", Coach.class);

            // use bean methods
            System.out.println(theCoach.getDailyWorkout());
            System.out.println(theCoach.getDailyFortune());
        }

    }
}
