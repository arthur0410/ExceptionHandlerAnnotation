package com.example.exceptionhandler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlerAspect {
    @Pointcut("@annotation(com.example.exceptionhandler.Handled)")
    public void handledMethods() {
    }

    @AfterThrowing(pointcut = "handledMethods()", throwing = "ex")
    public void handleTheException(Exception ex) {
        // Do something useful
        System.out.println("CHEGOU NO EXCEPTION HANDLER");
    }

    @Around("@annotation(com.example.exceptionhandler.Handled)")
    public Object intercept(ProceedingJoinPoint thisJoinPoint) {
        try {
            return thisJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("SÓ PRINTOU EXCEPTION");
            return null;
        }
    }
}
