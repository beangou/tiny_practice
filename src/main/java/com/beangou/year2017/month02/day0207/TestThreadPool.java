package com.beangou.year2017.month02.day0207;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by liutb on 2017/2/6.
 *
 * @since 1.0.0
 */
public class TestThreadPool {

    @Test
    public void callable() {
        Callable callable = Executors.callable(() -> {
            try {
                System.out.println("begin....");
                Thread.sleep(1000L * 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end....");
        });

        FutureTask future = (FutureTask)new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>()).submit(callable);
        future.isCancelled();
        future.cancel(true);
        try {
            future.get();
            callable.call();
            System.out.println("start call.");
//            callable.call();
            System.out.println("end call.");
            new Thread().join();
            System.out.println("end join.");
            new Thread().join(10);
            new Thread().join(10, 20);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void newThreadPool() {
        int a = Integer.SIZE;
        ThreadPoolExecutor threadPoolExecutor = null;
        try {
            BlockingQueue queue = new ArrayBlockingQueue(10);
            threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1L, TimeUnit.DAYS, queue);
            threadPoolExecutor.prestartAllCoreThreads();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        int threadCount = 10;
        System.out.println("begin activeCount=" + threadPoolExecutor.getActiveCount());
        while (threadCount > 1) {
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000L);
                    System.out.println("get a task.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threadCount--;
        }
        System.out.println("after activeCount=" + threadPoolExecutor.getActiveCount());
        try {
            Thread.sleep(90000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("activeCount=" + threadPoolExecutor.getActiveCount());

    }

    @Test
    public void testThreadPoolExecutor() {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor();
        // 线程池如何管理线程，如何知道线程池里面所有线程当前状态，正在运行？ 阻塞
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        int i = 0;
        while (i < 10) {
            Future future = executorService.submit(() -> {
                System.out.println("new Tasks comes.");
                try {
                    Thread.sleep(1000 * new Random().nextInt(30));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("new Tasks end.");
            });
            i++;
//            System.out.println("i=" + i);
        }

        while (true) {
            System.out.println("***********");
            ThreadPoolExecutor executor = ((ThreadPoolExecutor)executorService);
            System.out.println("activeCount=" + executor.getActiveCount());
            System.out.println("taskCount=" + executor.getTaskCount());
            System.out.println("completedTaskCount=" + executor.getCompletedTaskCount());
            System.out.println("largestPoolSize=" + executor.getLargestPoolSize());
            System.out.println("poolSize=" + executor.getPoolSize());
            System.out.println("corePoolSize=" + executor.getCorePoolSize());
            System.out.println("maximumPoolSize=" + executor.getMaximumPoolSize());
            System.out.println("***********");
            System.out.println("***********");
            System.out.println("***********");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (new Random().nextInt(30) % 2 == 0) {
                executorService.submit(() -> {
                    try {
                        Thread.sleep(1000 * new Random().nextInt(30));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }


//        ExecutorService executorService1 = Executors.newWorkStealingPool();
//        Executors.newCachedThreadPool();
//
//        Executors.newSingleThreadExecutor();
//        Executors.newSingleThreadScheduledExecutor();
    }

}
