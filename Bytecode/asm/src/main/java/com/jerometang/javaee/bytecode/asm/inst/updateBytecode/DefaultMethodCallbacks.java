package com.jerometang.javaee.bytecode.asm.inst.updateBytecode;

/**
 * Created by jtang on 5/11/2017.
 */
public class DefaultMethodCallbacks {

    public static void methodEnterCallback(String methodName){
        try{
            System.out.println("Entering method: " + methodName);
        }catch (Exception e){
            System.out.println("Execution enter method callback failed.");
        }
    }
}
