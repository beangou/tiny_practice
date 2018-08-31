package com.beangou.year2017;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by liutb on 2017/2/4.
 *
 * @since 1.0.0
 */
public class TestThread implements Runnable {

    @Test
    public void myJoin() throws InterruptedException {
        Thread.getAllStackTraces();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hahaha");
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
    }

    @Test
    public void see() throws InterruptedException {
        new Thread(() -> {
            System.out.println("thread1");
            walk();
        }).start();

        new Thread(() -> {
                System.out.println("thread2");
                jump();
            }
        ).start();
        Thread.sleep(1000L * 1000);
    }

    public synchronized void walk() {
        try {
            System.out.println("start walking.");
            Thread.sleep(1000L * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end walking");
    }

    public synchronized void jump() {
        try {
            System.out.println("start jumping.");
            Thread.sleep(1000L * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end jumping");
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("000000000");
                String a = null;
//                System.out.println(a.toCharArray());
                System.out.println("99999");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("2222");
            } finally {
                System.out.println("finally..");
            }
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        int a = 5 / 0;
    }

    public static void main(String[] args) {
//        try {
                Thread thread = new Thread(new TestThread());
//            thread.setDaemon(true);
        thread.getState();
                thread.start();
//        } catch (Exception e) {
//            System.out.println("9999999999");
//            e.printStackTrace();
//        } finally {
//            System.out.println("finally..");
//        }
    }
}
