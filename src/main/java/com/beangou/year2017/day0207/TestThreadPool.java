package com.beangou.year2017.day0207;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by liutb on 2017/2/6.
 *
 * @since 1.0.0
 */
public class TestThreadPool {

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
