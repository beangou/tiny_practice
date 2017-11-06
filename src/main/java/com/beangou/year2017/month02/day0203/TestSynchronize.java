package com.beangou.year2017.month02.day0203;

import java.util.Date;
import java.util.concurrent.TimeUnit;


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

    private String threadName;

    public TestSynchronize(String threadName) {
        this.threadName = threadName;
    }

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

    public static void main(String[] args) {
        System.out.println(new Date(201702038574569534L));
        System.out.println("");
        System.out.println(1 << 1);
        new Thread(new MyThread("1111")).start();
        new Thread(new MyThread("2222")).start();
        new Thread(new MyThread("3333")).start();
        new Thread(new MyThread("4444")).start();
        new Thread(new MyThread("5555")).start();
    }

    public String getString() {
        System.out.println("thread=" + Thread.currentThread().getId() + ", threadName=" + threadName);
        synchronized (TestSynchronize.class) {
            System.out.println("thread=" + Thread.currentThread().getId() + ", threadName=" + threadName + "go to synchronize.");
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("over.");
        synchronized ("222") {
            System.out.println(threadName + "go to 222 synchronize.");
            try {
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " is over");
        return null;
    }

    public String test2() {
        synchronized (TestSynchronize.class) {
            return "";
        }
    }
}

class MyThread implements Runnable {

    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        new TestSynchronize(threadName).getString();
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
