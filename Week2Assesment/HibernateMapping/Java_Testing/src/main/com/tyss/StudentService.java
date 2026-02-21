package com.tyss;

public class StudentService {
    public  boolean isEligible(int age){
        if(age<0){
            throw new IllegalArgumentException("Age cannot be negative");
        }
        return age>=18;
    }
}
