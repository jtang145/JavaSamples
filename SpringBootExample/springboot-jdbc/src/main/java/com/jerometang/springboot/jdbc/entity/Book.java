package com.jerometang.springboot.jdbc.entity;

/**
 * Created by jtang on 7/13/2017.
 */
public class Book {
    private int id;

    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", price=" + price +
                "}";
    }
}
