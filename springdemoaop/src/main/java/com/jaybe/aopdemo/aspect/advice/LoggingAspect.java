package com.jaybe.aopdemo.aspect.advice;

import com.jaybe.aopdemo.aspect.pointCut.AspectPointCutExpressions;
import com.jaybe.aopdemo.config.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class LoggingAspect extends AspectPointCutExpressions {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    // add new advice for  @Around annotated methods run before and after the all methods matching with pointcut expression.
    @Around("execution(* com.jaybe.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String s = proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=======>>>> Executing @Around on method: " + s);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object proceed = null;

        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            // log the exception
            myLogger.warning(e.getMessage());

            // if we want re-throwing an exception after logged them then call next code bloc
            throw  e;

            // if we want to handle exception and return some message then call next code block
            // give user a custom message
            //proceed = "Major accident! But no worries, your private AOP helicopter is on the way!";
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        myLogger.info("\n=========>>> Duration is: " + duration / 1000.0 + " seconds");

        return proceed;
    }


    // add new advice for @After that called like finally block in try-catch.
    // method is regardless on the success or failure of the result of the called method
    @After("execution(* com.jaybe.aopdemo.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        // print out which method we are advising on
        String s = joinPoint.getSignature().toShortString();
        myLogger.info("\n=======>>>> Executing @After (finally) on method: " + s);

    }


    // add new advice for @AfterThrowing on the findAccounts method
    @AfterThrowing(
            pointcut = "execution(* com.jaybe.aopdemo.DAO.AccountDAO.findAccounts(..))",
            throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        // print out which method we are advising on
        String s = joinPoint.getSignature().toShortString();
        myLogger.info("\n=======>>>> Executing @AfterThrowing on method: " + s);

        // log the exception
        myLogger.info("\n=======>>>> The exception is: " + exc);
    }


    // add new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.jaybe.aopdemo.DAO.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out which method we are advising on
        String s = joinPoint.getSignature().toShortString();
        myLogger.info("\n=======>>>> Executing @AfterReturning on method: " + s);

        // print out the results of method call
        myLogger.info("\n=======>>>> result is: " + result);

        // let's post-process the data from result var

        // convert the account names to upper case
        if (!result.isEmpty()) {
            convertAccountNamesToUpperCase(result);
        }
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account account : result) {
            // get uppercase version of name
            String upperName = account.getName().toUpperCase();

            // update the name on the account
            account.setName(upperName);
        }
    }


    @Before("pointCutForDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        myLogger.info("======>>>>>> Executing @Before advice from: " + getClass());

        // display the method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        myLogger.info("Method: " + signature);

        // display the method arguments
        Object[] args = joinPoint.getArgs();

        for (Object o : args) {
            myLogger.info("Arg from called method: " + o.toString());
            if (o instanceof Account) {
                Account account = (Account) o;
                myLogger.info("Account name: " + account.getName());
                myLogger.info("Account level: " + account.getLevel());
            }
        }

    }

}
