package com.jtang.pattern.structural.bridge.coffeeexample.taste;

import com.jtang.pattern.structural.bridge.coffeeexample.ICoffeeAddition;

public class MilkAddition implements ICoffeeAddition {
    @Override
    public void supplement() {
        System.out.println("Added milk, enjoy it!");
    }

    @Override
    public String getName() {
        return "milk";
    }
}
