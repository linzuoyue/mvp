package com.lzy.apt_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO <br/>
 *
 * @author 林佐跃 <br/>
 * @since V TODO <br/>
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface TestMethod2 {

    String value() default "test";
}
