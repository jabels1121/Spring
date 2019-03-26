package com.jaybe.aopdemo.demo;

import com.jaybe.aopdemo.DAO.AccountDAO;
import com.jaybe.aopdemo.config.Account;
import com.jaybe.aopdemo.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {

        // read spring config from AppConfig.class and create context
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // get beans from context
        AccountDAO accountDAO = context.getBean(AccountDAO.class);

        // do some business stuff
        // call method to find accounts
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        }catch (Exception e) {
            System.out.println("\n\nMain Program ...  caught exception: " + e);
        }

        // display the accounts
        System.out.println("\n\nMain program: AfterReturningDemoApp");
        System.out.println("=========");
        System.out.println(accounts);
        System.out.println("\n");


        // close context
        context.close();
    }

}
