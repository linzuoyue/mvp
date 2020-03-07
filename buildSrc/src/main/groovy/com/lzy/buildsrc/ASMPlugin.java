package com.lzy.buildsrc;


import com.android.build.gradle.AppExtension;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;


/**
 * ASM 插件 <br/>
 *
 * @author 林佐跃 <br/>
 * @since V 1.1 <br/>
 */
public class ASMPlugin implements Plugin<Project> {

    @Override
    public void apply(@NotNull Project project) {

        System.out.println("======================");
        System.out.println("Hello ASM Plugin!!!");
        System.out.println("======================");


        // AppExtension就是build.gradle中android{...}这一块
        AppExtension android = project.getExtensions().getByType(AppExtension.class);

        android.registerTransform(new ASMTransform());


    }
}
