package com.jaybe.aopdemo.demo;

import com.jaybe.aopdemo.DAO.AccountDAO;
import com.jaybe.aopdemo.config.Account;
import com.jaybe.aopdemo.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    public static void main(String[] args) {

        // read spring config from AppConfig.class and create context
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // get bean from container
        AccountDAO accountDAO = context.getBean(AccountDAO.class);

        // some business logic
        // call findAccounts() method
        List<Account> accounts = null;
        try {
            boolean tripWire = false;
            accounts = accountDAO.findAccounts(tripWire);
        }catch (Exception e) {
            System.out.println("\n\nMain Program ...  caught exception: " + e);
        }

        // close context
        context.close();

    }

}
