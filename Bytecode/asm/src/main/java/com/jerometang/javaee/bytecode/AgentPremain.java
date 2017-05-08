package com.jerometang.javaee.bytecode;

import java.lang.instrument.Instrumentation;

/**
 * Created by jtang on 5/8/2017.
 */
public class AgentPremain {
    public static void premain(String options, Instrumentation inst){
        System.out.println("Doing premain");
        inst.addTransformer(new TestClassTransformer());
    }
}
