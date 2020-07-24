package com.example.javaee.bytecode;

import com.example.javaee.bytecode.asm.inst.AsmUtils;
import com.example.javaee.bytecode.asm.inst.updateBytecode.DefaultMethodInstrumentor;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jtang on 5/10/2017.
 */
public class TransformerWithInstrumentor implements ClassFileTransformer {
    private static List<String> INSTRUMENT_CLASS_LIST = Arrays.asList("cn.naches.examples.javaee.bytecode.TargetClassTester");

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            ClassNode classNode = AsmUtils.getAsmClassRep(className, classfileBuffer);
            String dotClassName = classNode.name.replace('/', '.');
            byte[] updatedBytes;
            boolean updated = instrumentAsmClass(loader, classNode);
            if(updated){
                updatedBytes = AsmUtils.getAsmClassBytes(classNode, loader);
                return updatedBytes;
            }
            return classfileBuffer;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        return null;
    }

    private boolean instrumentAsmClass(ClassLoader loader, ClassNode classNode) {
        boolean modified = false;
        List<MethodNode> methods = classNode.methods;
        for(int i=0; i < methods.size(); i++){
            if(!INSTRUMENT_CLASS_LIST.contains(classNode.name.replace('/','.'))){
                return false;
            }
            boolean instrumented = DefaultMethodInstrumentor.instrumentMethod(classNode, methods.get(i), i);
            modified |= instrumented;
            if(instrumented){
                AsmUtils.removeLvttAttributes(classNode.name, methods.get(i));
            }
        }

        return modified;
    }
}
