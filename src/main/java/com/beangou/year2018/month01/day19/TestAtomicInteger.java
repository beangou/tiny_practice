package com.beangou.year2018.month01.day19;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 小彬
 * @version V1.0 2018/1/19 下午2:14
 * @since V1.0
 */
public class TestAtomicInteger {

    @Test
    public void sese() {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        System.out.println("result=" + atomicInteger.decrementAndGet());
        System.out.println("result=" + atomicInteger.incrementAndGet());
    }

}
