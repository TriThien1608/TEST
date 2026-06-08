package com.demo.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(10, 20);
        
        System.out.println("Testing add(10, 20) = " + result);
        Assert.assertEquals(result, 30, "Tổng của 10 và 20 phải bằng 30");
    }
}
