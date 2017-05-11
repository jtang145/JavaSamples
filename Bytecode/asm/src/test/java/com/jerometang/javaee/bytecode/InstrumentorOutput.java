package com.jerometang.javaee.bytecode;

import com.jerometang.javaee.bytecode.asm.inst.updateClassWriter.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by jtang on 5/8/2017.
 */
public class InstrumentorOutput {
    public static void main(final String args[]) throws Exception {
        FileInputStream is = new FileInputStream(args[0]);

        ClassReader cr = new ClassReader(is);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        ClassAdapter inst = new ClassAdapter(cw);
        cr.accept(inst, 0);

        FileOutputStream fos = new FileOutputStream(args[1]);
        fos.write(cw.toByteArray());
        fos.close();

    }
}
