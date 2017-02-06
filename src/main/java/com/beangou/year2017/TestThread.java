package com.beangou.year2017;

import java.util.concurrent.TimeUnit;

/**
 * Created by liutb on 2017/2/4.
 *
 * @since 1.0.0
 */
public class TestThread implements Runnable {


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("000000000");
                String a = null;
//                System.out.println(a.toCharArray());
                System.out.println("99999");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("2222");
            } finally {
                System.out.println("finally..");
            }
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        int a = 5 / 0;
    }

    public static void main(String[] args) {
//        try {
            Thread thread = new Thread(new TestThread());
//            thread.setDaemon(true);
            thread.start();
//        } catch (Exception e) {
//            System.out.println("9999999999");
//            e.printStackTrace();
//        } finally {
//            System.out.println("finally..");
//        }
    }
}
