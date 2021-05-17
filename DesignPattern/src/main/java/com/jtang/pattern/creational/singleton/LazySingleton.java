/*
 *  Copyright 2017 Quest Software Inc.
 *
 * ALL RIGHTS RESERVED.
 */

package com.jtang.pattern.creational.singleton;

/**
 * Created by jtang on 6/7/2017.
 */
public class LazySingleton {
    private volatile static LazySingleton instance = null;

    private LazySingleton(){}

    /*synchronized */public static LazySingleton getInstance(){
        if(instance == null){
            synchronized (LazySingleton.class) {
                if(instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
