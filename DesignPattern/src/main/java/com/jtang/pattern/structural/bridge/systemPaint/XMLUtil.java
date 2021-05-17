package com.jtang.pattern.structural.bridge.systemPaint;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by jtang on 6/9/2017.
 */
public class XMLUtil {

    public static Object getBean(String path, String args){
        try{
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentFactory.newDocumentBuilder();
            Document document;
            document = builder.parse(XMLUtil.class.getResourceAsStream(path));
            NodeList nl = null;
            Node classNode = null;
            String className = null;

            if(args.equals("image")){
                classNode = document.getElementsByTagName("imageName").item(0).getFirstChild();
            }else if(args.equals("os")){
                classNode = document.getElementsByTagName("osName").item(0).getFirstChild();
            }
            className = classNode.getNodeValue();

            Class clazz = Class.forName(className);
            Object object = clazz.newInstance();
            return object;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
