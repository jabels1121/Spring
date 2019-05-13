package com.jaybe.aopdemo.demo;

import com.jaybe.aopdemo.config.AppConfig;
import com.jaybe.aopdemo.service.FortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static Logger myLogger =
            Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config from AppConfig.class and create context
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // get bean from container
        FortuneService fortuneService = context.getBean(FortuneService.class);

        // some business logic
        myLogger.info("\nMain program: " + AroundWithLoggerDemoApp.class.getName());
        myLogger.info("Calling getFortune()");
        String fortune = fortuneService.getFortune();

        myLogger.info("\nMy fortune is: " + fortune);
        myLogger.info("Finished");
        // close context
        context.close();

    }

}
