package com.training.advancedJava.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(crsf -> crsf.disable()).authorizeHttpRequests(auth -> auth
                .requestMatchers("/**").permitAll().anyRequest().authenticated());
        //    .httpBasic(httpBasicCustomizer -> httpBasicCustomizer.realmName("MyApp"));
        return http.build();
    }
}
