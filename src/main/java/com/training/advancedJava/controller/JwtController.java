package com.training.advancedJava.controller;


import com.training.advancedJava.model.User;
import com.training.advancedJava.repository.UserRepository;
import com.training.advancedJava.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/projection/{role}")
    public List<UserRepository.UserProjection> getUserProjectionsByRole(@PathVariable String role) {
        return userRepository.findUserProjectionsByRole(role);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        System.out.println("username " + username);
        return JwtUtil.generateToken(username);
    }

    @GetMapping("/data")
    public List<User> getUsers(@RequestHeader("Authorization") String token) {
        if (JwtUtil.validateToken(token)) {
            return userRepository.findUser();
        }
        throw new RuntimeException("Invalid token");
    }
}
