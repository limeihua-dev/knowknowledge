package com.amei.knowledge.aop;

import com.amei.knowledge.annotion.BusinessType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopDemo {

    private Logger logger = LoggerFactory.getLogger(BusinessType.class);

    @Pointcut(value = "execution( * com.amei.knowledge.controller.*.*(..))")
    public void myPointCut() {

    }

    @Around("myPointCut()")
    public Object myLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        //执行之前
        Object proceed = proceedingJoinPoint.proceed();
        //执行之后
        return null;
    }
}
