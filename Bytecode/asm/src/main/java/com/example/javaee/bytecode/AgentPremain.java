package com.example.javaee.bytecode;

import java.lang.instrument.Instrumentation;

/**
 * Created by jtang on 5/8/2017.
 */
public class AgentPremain {
    public static void premain(String options, Instrumentation inst){
        System.out.println("Doing premain");
        //Option 1: Do instrumentation by ASM Class Writer
//        inst.addTransformer(new TransformerWithClassWriter());
        //Option 2: Do instrumentation by bytecode manipulation
        inst.addTransformer(new TransformerWithInstrumentor());
    }
}
