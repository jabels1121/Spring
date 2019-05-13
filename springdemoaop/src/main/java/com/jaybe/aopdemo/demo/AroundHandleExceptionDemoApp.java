package com.jaybe.aopdemo.demo;

import com.jaybe.aopdemo.config.AppConfig;
import com.jaybe.aopdemo.service.FortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger myLogger =
            Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config from AppConfig.class and create context
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // get bean from container
        FortuneService fortuneService = context.getBean(FortuneService.class);

        // some business logic
        myLogger.info("\nMain program: " + AroundHandleExceptionDemoApp.class.getName());
        myLogger.info("Calling getFortune()");

        boolean tripWire = true;
        String fortune = fortuneService.getFortune(tripWire);

        myLogger.info("\nMy fortune is: " + fortune);
        myLogger.info("Finished");
        // close context
        context.close();

    }

}
