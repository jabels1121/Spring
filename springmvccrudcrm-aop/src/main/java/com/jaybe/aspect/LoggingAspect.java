package com.jaybe.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect extends PointCutExpressions {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());


    // add @Before advice
    @Before("serviceDaoControllerPointCut()")
    public void beforeLoggingAdvice(JoinPoint joinPoint) {
        // display method we are calling
        String methodName = joinPoint.getSignature().toShortString();
        myLogger.info("======>>>>> @Before advice calling on the method: " + methodName);

        // display the arguments to the method if they greater than 0
        if (joinPoint.getArgs().length > 0 && !(joinPoint.getArgs()[0] instanceof Model)) {
            // get the arguments
            Object[] args = joinPoint.getArgs();

            // loop through array of args an log them
            for (Object o :
                    args) {
                myLogger.info("====>>>> argument: " + o);
            }
        } else {
            myLogger.info("====>>>> above method called without args///");
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
        pointcut = "serviceDaoControllerPointCut()",
        returning = "result")
    public void afterLoggingAdvice(JoinPoint joinPoint, Object result) {

        // display method we are returning from
        String methodName = joinPoint.getSignature().toShortString();
        myLogger.info("======>>>>> @AfterReturning advice calling on the method: " + methodName);

        // display data returned
        myLogger.info("======>>>> result is: " + result);
    }

}
