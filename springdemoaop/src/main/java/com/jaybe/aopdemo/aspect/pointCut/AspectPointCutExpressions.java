package com.jaybe.aopdemo.aspect.pointCut;

import org.aspectj.lang.annotation.Pointcut;

public class AspectPointCutExpressions {

    @Pointcut("execution(* com.jaybe.aopdemo.DAO.*.*(..))")
    protected void pointCutForDaoPackage() {}

    @Pointcut("execution(* com.jaybe.aopdemo.DAO.*.get*(..))")
    protected void daoPackageGettersPointCut() {}

    @Pointcut("execution(* com.jaybe.aopdemo.DAO.*.set*(..))")
    protected void daoPackageSettersPointCut() {}

    @Pointcut("pointCutForDaoPackage() && !(daoPackageGettersPointCut() || daoPackageSettersPointCut())")
    protected void  daoPackageNoGettersSettersPointCut() {}
}
