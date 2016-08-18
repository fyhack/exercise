package com.fyhack.JavaAnnotationProcessing.test;

import com.fyhack.JavaAnnotationProcessing.PrintInject;

/**
 * Test
 * <p/>
 *
 * @author elc_simayi
 * @since 2016/8/18
 */
@PrintInject(1)
public class Test {
    @PrintInject(2)
    private String s;
    @PrintInject(3)
    private void test(){

    }
}
