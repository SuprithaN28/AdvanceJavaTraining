package com.training.advancedJava.controller;


import com.training.advancedJava.exceptions.CustomExceptions;
import com.training.advancedJava.service.IConcurrencyAndMultithreading;
import com.training.advancedJava.service.IDesignpatterns;
import com.training.advancedJava.service.IJavaBasics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class JavaBasicsController {

    @Autowired
    IJavaBasics javaBasics;

    @Autowired
    IConcurrencyAndMultithreading concurrencyAndMultithreading;

    @Autowired
    IDesignpatterns designpatterns;


    @GetMapping("/javaBasics")
    public void basicsController() throws CustomExceptions {
        javaBasics.genericsAndCollections();
        javaBasics.customExceptionHandling();
        javaBasics.java8Features();
        javaBasics.garbageCollection();
    }

    @GetMapping("/multiThreading")
    public void multiThreading() throws InterruptedException {
        concurrencyAndMultithreading.mutliThreadingProgram();
        concurrencyAndMultithreading.executorsAndThreadPool();
        concurrencyAndMultithreading.forkAndJoin();
        concurrencyAndMultithreading.virtualThreads();
        concurrencyAndMultithreading.bestPracticeForCuncurrentCode();
    }

    @GetMapping("/designPattern")
    public void designPattern(){
        designpatterns.singletonInstance();
        designpatterns.factorypattern();
    }
}
