package com.beangou.year2016.day1128;

/**
 * Created by liutb on 2016/11/28.
 *
 * @since 1.0.0
 */
public class ThreadTest implements Runnable {

    private String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    public void run() {
        int i = 0;
        while(true) {
            try{
                System.out.println(name);
                Thread.sleep(10000);
                System.out.println("***********");
                i++;
                if(i > 2) {
                    break;
                }
            }catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {

        ThreadTest test = new ThreadTest("11111111");
//        Thread t1 = new Thread(test);
//        System.out.println("t1.state=" + t1.getState());
//        Thread t2 = new Thread(test);
//        t2.start();
//        System.out.println("t2.state=" + t2.getState());
//        t2.suspend();
//        t2.stop();
//        t2.resume();
//        Thread.yield();

        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    public void test4() {

    }

    public void test2() {

    }


}

class ThreadA implements Runnable {

    public Object monitor;

    public ThreadA(Object monitor) {
        this.monitor = monitor;
    }

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        ThreadA threadA = new ThreadA(monitor);
        Thread thread = new Thread(threadA);
        thread.start();
        Thread.sleep(1000 * 10);

        ThreadB threadB = new ThreadB(monitor);
        Thread thread2 = new Thread(threadB);
        thread2.start();

        Thread.sleep(1000 * 10);

        ThreadC threadC = new ThreadC(monitor);
        Thread thread3 = new Thread(threadC);
        thread3.start();
//        threadA.monitor.notify();
//        Thread.sleep(1000 * 10);
//        threadA.monitor.notifyAll();
    }

    @Override
    public void run() {
        synchronized (monitor) {
            try {
                System.out.println("just wait...");
                monitor.wait(); // 调用wait方法 表示已经当前线程已释放monitor的锁了
                System.out.println("pass wait...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadB implements Runnable {

    private Object monitor;

    public ThreadB(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            System.out.println("go to threadB");
            try {
                monitor.wait(); // 调用wait、notify方法，前提是当前线程必须持有该对象的锁
                System.out.println("pass threadB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        Object object = new Object();
//        synchronized (object) {
//            System.out.println("go to threadB");
//            object.notify();
////            monitor.notify();
//
    }
}

class ThreadC implements Runnable {

    private Object monitor;

    public ThreadC(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            System.out.println("go to threadC");
            monitor.notifyAll(); // 调用wait、notify方法，前提是当前线程必须持有该对象的锁
        }

//        Object object = new Object();
//        synchronized (object) {
//            System.out.println("go to threadB");
//            object.notify();
////            monitor.notify();
//        }
    }
}
