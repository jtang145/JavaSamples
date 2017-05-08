package com.jerometang.javaee.bytecode;

/**
 * Created by jtang on 5/8/2017.
 */
public class TargetClassTester {
    public static void main(String[] args){
        printOne();
        printTwo();
    }

    public static void printOne() {
        System.out.println("Hello World");
    }

    public static void printTwo(){
        printOne();
        printOne();

    }
}
