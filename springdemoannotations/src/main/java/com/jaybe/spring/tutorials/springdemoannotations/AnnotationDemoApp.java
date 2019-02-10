package com.jaybe.spring.tutorials.springdemoannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        // create application context by reading spring config file
        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml")) {
            // get the bean from spring container
            Coach theCoach = context.getBean("tennisCoach", Coach.class);

            // call a method on the bean
            System.out.println(theCoach.getDailyWorkout());
            System.out.println(theCoach.getDailyFortune());
        } // closed context because them launched by "try with resources".
          // that means after try block all opened streams and others been closed.

    }

}
