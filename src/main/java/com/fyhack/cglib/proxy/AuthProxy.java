package com.fyhack.cglib.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * AuthProxy
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/5
 */
public class AuthProxy implements MethodInterceptor {
    protected String role;

    public AuthProxy(String role) {
        this.role = role;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (!role.equals("admin")) {
            return null;
        }
        return proxy.invokeSuper(obj, args);
    }
}
