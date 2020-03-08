package com.lzy.buildsrc;


import com.android.build.gradle.LibraryExtension;
import com.android.build.gradle.internal.pipeline.TransformManager;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;


/**
 * ASM 插件 <br/>
 *
 * @author 林佐跃 <br/>
 * @since V 1.1 <br/>
 */
public class ASMLibraryPlugin implements Plugin<Project> {

    @Override
    public void apply(@NotNull Project project) {

        System.out.println("======================");
        System.out.println("Hello ASM Plugin!!!");
        System.out.println("======================");


        // AppExtension就是build.gradle中android{...}这一块

        LibraryExtension library = project.getExtensions().getByType(LibraryExtension.class);
        library.registerTransform(new ASMTransform(TransformManager.PROJECT_ONLY));


    }
}
