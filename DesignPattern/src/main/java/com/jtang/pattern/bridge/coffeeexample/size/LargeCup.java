package com.jtang.pattern.bridge.coffeeexample.size;

import com.jtang.pattern.bridge.coffeeexample.ICoffeeAddition;
import com.jtang.pattern.bridge.coffeeexample.RefinedCoffee;

public class LargeCup extends RefinedCoffee {
    public LargeCup(ICoffeeAddition addition) {
        super(addition);
    }

    @Override
    public void orderCoffee(int count) {
        System.out.println(String.format("Ordered %s large cup with %s taste", count, getAddition().getName()));
    }
}
