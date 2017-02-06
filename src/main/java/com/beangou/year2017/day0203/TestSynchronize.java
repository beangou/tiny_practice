package com.beangou.year2017.day0203;

import java.util.Date;


//在定义接口方法时不能使用synchronized关键字。
//构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步。
//_synchronized 关键字不能被继承_。如果子类覆盖了父类的 被 synchronized 关键字修饰的方法，
// 那么子类的该方法只要没有 synchronized 关键字，那么就默认没有同步，也就是说，不能继承父类的 synchronized。

/**
 * Created by liutb on 2017/2/3.
 *
 * @since 1.0.0
 */
public class TestSynchronize {
    private volatile int i = 0;

    private String str = "222";

    private Object obj = new Object();

    public synchronized int methodGetI() {
        return i;
    }

    public int blockGetI() {
        synchronized (this) {
            return i;
        }
    }

    public synchronized String methodGetString() {
        return str;
    }

    public synchronized Object getObj() {
        return obj;
    }

    public static synchronized void doIt() {
    }

    public static String getString() {

        synchronized (TestSynchronize.class) {

        }

        synchronized ("222") {
            return null;
        }
    }

    public String test2() {
        synchronized (TestSynchronize.class) {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Date(201702038574569534L));
        System.out.println("");
        System.out.println(1 << 1);
    }
}

interface MyInterface {

    // 接口的静态方法必须在接口内部实现， 只声明会报错
    public static void getName() {
    };

    // 在定义接口方法时不能使用synchronized关键字。
//    public static synchronized void doIt() {
//    }
}
