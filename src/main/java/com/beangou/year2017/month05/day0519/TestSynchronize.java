package com.beangou.year2017.month05.day0519;


/**
 * Created by liutongbin on 2017/5/19.
 */
public class TestSynchronize {

    public static void test() {
        synchronized (new String().getClass()) {

        }

        synchronized (new String()) {

        }

        synchronized (TestSynchronize.class) {

        }
    }

    public void test2() {
        synchronized (this.getClass()) {

        }
    }

}
