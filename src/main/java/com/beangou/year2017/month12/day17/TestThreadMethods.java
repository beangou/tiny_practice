package com.beangou.year2017.month12.day17;

import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2017/12/17 下午5:51
 * @since V1.0
 */
public class TestThreadMethods {

    /**
     * 让出cpu，使自己由正在执行状态改为就绪状态
     * @throws InterruptedException
     */
    @Test
    public void testYield() throws InterruptedException {
        new YieldTest("张三").start();
        new YieldTest("李四").start();
        Thread.sleep(60*1000L);
    }

    @Test
    public void testJoin() {
        try {
            System.out.println("begin.");

            Thread thread = new Thread(() -> {
                try {
                    System.out.println("开始sleep 10s");
                    Thread.sleep(10000L);
                    System.out.println("sleep over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            thread.join(); // 等待线程结束，阻塞的
            // status=TERMINATED
            System.out.println("status=" + thread.getState().name());
//            thread.start(); IllegalThreadStateException
            System.out.println("the thread died.");
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class YieldTest extends Thread {

    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                Thread.yield();
            }
        }
    }
}
