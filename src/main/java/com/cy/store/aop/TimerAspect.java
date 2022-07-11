package com.cy.store.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component // 将当前类的对象船舰维护交由spring维护
@Aspect // 标记为切面类
public class TimerAspect {
    // ProceedingJoinPoint： 表示连接点
    @Around("execution(* com.cy.store.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed(); //调用目标方法
        long end = System.currentTimeMillis();
        System.out.println("Cost:" + (end - start));
        return result;
    }
}
