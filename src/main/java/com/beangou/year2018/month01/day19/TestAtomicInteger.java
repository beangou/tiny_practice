package com.beangou.year2018.month01.day19;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author 小彬
 * @version V1.0 2018/1/19 下午2:14
 * @since V1.0
 */
public class TestAtomicInteger {

    @Test
    public void integer2Long() {
        Integer integer = new Integer(2);
        Long mylong = new Long(2);
        System.out.println("result=" + integer.equals(mylong.intValue()));
    }

    @Test
    public void sese() {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.getAndIncrement();
        System.out.println("result=" + atomicInteger.decrementAndGet());
        System.out.println("result=" + atomicInteger.incrementAndGet());
    }

    @Test
    public void myReference() {
        AtomicStampedReference reference = new AtomicStampedReference<>(9, 0);
        Integer expectedValue = 1;
        int expectedTimeStamp = 0;
        int newValue = 2;
        int newTimeStamp = 3;
        reference.compareAndSet(expectedValue, newValue, expectedTimeStamp, newTimeStamp);
    }

}
