package com.fyhack.DynamicProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ProxyFactory
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/1/13
 */
public class ProxyFactory {

    public static <T> T getProxy(Class<T> clazz){
        T t = (T) newInstance(clazz);
        Method[] method = clazz.getMethods();
        for (int i = 0 ; i<method.length; i++){
            ProxyAnnotation annotation = method[i].getAnnotation(ProxyAnnotation.class);
            if (annotation == null)
                continue;
            ProxyHandle handle = (ProxyHandle) newInstance(annotation.getProxyClass());
            t = (T) handle.bind(t,method[i].getName());
        }
        return t;
    }

    private static Object newInstance(final Class clazz){
        try {
            Constructor constructor = clazz.getConstructor();
            return constructor.newInstance(new Class[]{});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
