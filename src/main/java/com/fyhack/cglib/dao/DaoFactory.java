package com.fyhack.cglib.dao;

import com.fyhack.cglib.filter.AuthProxyFilter;
import com.fyhack.cglib.proxy.AuthProxy;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * DaoFactory
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/5
 */
public class DaoFactory {
    public static UserDao getInstance(AuthProxy authProxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
//        enhancer.setCallback(authProxy);
        enhancer.setCallbackFilter(new AuthProxyFilter());
        enhancer.setCallbacks(new Callback[]{authProxy, NoOp.INSTANCE});
        return (UserDao) enhancer.create();
    }
}
