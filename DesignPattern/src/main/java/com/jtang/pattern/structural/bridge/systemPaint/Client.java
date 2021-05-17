package com.jtang.pattern.structural.bridge.systemPaint;

import com.jtang.pattern.structural.bridge.systemPaint.image.Image;
import com.jtang.pattern.structural.bridge.systemPaint.os.ImageImp;

/**
 * Created by jtang on 6/9/2017.
 */
public class Client {

    public static void main(String args[]){
        Image image = (Image)XMLUtil.getBean("config.xml", "image");
        ImageImp imp = (ImageImp)XMLUtil.getBean("config.xml","os");
        image.setImageImp(imp);
        image.parseFile("天龙八部");
    }
}
