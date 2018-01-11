package com.beangou.year2017.month01.day0105_multiple_inheritance;

/**
 * @author 小彬
 * @version V1.0 2018/1/9 下午11:11
 * @since V1.0
 */
public class Outter {

    private Inner inner;

    public Outter() {
        inner = new Inner();
//        inner.doTest();
    }

    private class Inner {
        private void doTest() {
            System.out.println("test");
        }
    }
}
