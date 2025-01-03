package com.training.advancedJava;

import com.training.advancedJava.model.User;
import com.training.advancedJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.training.advancedJava")
@EntityScan(basePackages = "com.training.advancedJava")
@EnableEurekaServer
public class AdvancedJavaApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(AdvancedJavaApplication.class, args);

    }

    @Override
    public void run(String... args) {
        User admin = new User();
        admin.setUsername("admin");
        admin.setEmail("admin@google.com");
        admin.setRole("ADMIN");

        User user = new User();
        user.setUsername("user");
        user.setEmail("user@google.com");
        user.setRole("USER");

        userRepository.save(admin);
        userRepository.save(user);

        System.out.println("Initial data loaded..!");
    }

}
