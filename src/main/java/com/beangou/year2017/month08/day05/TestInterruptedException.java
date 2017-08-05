package com.beangou.year2017.month08.day05;

import org.junit.Test;

/**
 * Created by liutongbin on 2017/8/5.
 */
public class TestInterruptedException extends Thread {

    @Test
    public void see() {
        isInterrupted();
    }


    public boolean isInterrupted() {
        System.out.println("result=" + Thread.currentThread().isInterrupted());
        interrupt();
        System.out.println("result=" + Thread.currentThread().isInterrupted());
        return false;
    }

}
