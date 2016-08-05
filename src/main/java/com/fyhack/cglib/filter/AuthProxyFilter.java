package com.fyhack.cglib.filter;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * AuthProxyFilter
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/5
 */
public class AuthProxyFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (!"delUser".equalsIgnoreCase(method.getName())) //del需要权限
            return 1;
        return 0;
    }
}
