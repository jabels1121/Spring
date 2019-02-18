package com.jaybe.spring.tutorials.springdemoannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        try (// load spring config file
             ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")){

            // retrieve bean from spring container
            Coach tennisCoach = context.getBean("tennisCoach", Coach.class);

            Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

            // check if they are the same
            boolean result = (tennisCoach == alphaCoach);

            System.out.println("\nPointing to the same object: " + result);
            System.out.println("\nMemory location for the theCoach: " + tennisCoach);
            System.out.println("\nMemory location for the alphaCoach: " + alphaCoach + "\n");
        }

    }
}
