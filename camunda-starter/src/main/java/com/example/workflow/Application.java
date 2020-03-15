package com.example.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        String javaVersion = System.getProperty("java.specification.version");
        SpringApplication.run(Application.class);
    }



}