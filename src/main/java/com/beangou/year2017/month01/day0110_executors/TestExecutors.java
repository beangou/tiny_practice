package com.beangou.year2017.month01.day0110_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liutb on 2017/1/10.
 *
 * @since 1.0.0
 */
public class TestExecutors {

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



    public static void main(String[] args) {

//        ThreadPoolExecutor executor = new ThreadPoolExecutor();

        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("hhhhhhhhhhhh");
                }
            }
        });

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