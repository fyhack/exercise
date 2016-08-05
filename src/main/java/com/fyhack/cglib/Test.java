package com.fyhack.cglib;

import com.fyhack.cglib.dao.DaoFactory;
import com.fyhack.cglib.dao.UserDao;
import com.fyhack.cglib.proxy.AuthProxy;

/**
 * Test
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/5
 */
public class Test {
    public static void main(String args[]) {
        UserDao dao = DaoFactory.getInstance(new AuthProxy("admin"));
        dao.query("1");
        dao.delUser("2");
    }
}
