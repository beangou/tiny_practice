package com.beangou.year2018.month11.day13;

import org.junit.Test;

import java.util.concurrent.SynchronousQueue;

/**
 * @author 小彬
 * @version V1.0 2018/11/13 下午9:05
 * @since V1.0
 */
public class TestSynchronousQueue {

    @Test
    public void see() throws InterruptedException {
        SynchronousQueue queue = new SynchronousQueue();
        Thread thread1 = new Thread(()->{
            try {
                Object putObj = new Object();
                System.out.println("start to putObj=" + putObj + " isEmpty=" + queue.isEmpty());
                queue.put(putObj);
                System.out.println("end putObj=" + putObj + " isEmpty=" + queue.isEmpty());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();


        Thread thread2 = new Thread(() -> {
            System.out.println("start to poll isEmpty=" + queue.isEmpty());
            Object pollObject = queue.poll();
            System.out.println("poll over pollObject=" + pollObject + " isEmpty=" + queue.isEmpty());
        });
        thread2.start();

        System.out.println("offer result=" + queue.offer(new Object()));
        thread1.join();
        thread2.join();
        System.out.println("over...");
    }

}
