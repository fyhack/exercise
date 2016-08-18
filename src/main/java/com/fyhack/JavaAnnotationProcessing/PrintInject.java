package com.fyhack.JavaAnnotationProcessing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * PrintInject
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/18
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface PrintInject {
    int value();
}
