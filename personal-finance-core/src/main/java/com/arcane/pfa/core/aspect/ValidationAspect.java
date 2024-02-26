package com.arcane.pfa.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ValidationAspect {

    @Before("@annotation(com.arcane.pfa.core.aspect.ValidateEmail))")
    public void validateEmailId(final JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String email = (String) args[0];
        if (email.isBlank()){
            throw new RuntimeException("Invalid Email Id");
        }else {
        }
    }


}
