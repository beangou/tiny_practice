package com.beangou.year2017.month12.day16;

import org.junit.Test;

/**
 * 内置锁是可重入的
 * 父类和子类，都有synchronized的方法，如果要执行子类的test方法
 * 需要获取子类对象的内置锁，执行到super.test()方法时，还需要该锁，
 * 此时如果不是可重入，则会发生死锁
 * @author 小彬
 * @version V1.0 2017/12/16 下午12:18
 * @since V1.0
 */
public class TestIntrinsicLock {

    @Test
    public void reEnter() throws InterruptedException {
        System.out.println("bbb= " + Thread.currentThread().getId());
        new MySon().test();
        Thread.sleep(50000L);
    }

}

class MySuper {
    public synchronized void test() {
        System.out.println("father method.");
    }
}

class MySon extends MySuper {

    @Override
    public synchronized void test() {
        System.out.println("son method.");
        test2();
        super.test();
    }

    public synchronized void test2() {
        System.out.println("test2");
    }
}
