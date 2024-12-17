package com.training.advancedJava.controller;


import com.training.advancedJava.service.IDependencyInjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring")
public class SpringController {

    private final IDependencyInjection dependencyInjection;

    @Autowired
    public SpringController(IDependencyInjection dependencyInjection){
        this.dependencyInjection=dependencyInjection;
    }

    @GetMapping("/DI")
    public String greet(@RequestParam String name){
        return dependencyInjection.greet(name);
    }
}
