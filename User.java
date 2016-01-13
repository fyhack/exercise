package com.fyhack.JDKParser;

import com.sun.istack.internal.Nullable;

/**
 * User
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/1/13
 */
public class User {
    @Nullable
    private String foo = "212121";
    private Foo a;

    public void UserMethod(){}

    public class Foo{
        private String fooString = "212121";
        public void FooMethod(){}
    }
}
