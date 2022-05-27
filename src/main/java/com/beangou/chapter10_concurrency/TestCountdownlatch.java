package com.beangou.chapter10_concurrency;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCountdownlatch {

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 6, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue(1024));

    @Test
    public void countdown() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        countDownLatch.countDown();
        countDownLatch.countDown();

        countDownLatch.await(10, TimeUnit.SECONDS);
        System.out.println(222222);
//        threadPoolExecutor.submit(()->{
//
//        });

    }

}
