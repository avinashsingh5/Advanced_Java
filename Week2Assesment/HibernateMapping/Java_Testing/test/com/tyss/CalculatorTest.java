package com.tyss;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest {

    Calculator c;

    @BeforeEach
    void setup(){
        c = new Calculator();
    }

    @BeforeAll
    static void init() {
        System.out.println("Runs once before all tests");
    }

    @AfterEach
    void cleanup() {
        c = null;
    }



    @Test
    void add() {
        assertEquals(5, c.add(2, 3));
    }

    @Test
    void subtract(){
        assertEquals(2,c.sub(5,3));
    }

    @Test
    void testNotEqual() {
        assertNotEquals(6, c.add(2,3));
    }

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "5,7,12",
            "200,100,300",
            "120,150,270"
    })
    public void testParameterized(int a, int b, int expected){
        Assertions.assertEquals(expected, c.add(a,b));
    }

    @ParameterizedTest
    @CsvSource({
            "8,5,3",
            "12,8,4",
            "10,22,-12"
    })
    void testParameterizedSub(int a, int b, int expected){
        Assertions.assertEquals(expected,c.sub(a,b));
    }

    @ParameterizedTest
    @CsvSource({
            "3, false",
            "4, true",
            "8, true"

    })
    void testParameterizedEven(int a, boolean expected){
        Assertions.assertEquals(expected,c.even(a));
    }

    @ParameterizedTest
    @CsvFileSource(files = "test/test-data/add.csv", numLinesToSkip = 1)
    public  void simpleAddTest(int a , int b, int expected){
        System.out.println("Simple @CsvFileSource test: "+ a+" + "+b+" = "+expected);
        Assertions.assertEquals(expected, c.add(a,b));
    }




}
