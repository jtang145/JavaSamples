package com.jerometang.javaee.bytecode.asm.inst.updateBytecode;

import com.jerometang.javaee.bytecode.asm.inst.AsmUtils;
import com.jerometang.javaee.utils.*;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;

/**
 * Created by jtang on 5/11/2017.
 */
public class DefaultMethodInstrumentor {
    private final static java.lang.reflect.Method METHOD_ENTER_CALLBACK = ReflectionUtils.findMethod(DefaultMethodCallbacks.class, "methodEnterCallback");

    public static boolean instrumentMethod(ClassNode classNode, MethodNode methodNode, int methodIndex){
        boolean modified = false;

        modified |= insertHeader(classNode, methodNode, METHOD_ENTER_CALLBACK, methodIndex);

        return modified;
    }

    private static boolean insertHeader(ClassNode classNode, MethodNode methodNode, java.lang.reflect.Method entryCallback, int methodIndex) {
        String methodName = classNode.name.replace('/','.') + "." +  methodNode.name + methodNode.desc;
        InsnList methodHeader = new InsnList();

        methodHeader.add(new LdcInsnNode(methodName)); //push a constant # onto stack
        methodHeader.add(AsmUtils.getMethodInsnNode(Opcodes.INVOKESTATIC, entryCallback));
        return AsmUtils.insertCodeBeforeStart(methodNode, methodHeader);
    }
}
