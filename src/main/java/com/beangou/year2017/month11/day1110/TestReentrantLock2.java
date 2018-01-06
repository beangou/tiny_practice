package com.beangou.year2017.month11.day1110;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 小彬
 * @version V1.0 2017/11/10 下午3:46
 * @since V1.0
 */
    public class TestReentrantLock2 implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    public void get() {
        System.out.println("lock holdCount=" + lock.getHoldCount() + ", queueLen=" + lock.getQueueLength());
        lock.lock();
        System.out.println("get=" + Thread.currentThread().getId());
        try {
            Thread.sleep(1000L*20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start to set");
        set("by get");
        lock.unlock();
    }

    public void set(String name) {
        lock.lock();
        System.out.println("name"+ name +"; set=" + Thread.currentThread().getId());
        try {
            System.out.println("set just waiting, name=" + name);
            Thread.sleep(1000L*40);
            System.out.println("set pass waiting, name=" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    @Override
    public void run() {
        get();
    }

    @Test
    public void testRun() {
        TestReentrantLock2 lock = new TestReentrantLock2();
        new Thread(lock).start();
        new Thread(lock).start();
        new Thread(lock).start();
        lock.set("by testRun");
        try {
            Thread.sleep(1000L * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
