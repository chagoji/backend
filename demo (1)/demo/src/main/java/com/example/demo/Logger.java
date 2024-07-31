package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Logger implements CommandLineRunner {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("JWT Secret: " + jwtSecret);
    }
}