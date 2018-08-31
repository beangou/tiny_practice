package com.beangou.year2017.month06.day0604;

/**
 * Created by liutongbin on 2017/6/4.
 */
public class MyDeadLock {

    public static void main(String[] args) throws InterruptedException {

        String strLock = new String();
        Integer intLock = new Integer(5);

        Thread.currentThread().setName("main thread");
        Thread anotherThread = new Thread(() -> {
            synchronized (strLock) {
                try {
                    System.out.println("another thread get strLock");
                    Thread.sleep(2000L);
                    synchronized (intLock) {
                        System.out.println("another thread get intLock");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        anotherThread.setName("another thread");
        anotherThread.start();

//        anotherThread.start();
//        Thread.sleep(5000L);

        Thread oneThread = new Thread(() -> {
            synchronized (intLock) {
                System.out.println("main thread  get intLock");
                try {
                    Thread.sleep(4000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (strLock) {
                    System.out.println("main thread  get strLock");
                }
            }
        });
        oneThread.setName("one thread");
        oneThread.start();
    }

}
