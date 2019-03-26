package com.jaybe.aopdemo.aspect.advice;

import com.jaybe.aopdemo.aspect.pointCut.AspectPointCutExpressions;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DummyAspect extends AspectPointCutExpressions {

    @Before("daoPackageSettersPointCut() || daoPackageGettersPointCut()")
    public void dummyAspectExec() {
        System.out.println("======>>>>>> Perform from dummy Advice from: " + getClass());
    }

}
