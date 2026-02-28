package org.example;

import org.springframework.stereotype.Component;

@Component
public class Car implements  Vehicle{
    private  Tyre tyre;

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public  void Drive(){
        System.out.println("Car is running ");
    }
}
