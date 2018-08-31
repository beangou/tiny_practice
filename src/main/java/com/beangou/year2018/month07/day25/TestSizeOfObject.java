package com.beangou.year2018.month07.day25;

import org.junit.Test;

import static com.beangou.SizeOfAgent.fullSizeOf;
import static com.beangou.SizeOfAgent.sizeOf;

/**
 * @author 小彬
 * @version V1.0 2018/7/25 下午8:17
 * @since V1.0
 */
public class TestSizeOfObject {

    @Test
    public void see() {
        System.out.println("------------------空对象----------------------------");
        // 16 bytes + 0 + 0 = 16  空对象， 只有对象头
        System.out.println("sizeOf(new Object()) = " + sizeOf(new Object()));
        System.out.println("fullSizeOf(new Object()) = " + fullSizeOf(new Object()));

        System.out.println("----------------非空对象含有原始类型、引用类型------------------------------");

        // 16 bytes + 8 + 4 + padding = 32
        System.out.println("sizeOf(new A()) = " + sizeOf(new A()));
        System.out.println("fullSizeOf(new A()) = " + fullSizeOf(new A()));

        // 16 + 4 + padding =24      数据是一个 int
        System.out.println("sizeOf(new Integer(1)) = " + sizeOf(new Integer(1)));

        // (16 + int hash:4 + int hash32:4 + refer char value[]:8 + padding) = 32
        // 静态属性（static）不计算空间，因为所有对象都是共享一块空间的
        // 不同版本JDK可能 String 内部 Field 可能不同，本次测试使用JDK1.7
        System.out.println("sizeOf(new String()) = " + sizeOf(new String()));
    }


    public static class A {
        int a;
        Integer b;
    }

    public static class B {
        int a;
        Integer b;
    }

    public static class C{
        int c;
        B[] b = new B[2];

        // 初始化
        C() {
            for (int i = 0; i < b.length; i++) {
                b[i] = new B();
            }
        }
    }

    public static class D {
        byte d1;
    }

    public static class E extends D {
        byte e1;
    }


}
