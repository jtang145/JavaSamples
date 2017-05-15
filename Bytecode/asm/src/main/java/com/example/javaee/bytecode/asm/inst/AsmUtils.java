package com.example.javaee.bytecode.asm.inst;

import com.example.javaee.utils.SignatureUtils;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Iterator;

/**
 * Created by jtang on 5/11/2017.
 */
public class AsmUtils {
    public static final String ATTRIBUTE_NAME_LVTT = "LocalVariableTypeTable";

    public static ClassNode getAsmClassRep(String className, byte[] bytes){
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept(classNode, ClassReader.SKIP_FRAMES);
        return classNode;
    }

    public static MethodInsnNode getMethodInsnNode(int opcode, java.lang.reflect.Method method){
        String owner = method.getDeclaringClass().getName().replace('.','/');
        String name = method.getName();
        String desc = SignatureUtils.getMethodSignature(method);
        boolean isInterface = opcode == Opcodes.INVOKEINTERFACE;
        return new MethodInsnNode(opcode,owner, name, desc, isInterface);
    }

    public static boolean insertCodeBeforeStart(MethodNode methodNode, InsnList methodHeader) {
        methodNode.instructions.insert(methodHeader);
        return true;
    }

    public static byte[] getAsmClassBytes(ClassNode classNode, ClassLoader loader) {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }

    public static boolean removeLvttAttributes(String name, MethodNode methodNode) {
        if (methodNode.attrs == null) {
            return false;
        }
        // Remove LVTT attributes if there are any because our
        // instrumentation breaks them. See also PR#45397.
        // This should be equivalent to compiling the method *without*
        // the "-g:vars" javac option.
        // This is a hold-over from older instrumentation - not sure if it's
        // required with ASM.
        Iterator iter = methodNode.attrs.iterator();
        while (iter.hasNext()) {
            Attribute attr = (Attribute) iter.next();
            if (ATTRIBUTE_NAME_LVTT.equals(attr.type)) {
                    System.out.println("Removing LVTT attribute from method: " +
                            name + "." + methodNode.name + methodNode.desc);
                    iter.remove();
                    // there's just one LVTT attr per method
                    return true;
            }
        }
        return false;
    }
}
