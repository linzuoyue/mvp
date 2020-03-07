package com.lzy.buildsrc;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * 类访问 <br/>
 *
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public class ASMClassVisitor extends ClassVisitor {

    public ASMClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM7, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
        return new ASMMethodVisitor(Opcodes.ASM7, methodVisitor, access, name, descriptor);
    }

}
