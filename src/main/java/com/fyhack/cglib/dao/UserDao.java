package com.fyhack.cglib.dao;

/**
 * UserDao
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/5
 */
public class UserDao {

    public User query(String id) {
        System.out.println("query " + id);
        return new User(id, "testUser");
    }

    public void delUser(String id) {
        System.out.println("del " + id);
    }
}
