package com.jaybe.aopdemo.demo;

import com.jaybe.aopdemo.config.AppConfig;
import com.jaybe.aopdemo.service.FortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {

        // read spring config from AppConfig.class and create context
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // get bean from container
        FortuneService fortuneService = context.getBean(FortuneService.class);

        // some business logic
        System.out.println("\nMain program: AroundDemoApp");
        System.out.println("Calling getFortune()");
        String fortune = fortuneService.getFortune();

        System.out.println("\nMy fortune is: " + fortune);
        System.out.println("Finished");
        // close context
        context.close();

    }

}
