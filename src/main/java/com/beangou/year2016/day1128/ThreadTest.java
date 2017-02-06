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
        Thread t1 = new Thread(test);
        System.out.println("t1.state=" + t1.getState());
        Thread t2 = new Thread(test);
        t2.start();
        System.out.println("t2.state=" + t2.getState());
        t2.suspend();
        t2.stop();
        t2.resume();
        Thread.yield();
//        new Thread(test).start();
//        new Thread(test).start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



    }


}
