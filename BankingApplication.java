package com.valbonet.spring.springboot.server.banking;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
public class BankingApplication {
 
    public BankingApplication(){
        //For Spring
    }
 
    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }
}