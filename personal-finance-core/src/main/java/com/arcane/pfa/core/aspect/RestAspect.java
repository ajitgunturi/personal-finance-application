package com.arcane.pfa.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RestAspect {

    @Around("serviceLayerExecution()")
    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        // Before
        Object[] objs = joinPoint.getArgs();
        log.info("Under method {}", joinPoint);
        for (int i=0; i<objs.length ; i++){
            log.info("Arg {} -> {}",i,objs[i].toString());
        }
        Object retVal = joinPoint.proceed();
        // After
        log.info("Returned {}", retVal.toString());
        return retVal;
    }

    @Pointcut("execution(* com.arcane.pfa.core.service.*.*(..))")
    public void serviceLayerExecution(){

    }

}
