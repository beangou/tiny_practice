package com.beangou.year2019.month04.day24;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author 小彬
 * @version V1.0 2019-04-24 13:50
 * @since V1.0
 */
public class TestThreadPoolSwallowException {

    ExecutorService executor = Executors.newSingleThreadExecutor();

    class MyRunner implements Runnable {

        @Override
        public void run() {
            int b = 5/0;
        }
    }

    @Test
    public void execute() {
        // 会抛出异常
        executor.execute(new MyRunner());
    }

    @Test
    public void submit() throws ExecutionException, InterruptedException {
        // 不会抛出异常, 调用Future.get()方法会抛出异常
        Future future = executor.submit(new MyRunner());
//        future.get();
    }



}
