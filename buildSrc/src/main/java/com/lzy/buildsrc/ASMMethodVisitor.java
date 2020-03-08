package com.lzy.buildsrc;


import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.commons.Method;

/**
 * TODO <br/>
 *
 * @author 林佐跃 <br/>
 * @since V 1.1 <br/>
 */
public class ASMMethodVisitor extends AdviceAdapter {

    private boolean hasAnnotation;

    protected ASMMethodVisitor(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
        super(api, methodVisitor, access, name, descriptor);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (descriptor.equalsIgnoreCase("Lcom/lzy/apt_annotation/TestMethod2;")) {
            hasAnnotation = true;
        }
        return super.visitAnnotation(descriptor, visible);
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        if (!hasAnnotation) {
            return;
        }
        getStatic(Type.getType("Ljava/lang/System "), "out", Type.getType("Ljava/io/PrintStream;"));
        visitLdcInsn("1234");
        invokeVirtual(Type.getType("Ljava/io/PrintStream "), new Method("println", "(Ljava/lang/String;)V"));
    }
}
