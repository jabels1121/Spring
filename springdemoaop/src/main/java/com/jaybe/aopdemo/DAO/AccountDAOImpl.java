package com.jaybe.aopdemo.DAO;

import com.jaybe.aopdemo.config.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean bool) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADD!");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": do some work");

        return false;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purpose ... simulate the exception for @AfterThrowing advice
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> accounts = new ArrayList<>();
        // create sample accounts
        Account account1 = new Account("Bob", "Gold");
        Account account2 = new Account("Silly", "Bronze");
        Account account3 = new Account("Madhu", "Platinum");

        // add created accounts to list
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
