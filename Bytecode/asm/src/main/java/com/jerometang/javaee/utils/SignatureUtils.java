package com.jerometang.javaee.utils;

/**
 * Created by jtang on 5/11/2017.
 */
public class SignatureUtils {

    public static String getMethodSignature(java.lang.reflect.Method method) {
        return getMethodSignature(getFullyQualifiedMethod(method));
    }

    public static String getMethodSignature(String fullyQualifiedMethod) {
        try {
            return fullyQualifiedMethod.substring(
                    fullyQualifiedMethod.indexOf('('));
        } catch (RuntimeException e) {
            return null;
        }
    }

    public static String getFullyQualifiedMethod(java.lang.reflect.Method method) {
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String signature = getSignature(method);

        return getFullyQualifiedMethod(className, methodName, signature);
    }

    public static String getFullyQualifiedMethod(String className, String
            methodName, String signature)
    {
        assert className.indexOf('(') < 0 && className.indexOf(')') < 0 :
                "Invalid characters in class name: " + className;
        assert methodName.indexOf('(') < 0 && methodName.indexOf(')') < 0 :
                "Invalid characters in method name: " + methodName;

        StringBuffer sb = new StringBuffer(className);
        sb.append('.').append(methodName).append(signature);
        return sb.toString();
    }

    public static String getSignature(java.lang.reflect.Method method) {
        return getSignature(method.getParameterTypes(), method.getReturnType());
    }

    public static String getSignature(Class[] paramList, Class returnType) {
        StringBuffer buf = new StringBuffer();
        buf.append('(');
        for (int i=0; i<paramList.length; ++i) {
            buf.append(getSigForm(paramList[i]));
        }
        buf.append(')');
        buf.append(getSigForm(returnType));

        return buf.toString();
    }

    public static String getSigForm(java.lang.Class clazz) {
        if (clazz != Void.TYPE) {
            String arrayform = java.lang.reflect.Array.
                    newInstance(clazz, 0).getClass().getName();
            return arrayform.substring(1).replace('.','/');
        } else {
            // Arg! We can't create zero-length arrays of type void. Stupid java.
            // :)
            return "V";
        }
    }
}
