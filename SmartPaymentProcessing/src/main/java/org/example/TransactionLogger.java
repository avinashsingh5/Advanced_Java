package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class TransactionLogger {

    public TransactionLogger() {
        System.out.println("TransactionLogger Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Logger initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Logger destroyed");
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
