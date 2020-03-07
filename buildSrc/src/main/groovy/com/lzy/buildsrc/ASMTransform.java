package com.lzy.buildsrc;

import com.android.build.api.transform.DirectoryInput;
import com.android.build.api.transform.Format;
import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Transform;
import com.android.build.api.transform.TransformException;
import com.android.build.api.transform.TransformInput;
import com.android.build.api.transform.TransformInvocation;
import com.android.build.api.transform.TransformOutputProvider;
import com.android.build.gradle.internal.pipeline.TransformManager;

import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

/**
 * ASM 的transform <br/>
 *
 * @author 林佐跃 <br/>
 * @since V 1.1 <br/>
 */
public class ASMTransform extends Transform {

    @Override
    public String getName() {
        return "ASMTransform";
    }

    @Override
    public Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS;
    }

    @Override
    public Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT;
    }

    @Override
    public boolean isIncremental() {
        return true;
    }

    @Override
    public void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        super.transform(transformInvocation);

        System.out.println("===== ASM Transform start =====");

        Collection<TransformInput> inputs = transformInvocation.getInputs();

        TransformOutputProvider outputProvider = transformInvocation.getOutputProvider();

        for (TransformInput input : inputs) {
            Collection<DirectoryInput> directoryInputs = input.getDirectoryInputs();

            for (DirectoryInput directoryInput : directoryInputs) {
                File dest = outputProvider.getContentLocation(directoryInput.getName()
                        , directoryInput.getContentTypes(), directoryInput.getScopes(), Format.DIRECTORY);

                //将修改过的字节码copy到dest，就可以实现编译期间干预字节码的目的了
                //FileUtils.copyDirectory(directoryInput.getFile(), dest)
                transformDir(directoryInput.getFile(), dest);
            }
        }

        System.out.println("===== ASM Transform end =====");
    }

    private static void transformDir(File input, File dest) throws IOException {
        if (dest.exists()) {
            FileUtils.forceDelete(dest);
        }
        FileUtils.forceMkdir(dest);
        String srcDirPath = input.getAbsolutePath();
        String destDirPath = dest.getAbsolutePath();
//        System.out.println("=== transform dir = " + srcDirPath + ", " + destDirPath);
        File[] files = input.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            String destFilePath = file.getAbsolutePath().replace(srcDirPath, destDirPath);
            File destFile = new File(destFilePath);
            if (file.isDirectory()) {
                transformDir(file, destFile);
            } else if (file.isFile()) {
                FileUtils.touch(destFile);
                transformSingleFile(file, destFile);
            }
        }
    }
    private static void transformSingleFile(File input, File dest) {
//        System.out.println("=== transformSingleFile ===");
        weave(input.getAbsolutePath(), dest.getAbsolutePath());
    }

    private static void weave(String inputPath, String outputPath) {
        try {
            FileInputStream is = new FileInputStream(inputPath);
            ClassReader cr = new ClassReader(is);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            ASMClassVisitor adapter = new ASMClassVisitor(cw);
            cr.accept(adapter, ClassReader.EXPAND_FRAMES);
            FileOutputStream fos = new FileOutputStream(outputPath);
            fos.write(cw.toByteArray());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
