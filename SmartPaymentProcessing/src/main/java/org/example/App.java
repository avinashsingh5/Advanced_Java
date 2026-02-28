package org.example;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentProcessor processor = context.getBean(PaymentProcessor.class);
        processor.makePayment(5000);

        context.close(); // triggers @PreDestroy
    }
}
