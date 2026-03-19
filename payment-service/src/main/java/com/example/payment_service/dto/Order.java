package com.example.payment_service.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int orderId;
    private String name;
    private int amount;
}