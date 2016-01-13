package com.fyhack.DynamicProxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Proxy;

/**
 * ProxyAnnotation
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/1/13
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ProxyAnnotation {
    public Class getProxyClass();
}
