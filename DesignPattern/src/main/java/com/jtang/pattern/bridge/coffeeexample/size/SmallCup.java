package com.jtang.pattern.bridge.coffeeexample.size;

import com.jtang.pattern.bridge.coffeeexample.ICoffeeAddition;
import com.jtang.pattern.bridge.coffeeexample.RefinedCoffee;

public class SmallCup extends RefinedCoffee {
    public SmallCup(ICoffeeAddition addition) {
        super(addition);
    }

    @Override
    public void orderCoffee(int count) {
        System.out.println(String.format("Ordered %s small cup with %s taste", count, getAddition().getName()));
    }
}
