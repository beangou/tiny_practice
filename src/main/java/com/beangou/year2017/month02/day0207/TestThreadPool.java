package com.beangou.year2017.month02.day0207;

import org.junit.Test;

import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by liutb on 2017/2/6.
 *
 * @since 1.0.0
 */
public class TestThreadPool {

    @Test
    public void addSelf() {
        int a = 1;
        int b = a++;
        int c = a + 1;
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("c="+c);

        ExecutorService executorService = Executors.newFixedThreadPool(20);
//        ((ThreadPoolExecutor)executorService).
    }

    @Test
    public void see() {
//        1102574918937219072
//        9223372036854775807
        Long longMax = Long.MAX_VALUE;
        System.out.println("longMax=" + longMax);
//                 9223372036854775808
//                 9223372036854775807
        Long a = 1102553948428046336L;
        System.out.println("a=" + a.longValue());
        Long b = (a++);
        System.out.println("b=" + b.longValue());
        System.out.println("a==b" + (a.equals(b)));

//        protected String getIntranetIp() {
//            String localIP = "";
//            try {
//                localIP = IPUtil.getLocalIP();
//                System.out.println("得到内网IP=[{}]" + localIP);
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
//        }
    }

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
//        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);
//        ExecutorService executorService = Executors.newFixedThreadPool(20);

        ExecutorService executorService = new ThreadPoolExecutor(0, 100, 0L, TimeUnit.MINUTES, new LinkedBlockingDeque<>(109));
        int i = 0;
        while (i < 1009) {
            try {
                executorService.submit(() -> {
//                System.out.println("new Tasks comes.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                System.out.println("new Tasks end.");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
//            System.out.println("i=" + i);
        }

        while (true) {
            System.out.println("***********");
            ThreadPoolExecutor executor = ((ThreadPoolExecutor)executorService);
//            executor.prestartAllCoreThreads();
            executor.prestartCoreThread();
//            executor.isTerminated()

            System.out.println("activeCount=" + executor.getActiveCount());
            System.out.println("queue.size=" + executor.getQueue().size());
            System.out.println("completedTaskCount=" + executor.getCompletedTaskCount());
            System.out.println("taskCount=" + executor.getTaskCount());

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

//            if (new Random().nextInt(30) % 2 == 0) {
//                executorService.submit(() -> {
//                    try {
//                        Thread.sleep(1000 * new Random().nextInt(30));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                });
//            }
        }


//        ExecutorService executorService1 = Executors.newWorkStealingPool();
//        Executors.newCachedThreadPool();
//
//        Executors.newSingleThreadExecutor();
//        Executors.newSingleThreadScheduledExecutor();
    }

    @Test
    public void getException() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 1000; i++) {
            System.out.println("comes to submit...");
            final int finalI = i;
            Thread caculateThread = new Thread(() -> {
                System.out.println("comes to caculate... finalI="+finalI);
                try {
                    Long a = null;
                    long b = a + 3;
                    System.out.println("b="+b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            Future<?> future = executor.submit(caculateThread);
            try {
                System.out.println("future.get result="+future.get());
            } catch (ExecutionException e) {
                System.out.println("future get error");
            }

        }

//        try {
//            System.out.println("comes to join...");
//            caculateThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("come to stop....");
        Thread.sleep(1000L * 1000);
    }

}
