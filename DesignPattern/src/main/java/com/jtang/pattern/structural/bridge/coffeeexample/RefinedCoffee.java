package com.jtang.pattern.structural.bridge.coffeeexample;

import java.util.Random;

abstract public class RefinedCoffee extends Coffee {
    public RefinedCoffee(ICoffeeAddition addition) {
        super(addition);
    }

    public void showOrderNo(){
        Random random = new Random();
        System.out.println(String.format("Your order number is : RX%s", random.nextInt()));
    }
}
