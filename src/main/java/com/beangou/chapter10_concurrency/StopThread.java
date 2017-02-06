package com.beangou.chapter10_concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by liutb on 2017/1/4.
 *
 * @since 1.0.0
 */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start...");
                long start = System.currentTimeMillis();
                while(!stopRequested) {
                    System.out.println("running...");
                }
                long end = System.currentTimeMillis();
                System.out.println("over... end-start=" + (end - start)/1000);
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopRequested = true;
    }
}
