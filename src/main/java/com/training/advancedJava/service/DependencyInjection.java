package com.training.advancedJava.service;

public class DependencyInjection implements IDependencyInjection{
    @Override
    public String greet(String name) {
        return "Dependency Injection example : "+name;
    }
}
