package com.beangou.year2017.day0318;

import org.junit.Test;

/**
 * Created by liutongbin on 2017/3/18.
 */
public class TestObject {

    private boolean xx;

    private int aa;

    @Test
    public void test() {
        boolean x = true;
        int a = 9;
        if (a == 9) {
            x = false;
        }
        System.out.println("x=" + x);
        System.out.println("xx=" + xx);
        System.out.println("aa=" + aa);
    }

}
