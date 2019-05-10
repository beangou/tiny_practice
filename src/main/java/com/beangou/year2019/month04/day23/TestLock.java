package com.beangou.year2019.month04.day23;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 小彬
 * @version V1.0 2019-04-23 20:27
 * @since V1.0
 */
public class TestLock {

    private int num = 0;
    private int num2 = 0;

    private static int synValue;

    @Test
    public void see() {
        testSync(10, 1000000);
        testLock(10, 1000000);
    }

    public void testSync(int threadNum, int maxValue) {

        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < maxValue; j++) {
                    synchronized (this) {
                        num++;
                    }
                }
            });
        }

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threadNum; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("testSync is over. time="+(t2-t1) + " num="+num);
    }

    public void testLock(int threadNum, int maxValue) {
        Thread[] threads = new Thread[threadNum];
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < maxValue; j++) {
                    try {
                        lock.lock();
                        num2++;
                    } finally {
                        lock.unlock();
                    }
                }
            });
        }

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threadNum; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("testLock is over. time="+(t2-t1) + " num2="+num2);
    }

}
