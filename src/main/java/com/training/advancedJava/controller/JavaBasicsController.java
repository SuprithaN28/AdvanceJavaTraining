package com.training.advancedJava.controller;


import com.training.advancedJava.exceptions.CustomExceptions;
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


    @GetMapping("/javaBasics")
    public void basicsController() throws CustomExceptions {
        javaBasics.genericsAndCollections();
        javaBasics.customExceptionHandling();
        javaBasics.java8Features();
        javaBasics.garbageCollection();

    }

}
