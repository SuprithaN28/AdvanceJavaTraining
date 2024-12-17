package com.training.advancedJava.service;

import org.springframework.stereotype.Component;

@Component
public class ExecuteDI {

    private final IDependencyInjection dependencyInjection;

    public ExecuteDI(IDependencyInjection dependencyInjection){
        this.dependencyInjection=dependencyInjection;
    }

    public void execute(){
        dependencyInjection.greet(" Execute DI ");
    }
}
