package com.jaybe.aopdemo.aspect.advice;

import com.jaybe.aopdemo.aspect.pointCut.AspectPointCutExpressions;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AnalyticsAspect extends AspectPointCutExpressions {

    @Before("daoPackageNoGettersSettersPointCut()")
    public void analyticsAspect() {
        System.out.println("\n======>>>>>> Performing API analytics from: " + getClass());
    }

}
