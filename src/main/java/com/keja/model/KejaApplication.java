package com.keja.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.keja.model")
@EnableJpaRepositories(basePackages = "com.keja.repository")
public class KejaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KejaApplication.class, args);
    }
}