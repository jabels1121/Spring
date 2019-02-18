package com.jaybe.spring.tutorials.springdemoannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        try (// load spring config file
             AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(SportConfig.class)){

            // retrieve bean from spring container
            SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

            // call a method on the bean
            System.out.println(theCoach.getDailyWorkout());
            System.out.println(theCoach.getDailyFortune());

            // call out swim coach methods ... has the props values injected from sport.properties file
            System.out.println(theCoach.getEmail());
            System.out.println(theCoach.getTeam());
        }

    }
}
