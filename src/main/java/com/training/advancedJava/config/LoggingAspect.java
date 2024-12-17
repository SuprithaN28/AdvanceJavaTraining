package com.training.advancedJava.config;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.training.advancedJava.service.IDependencyInjection.greet(..))")
    public void logBeforeGreeting(){
        System.out.println("Dependency example is about to be executed..");
    }
}
