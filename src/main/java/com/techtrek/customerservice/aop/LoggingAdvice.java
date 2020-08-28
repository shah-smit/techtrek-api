package com.techtrek.customerservice.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAdvice {

    @Pointcut(value = "execution(* com.techtrek.customerservice.*.*.*(..) )")
    public void generalLoggingPointCut(){

    }

    @Around("generalLoggingPointCut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();

        Object[] args = proceedingJoinPoint.getArgs();

        log.info("Method Invoked {} in class {} with args {}", methodName, className, Arrays.toString(args));

        Object object = proceedingJoinPoint.proceed();

        log.info("Method {} return {}", methodName, object);

        return object;
    }
}
