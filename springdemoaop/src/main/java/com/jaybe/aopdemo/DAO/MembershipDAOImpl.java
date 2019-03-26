package com.jaybe.aopdemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addAccount() {
        System.out.println("DOING SOME DB WORK FROM: " + getClass());
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " i'm going to sleep... ZZZzzz...");
    }

}
