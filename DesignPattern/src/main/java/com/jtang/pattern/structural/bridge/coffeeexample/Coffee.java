package com.jtang.pattern.structural.bridge.coffeeexample;

abstract public class Coffee {
    protected ICoffeeAddition addition;

    public Coffee(ICoffeeAddition addition) {
        this.addition = addition;
    }

    abstract public void orderCoffee(int count);

    public ICoffeeAddition getAddition() {
        return this.addition;
    }
}
