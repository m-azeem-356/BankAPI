package org.example.bankapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAPIApplication {

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(BankAPIApplication.class, args);
    }

}
