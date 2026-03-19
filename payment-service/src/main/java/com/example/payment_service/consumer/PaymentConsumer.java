package com.example.payment_service.consumer;




import com.example.payment_service.dto.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @RabbitListener(queues = "payment_queue")
    public void processPayment(Order order) {
        System.out.println("Payment Done for Order: " + order.getOrderId());
    }
}