package com.beangou.year2017.month09.day0924;

import org.junit.Test;

/**
 * Created by liutongbin on 2017/9/24.
 */
public class TestStatic {

    public static int b = 2;

    public static void access2() {
        // 警告，编译时没问题的
        int a = new TestStatic().b;
        System.out.println("a =" + a);
    }

    @Test
    public void access() {
        access2();
//        int a = new TestStatic().b;
    }

    @Test
    public void staticProperty() {
        final int a = 2;
        b = 22;
    }

}
