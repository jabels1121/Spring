package com.jaybe.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExpressions {

    @Pointcut("execution(* com.jaybe.controller.*.*(..))")
    private void controllerPackagePointCut() {}

    @Pointcut("execution(* com.jaybe.DAO.*.*(..))")
    private void daoPackagePointCut() {}

    @Pointcut("execution(* com.jaybe.service.*.*(..))")
    private void servicePackagePointCut() {}

    @Pointcut("controllerPackagePointCut() || daoPackagePointCut() || servicePackagePointCut()")
    protected void serviceDaoControllerPointCut() {}

}
