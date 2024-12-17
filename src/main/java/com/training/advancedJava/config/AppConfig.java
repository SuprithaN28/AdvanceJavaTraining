package com.training.advancedJava.config;


import com.training.advancedJava.service.DependencyInjection;
import com.training.advancedJava.service.IDependencyInjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public IDependencyInjection dependencyInjection(){
        return new DependencyInjection();
    }
}
