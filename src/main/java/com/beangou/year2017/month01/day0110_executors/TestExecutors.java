package com.beangou.year2017.month01.day0110_executors;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by liutb on 2017/1/10.
 *
 * @since 1.0.0
 */
public class TestExecutors {

    @Test
    public void runTask() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(() -> {
            System.out.println("hahah out.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("result=" + future.get());
    }

    @Test
    public void future() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> haha());

        try {
            System.out.println("result=" + future.get());
        } catch (InterruptedException e) {
            System.out.println("catch one.");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("catch two.");
            e.printStackTrace();
        }
    }

    public String haha() {
        throw new RuntimeException("hahahah");
//        return "aaa";
    }

    /**
     * shutdownNow都能stop线程池里面的方法
     */
    @Test
    public void seeShutdownNow() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("线程池状态isShutdown：" + executorService.isShutdown());
        System.out.println("线程池状态isTerminated：" + executorService.isTerminated());
//        executorService.execute(() -> {
        executorService.submit(() -> {
            while(true) {
                System.out.println("go go go.");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("InterruptedException .=>" + e.getClass().getName());
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Exception .=>" + e.getClass().getName());
                    break;
                }
            }
        });
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start shutdownNow");
        List<Runnable> runnableList = executorService.shutdownNow();
        System.out.println("线程池状态isShutdown：" + executorService.isShutdown());
        System.out.println("线程池状态isTerminated：" + executorService.isTerminated());
        System.out.println("runnableList size=" + runnableList.size());
        try {
            boolean waitTermination = executorService.awaitTermination(30L, TimeUnit.SECONDS);
            System.out.println("waitTermination=" + waitTermination);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void objectLock() {
        synchronized (this) {
            System.out.println("aaaa");
        }

        synchronized (this.getClass()) {
            System.out.println("9999999");
        }
    }

    public static void classLock() {
        synchronized (TestExecutors.class) {
            System.out.println("fffffff");
        }
    }


    @Test
    public void seeExceptionInThread() {
        new Thread(() -> {
            int i = 0;
            while(i < 10) {
                System.out.println("kkkkk");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 6) {
                    int a = 4 / 0;
                }
                i++;
            }
        }).start();

        try {
            Thread.sleep(1000L * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void seeException() {
        ExecutorService service = Executors.newSingleThreadExecutor();
//        service.submit(() -> { / 会吞掉异常
        service.execute(() -> { // 会抛出异常
            int i = 0;
            while(i < 10) {
                System.out.println("hhhhhhhhhhhh i=" + i);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 2) {
                    int a = 4 / 0;
                }
                i++;
            }
        });
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }

    @Test
    public void seeExceptionInExecutor() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future future = service.submit(() -> {
            int i = 0;
            while(i < 10) {
                System.out.println("hhhhhhhhhhhh");
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 6) {
                    int a = 4 / 0;
                }
                i++;
            }
        });
        System.out.println("start关闭线程池");
        service.shutdown();
        System.out.println("end关闭线程池, start awaitTermination");
        try {
            // 阻塞
            boolean result = service.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println("end awaitTermination result=" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("sss=");

        try {
            //
            Object object = future.get();
            System.out.println("object=" + object);
        } catch (ExecutionException e) {
            System.out.println("exception 1");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("exception 2");
            e.printStackTrace();
        }

        System.out.println("comes here?");

        try {
            Thread.sleep(1000L * 30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        ThreadPoolExecutor executor = new ThreadPoolExecutor();

        ExecutorService service = Executors.newFixedThreadPool(10);
//        ExecutorService service = Executors.newSingleThreadExecutor();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue(100), r -> new Thread(), new ThreadPoolExecutor.AbortPolicy());
        executor.getLargestPoolSize();
        executor.getActiveCount();

//        service.execute(() -> {
//            int i = 0;
//            while(i < 10) {
//                System.out.println("hhhhhhhhhhhh");
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (i == 6) {
//                    int a = 4 / 0;
//                }
//                i++;
//            }
//        });

        service.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("aaaa");
                }
            }
        });

        service.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("bbbb");
                }
            }
        });

        service.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("cccc");
                }
            }
        });
    }
}