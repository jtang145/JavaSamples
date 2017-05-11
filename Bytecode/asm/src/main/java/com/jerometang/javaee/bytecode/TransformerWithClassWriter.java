package com.jerometang.javaee.bytecode;

import com.jerometang.javaee.bytecode.asm.inst.updateClassWriter.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by jtang on 5/8/2017.
 */
public class TransformerWithClassWriter implements ClassFileTransformer{

    public byte[] transform(ClassLoader classLoader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        try{
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            ClassAdapter inst = new ClassAdapter(cw);
            cr.accept(inst, 0);

            return cw.toByteArray();
        }catch (Exception ex) {
            System.out.println("Class transform exception.");
        }
        return null;
    }
}
