/*
 *  Copyright 2017 Quest Software Inc.
 *
 * ALL RIGHTS RESERVED.
 */

package com.jtang.pattern.bridge.systemPaint.os;

import com.jtang.pattern.bridge.systemPaint.image.Matrix;

/**
 * Created by jtang on 6/9/2017.
 */
public class WindowsImp implements ImageImp {
    @Override
    public void doPaint(Matrix matrix) {
        System.out.println("Paint in Windows");
    }
}
