package com.beangou.year2018.month01.day04;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author 小彬
 * @version V1.0 2018/1/4 下午10:30
 * @since V1.0
 */
public class TestSemaphore {

    @Test
    public void see() {
        Semaphore semaphore = new Semaphore(3);
        try {
            semaphore.acquire();
            System.out.println("get acquired. available=" + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println("get acquired. available=" + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println("get acquired. available=" + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println("get acquired. available=" + semaphore.availablePermits());
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
