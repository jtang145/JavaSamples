package com.example.javaee.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jtang on 5/11/2017.
 */
public class ReflectionUtils {
    public static Method findMethod(Class clazz, String methodName){
        List methods = findMethods(clazz, methodName, true);

        if(methods.size() == 1){
            return (Method)methods.get(0);
        }

        throw new IllegalArgumentException("Multiple methods found for " + clazz.getName() + "." + methodName + ":" + methods);
    }

    private static List findMethods(Class clazz, String methodName, boolean publicOnly) {
        ArrayList result = new ArrayList();
        Method[] methods;
        if(publicOnly){
            methods = clazz.getMethods();
        }else{
            methods = clazz.getDeclaredMethods();
        }
        for(int i=0; i < methods.length; i++){
            if(methods[i].getName().equals(methodName) && methods[i].getDeclaringClass() == clazz){
                result.add(methods[i]);
            }
        }
        return result;
    }
}
