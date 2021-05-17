package com.jtang.pattern.structural.bridge.coffeeexample.taste;

import com.jtang.pattern.structural.bridge.coffeeexample.ICoffeeAddition;

public class SugarAddition implements ICoffeeAddition {
    @Override
    public void supplement() {
        System.out.println("added sugar, enjoy it!");
    }

    @Override
    public String getName() {
        return "sugar";
    }
}
