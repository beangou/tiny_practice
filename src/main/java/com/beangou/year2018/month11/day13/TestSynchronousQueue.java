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
        queue.put(new Object());
        queue.poll();
        queue.offer(new Object());
    }

}
