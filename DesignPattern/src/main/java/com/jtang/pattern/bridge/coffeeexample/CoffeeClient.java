package com.jtang.pattern.bridge.coffeeexample;

import com.jtang.pattern.bridge.coffeeexample.size.LargeCup;
import com.jtang.pattern.bridge.coffeeexample.taste.MilkAddition;

public class CoffeeClient {
    public static void main(String[] args) {
        RefinedCoffee myCoffee = new LargeCup(new MilkAddition());
        myCoffee.showOrderNo();
        myCoffee.orderCoffee(2);
    }
}
