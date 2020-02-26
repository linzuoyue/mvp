package com.lzy.apt_processor;

import com.google.auto.service.AutoService;
import com.lzy.apt_annotation.AutoAttach;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;

@AutoService(Processor.class)
public class PresenterAutoAttachProcessor extends AbstractProcessor {

    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> hashSet = new HashSet<>();
        hashSet.add(AutoAttach.class.getCanonicalName());
        return hashSet;
    }


    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<? extends Element> elementSet = roundEnvironment.getElementsAnnotatedWith(AutoAttach.class);
        Map<String, Map<TypeElement, List<VariableElement>>> packageElementMapHashMap = new HashMap<>();
        for (Element element : elementSet) {
            if (element instanceof VariableElement) {
                VariableElement variableElement = (VariableElement) element;
                TypeElement typeElement = (TypeElement) variableElement.getEnclosingElement();
                PackageElement packageElement = elementUtils.getPackageOf(typeElement);
                String packageName = packageElement.getQualifiedName().toString();
                Map<TypeElement, List<VariableElement>> typeElementMapHashMap = packageElementMapHashMap.get(packageName);
                if (typeElementMapHashMap == null) {
                    typeElementMapHashMap = new HashMap<>();
                    packageElementMapHashMap.put(packageName, typeElementMapHashMap);
                }
                List<VariableElement> variableElementList = typeElementMapHashMap.get(typeElement);
                if (variableElementList == null) {
                    variableElementList = new ArrayList<>();
                    typeElementMapHashMap.put(typeElement, variableElementList);
                }
                variableElementList.add(variableElement);
            }
        }
        for (String packageName : packageElementMapHashMap.keySet()) {
            Map<TypeElement, List<VariableElement>> typeElementListMap = packageElementMapHashMap.get(packageName);

            String className = "PresenterAutoAttach";
            JavaFile javaFile = JavaFile.builder(packageName, generateCodeByPoet(className, typeElementListMap)).build();

            try {
                javaFile.writeTo(processingEnv.getFiler());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    private TypeSpec generateCodeByPoet(String className, Map<TypeElement, List<VariableElement>> typeElementListMap) {
        TypeSpec.Builder builder = TypeSpec.classBuilder(className).addModifiers(Modifier.PUBLIC);
        for (TypeElement key : typeElementListMap.keySet()) {
            List<VariableElement> variableElementList = typeElementListMap.get(key);
            builder.addMethod(generateMethodByPoet(key, variableElementList));
        }
        return builder.build();
    }


    /**
     * 生成方法
     *
     * @param typeElement         注解对象上层元素对象，即 Activity 对象
     * @param variableElementList Activity 包含的注解对象以及注解的目标对象
     */
    private MethodSpec generateMethodByPoet(TypeElement typeElement, List<VariableElement> variableElementList) {
        ClassName className = ClassName.bestGuess(typeElement.getQualifiedName().toString());
        //方法参数名
        String parameter = "_" + className.simpleName().toLowerCase();
        MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("attach" + parameter)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(className, parameter);
        for (VariableElement variableElement : variableElementList) {
            //被注解的字段名
            String name = variableElement.getSimpleName().toString();
            String text = "{0}.mPresenterSets.addPresenter({0}.{1});\n";
            methodBuilder.addCode(MessageFormat.format(text, parameter, name));
        }
        methodBuilder.addCode(MessageFormat.format("{0}.mPresenterSets.attachView({0});\n", parameter));
        return methodBuilder.build();
    }


}
