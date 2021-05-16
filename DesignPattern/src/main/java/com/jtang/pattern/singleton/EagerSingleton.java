/*
 *  Copyright 2017 Quest Software Inc.
 *
 * ALL RIGHTS RESERVED.
 */

package com.jtang.pattern.singleton;

/**
 * Created by jtang on 6/7/2017.
 *
 * Shortcoming:
 * 1, not so efficient, create instance whether use or not
 * 2, more load time needed
 *
 */
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return instance;
    }
}
