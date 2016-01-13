package com.fyhack.DynamicProxy.test;

import com.fyhack.DynamicProxy.ProxyAnnotation;

/**
 * Demo
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/1/13
 */
public class Demo implements IDemo{

    @ProxyAnnotation(getProxyClass = CacheProxy.class)
    @Override
    public void run() {
        System.out.println("doCache");
    }

    @ProxyAnnotation(getProxyClass = CacheProxy.class)
    @Override
    public void ss() {
        System.out.println("sss");
    }
}
