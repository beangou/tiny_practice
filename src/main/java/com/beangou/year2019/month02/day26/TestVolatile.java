package com.beangou.year2019.month02.day26;

import org.junit.Test;

import java.util.Date;

/**
 * @author 小彬
 * @version V1.0 2019-02-26 18:00
 * @since V1.0
 */
public class TestVolatile {

    static volatile int i = 0;
    static volatile int j = 0;

//    static volatile int b;

    @Test
    public void see() {
        System.out.println("date = " + new Date(System.currentTimeMillis()-43811488));
    }

    @Test
    public void run() throws InterruptedException {
        new Thread(() -> {
            for (int k = 0; k < 100000; k++) {
                add();
            }
        }).start();
        new Thread(() -> {
            for (int k = 0; k < 100000; k++) {
                print();
            }
        }).start();
        Thread.sleep(100000L);
    }

    public static void add() {
        i++;
        j++;
    }

    public static void print() {
        System.out.println("i=" + i + "; j=" + j);
    }

}
