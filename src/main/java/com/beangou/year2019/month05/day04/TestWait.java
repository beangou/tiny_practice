package com.beangou.year2019.month05.day04;

import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2019-05-04 22:56
 * @since V1.0
 */
public class TestWait {

    public Object lock = new Object();

    @Test
    public void seeWait() {
//        synchronized (this) {
        synchronized (lock) {
            try {
                System.out.println("begin to wait.");
                lock.wait();
                System.out.println("over wait.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
