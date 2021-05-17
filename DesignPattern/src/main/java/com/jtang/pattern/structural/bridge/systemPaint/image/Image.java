/*
 *  Copyright 2017 Quest Software Inc.
 *
 * ALL RIGHTS RESERVED.
 */

package com.jtang.pattern.structural.bridge.systemPaint.image;

import com.jtang.pattern.structural.bridge.systemPaint.os.ImageImp;

/**
 * Created by jtang on 6/9/2017.
 */
abstract public class Image {
    protected ImageImp imp;

    public void setImageImp(ImageImp imp){
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}
