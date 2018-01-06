package com.beangou.year2017.month02.day0207;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by liutb on 2017/2/6.
 *
 * @since 1.0.0
 */
public class TestThreadPool {

    @Test
    public void newThreadPool() {
        int a = Integer.SIZE;
        ThreadPoolExecutor threadPoolExecutor = null;
        try {
            threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1L, TimeUnit.DAYS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        System.out.println("activeCount=" + threadPoolExecutor.getActiveCount());
        threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(5000L);
                System.out.println("get a task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("activeCount=" + threadPoolExecutor.getActiveCount());
        try {
            Thread.sleep(9000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("activeCount=" + threadPoolExecutor.getActiveCount());

    }

    @Test
    public void testThreadPoolExecutor() {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor();
        // 线程池如何管理线程，如何知道线程池里面所有线程当前状态，正在运行？ 阻塞
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int i = 0;
        while (i < 1000) {
            Future future = executorService.submit(() -> {
                System.out.println("new Tasks comes.");
//                try {
//                    Thread.sleep(1000 * 60 * 10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("new Tasks end.");
            });
            i++;
            System.out.println("i=" + i);
        }

        ExecutorService executorService1 = Executors.newWorkStealingPool();

        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadScheduledExecutor();
    }

}
