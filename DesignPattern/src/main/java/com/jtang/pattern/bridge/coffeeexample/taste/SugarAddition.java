package com.jtang.pattern.bridge.coffeeexample.taste;

import com.jtang.pattern.bridge.coffeeexample.ICoffeeAddition;

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
