package com.beangou.year2017.month12.day25;

import org.junit.Test;

/**
 * @author 小彬
 * @version V1.0 2017/12/25 下午1:47
 * @since V1.0
 */
public class TestClassLoading {

    @Test
    public void see() {
        TestSuper[] arr = new TestSuper[4]; // 通过数组引用类，不会触发这个类的初始化
//        System.out.println("a=" + TestSuper.a);
//        TestSuper.a = 5;
    }

}

class TestSuper {

    public static int a = 2;

    static {
        System.out.println("super loading.");
    }

}
