package org.example;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{
    public  void Drive(){
        System.out.println("Driving Bike");
    }
}
