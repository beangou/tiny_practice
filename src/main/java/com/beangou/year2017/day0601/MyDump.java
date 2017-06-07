package com.beangou.year2017.day0601;

import org.junit.Test;

/**
 * Created by liutongbin on 2017/6/1.
 */
public class MyDump {

    @Test
    public void state() {
        new Thread().getState();
    }

    @Test
    public void myWait() {
        synchronized (this) {
            while (4 > 1) {
                try {
                    new MyDump().wait();
                    System.out.println("ssss");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
