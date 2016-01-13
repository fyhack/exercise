package com.fyhack.DynamicProxy.test;

import com.fyhack.DynamicProxy.ProxyHandle;

/**
 * CacheProxy
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/1/13
 */
public class CacheProxy extends ProxyHandle {

    @Override
    public void before() {
        System.out.println("cache before");
    }

    @Override
    public void after() {
        System.out.println("cache after");
    }
}
