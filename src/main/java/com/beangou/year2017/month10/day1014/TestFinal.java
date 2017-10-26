package com.beangou.year2017.month10.day1014;

/**
 * Created by liutongbin on 2017/10/14.
 */
public class TestFinal {

    private final int a;

//    private static final int b; error
    private static final int b = 2;

    public TestFinal(int a, int b) {
        this.a = a;
//        this.b = b;
    }

}
