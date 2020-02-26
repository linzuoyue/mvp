//package com.lzy.apt_processor;
//
//import com.alibaba.android.arouter.facade.annotation.Route;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.annotation.processing.AbstractProcessor;
//import javax.annotation.processing.ProcessingEnvironment;
//import javax.annotation.processing.RoundEnvironment;
//import javax.lang.model.element.Element;
//import javax.lang.model.element.TypeElement;
//import javax.lang.model.util.Elements;
//
///**
// * ARouter View Path 自动生成 <br/>
// *
// * @author 林佐跃 <br/>
// * @since V 1.0 <br/>
// */
//public class ViewPathProcessor extends AbstractProcessor {
//
//    private Elements elementUtils;
//
//    @Override
//    public synchronized void init(ProcessingEnvironment processingEnv) {
//        super.init(processingEnv);
//        elementUtils = processingEnv.getElementUtils();
//    }
//
//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        Set<String> hashSet = new HashSet<>();
//        hashSet.add(Route.class.getCanonicalName());
//        return hashSet;
//    }
//
//    @Override
//    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
//        Set<? extends Element> elementSet = roundEnvironment.getElementsAnnotatedWith(Route.class);
//        List<TypeElement> typeElementList = new ArrayList<>();
//        for (Element element : elementSet) {
//           if (element instanceof TypeElement) {
//               typeElementList.add((TypeElement) element);
//           }
//        }
//
//        return true;
//    }
//}
