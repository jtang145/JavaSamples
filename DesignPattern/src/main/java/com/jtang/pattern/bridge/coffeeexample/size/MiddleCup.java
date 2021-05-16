package com.jtang.pattern.bridge.coffeeexample.size;

import com.jtang.pattern.bridge.coffeeexample.ICoffeeAddition;
import com.jtang.pattern.bridge.coffeeexample.RefinedCoffee;

public class MiddleCup extends RefinedCoffee {
    public MiddleCup(ICoffeeAddition addition) {
        super(addition);
    }

    @Override
    public void orderCoffee(int count) {
        System.out.println(String.format("Ordered %s middle cup with %s taste", count, getAddition().getName()));
    }
}
