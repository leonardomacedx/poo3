package com.ceub.poo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Poo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Poo3Application.class, args);
    }

}
