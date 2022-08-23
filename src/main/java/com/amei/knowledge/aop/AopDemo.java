package com.amei.knowledge.aop;

import com.amei.knowledge.annotion.BusinessType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopDemo {

    private Logger logger = LoggerFactory.getLogger(BusinessType.class);

    @Pointcut(value = "execution( * com.amei.knowledge.controller.BusinessTypeAspect.getLog())")
    public void myPointCut() {

    }

    @Around("myPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前 ");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后 ");
        return "hello";
    }

    @Before("myPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("进入 doBefore");
    }

    @After("myPointCut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("进入 doAfter");
    }

    @AfterReturning(returning = "ret", pointcut = "myPointCut()")
    public void doAfterReturning(Object ret) {
        System.out.println("进入 doAfterReturning");
    }

    @AfterThrowing(throwing = "exception", pointcut = "myPointCut()")
    public void doAfterThrowing(Exception exception) {
        System.out.println("进入 doAfterThrowing");
    }
}
