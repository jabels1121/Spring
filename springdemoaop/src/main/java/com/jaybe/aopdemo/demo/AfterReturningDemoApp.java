package com.jaybe.aopdemo.demo;

import com.jaybe.aopdemo.DAO.AccountDAO;
import com.jaybe.aopdemo.config.Account;
import com.jaybe.aopdemo.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        // Create target object: AccountDAO

        // Create Spring java config class

        // Create main app

        // Create an Aspect with @Before advice

        // read spring config from config class
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // get bean from spring container
        AccountDAO accountDaoImpl = applicationContext.getBean(AccountDAO.class);

        // call method to find the accounts

        /*List<Account> accounts = accountDaoImpl.findAccounts(tripWire);

        System.out.println("\n\nMain program: AfterReturningDemoApp");
        System.out.println("=========");
        System.out.println(accounts);
        System.out.println("\n");*/
        // close context
        applicationContext.close();
    }

}
