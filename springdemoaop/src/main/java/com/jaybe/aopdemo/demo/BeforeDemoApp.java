package com.jaybe.aopdemo.demo;

import com.jaybe.aopdemo.DAO.AccountDAO;
import com.jaybe.aopdemo.DAO.AccountDAOl;
import com.jaybe.aopdemo.DAO.MembershipDAO;
import com.jaybe.aopdemo.config.Account;
import com.jaybe.aopdemo.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeforeDemoApp {

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
        MembershipDAO membershipDAOImpl = applicationContext.getBean(MembershipDAO.class);
        AccountDAOl accountDAOl = applicationContext.getBean("accountDAOl", AccountDAOl.class);

        // call the business method
        Account account = new Account();
        account.setName("Bob");
        account.setLevel("silver");
        accountDaoImpl.addAccount(account, true);
        System.out.println("\n=======================\n");
        accountDaoImpl.doWork();
        System.out.println("\n=======================\n");

        accountDAOl.setName("bombom");
        System.out.println("\n=======================\n");
        accountDAOl.setServiceCode("silver");
        System.out.println("\n=======================\n");
        accountDAOl.getName();
        System.out.println("\n=======================\n");
        accountDAOl.getServiceCode();
        System.out.println("\n=======================\n");
        membershipDAOImpl.addAccount();
        System.out.println("\n=======================\n");
        membershipDAOImpl.goToSleep();
        System.out.println("\n=======================\n");
        // close context
        applicationContext.close();
    }

}
