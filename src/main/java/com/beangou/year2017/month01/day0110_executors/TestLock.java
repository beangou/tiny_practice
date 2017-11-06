package com.beangou.year2017.month01.day0110_executors;

/**
 * Created by liutb on 2017/1/10.
 *
 * @since 1.0.0
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock lock = new TestLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.test1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.test2();
            }
        }).start();
    }

    public void test1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " :" + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void test2() {
        int i = 5;
        while (i--  > 0) {
            System.out.println(Thread.currentThread().getName() + " :" + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {

}