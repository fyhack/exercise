package com.fyhack.DynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyHandle
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/1/13
 */
public abstract class ProxyHandle implements InvocationHandler{
    private Object obj;
    private String methodName;

    public Object bind(Object obj, String methodName){
        this.obj = obj;
        this.methodName = methodName;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals(methodName)){
            before();
            Object result = method.invoke(obj,args);
            after();
            return result;
        }else{
            return method.invoke(obj,args);
        }
    }

    public abstract void before();
    public abstract void after();
}
