package com.training.advancedJava;

import com.training.advancedJava.service.ExecuteDI;
import com.training.advancedJava.service.IDependencyInjection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class AdvancedJavaApplication {

    public static void main(String[] args) {
		SpringApplication.run(AdvancedJavaApplication.class, args);

    }

}
