package com.fyhack.DynamicProxy.test;

import com.fyhack.DynamicProxy.ProxyFactory;

/**
 * Main
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/1/13
 */
public class Main {

    public static void main(String args[]){
        IDemo demo = ProxyFactory.getProxy(Demo.class);
        demo.run();
        demo.ss();
    }
}
