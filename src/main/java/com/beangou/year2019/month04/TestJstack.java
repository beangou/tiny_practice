package com.beangou.year2019.month04;

import org.junit.Test;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

/**
 * @author 小彬
 * @version V1.0 2019-04-12 09:18
 * @since V1.0
 */
public class TestJstack {

    public void runnableState() {
        // java.lang.Thread.State: RUNNABLE
        while (true) {
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor ex = new ThreadPoolExecutor(1, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingDeque<>(), new CustomizableThreadFactory("hello_thread_pool_"));
        ex.execute(new TestTask());
    }

}

class TestTask implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
