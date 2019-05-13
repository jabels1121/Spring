package com.jaybe.aopdemo.DAO;

import com.jaybe.aopdemo.config.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account, boolean bool);

    List<Account> findAccounts(boolean tripWire);

    boolean doWork();
}
