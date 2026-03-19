package com.example.order_service.controller;


import com.example.order_service.dto.Order;
import com.example.order_service.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderProducer producer;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        producer.sendOrder(order);
        return "Order Sent!";
    }
}
