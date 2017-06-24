package com.beangou.year2017.day0625;

/**
 * Created by liutongbin on 2017/6/25.
 */
public class TestInnerLock {

    public static void main(String[] args) throws InterruptedException {
        String lock = "aaaa";
        new ClassA(lock).start();
        new ClassC(lock).start();

        Thread.sleep(10000);
        new ClassB(lock).start();
    }

}

class ClassA extends Thread {

    private String innerLock;

    public ClassA(String innerLock) {
        this.innerLock = innerLock;
    }

    @Override
    public void run() {
        synchronized (innerLock) {
            try {
                Thread.sleep(5000);
                System.out.println("A go to wait...");
                innerLock.wait();
                System.out.println("pass A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class ClassB extends Thread {
    private String innerLock;

    public ClassB(String innerLock) {
        this.innerLock = innerLock;
    }

    @Override
    public void run() {
        synchronized (innerLock) {
            System.out.println("B go to notify...");
            innerLock.notifyAll();
            System.out.println("after notify pass B");
        }
    }
}

class ClassC extends Thread {

    private String innerLock;

    public ClassC(String innerLock) {
        this.innerLock = innerLock;
    }

    @Override
    public void run() {
        synchronized (innerLock) {
            try {
                System.out.println("C go to wait...");
                innerLock.wait();
                System.out.println("pass C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}