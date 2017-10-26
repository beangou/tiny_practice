package com.beangou.year2017.month09;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 锁分解技术：本来多个状态由一个锁管理，使用锁分解技术，可以使每一个状态由不同锁来管理
 * Created by liutongbin on 2017/9/3.
 */
public class ResolveLockTest {

    @Test
    public void test() throws InterruptedException {
        ServerStatus serverStatus = new ServerStatus();
        MyAddTHread myAddTHread = new MyAddTHread(serverStatus);
        MyRemoveTHread myRemoveTHread = new MyRemoveTHread(serverStatus);
        new Thread(myAddTHread).start();
        new Thread(myRemoveTHread).start();
        Thread.sleep(20000);
    }
}




class MyAddTHread implements Runnable {

    private ServerStatus serverStatus;

    public MyAddTHread(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    }

    @Override
    public void run() {
        serverStatus.add("aaa");
    }
}

class MyRemoveTHread implements Runnable {

    private ServerStatus serverStatus;

    public MyRemoveTHread(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    }

    @Override
    public void run() {
        serverStatus.remove("aaa");
    }
}


/**
 * add 方法和remove方法，使用同一个锁，那么同一个锁，所以多个线程同时访问时，会串行执行
 */
class ServerStatus {

    private static int a = 3;

    static {
        a = 4;
        System.out.println("a=" + a);
//        System.out.println("b=" + b); // 定义在静态代码块后面的变量，只能赋值不能访问
    }

    private static int b = 3;

    private Set<String> statusSet;

    public ServerStatus () {
        statusSet = new HashSet<>();
    }

    public synchronized void add(String obj) {
        System.out.println("add start");
        statusSet.add(obj);
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("add over");
    }

    public void betterAdd(String obj) {
        System.out.println("add start");
        synchronized (statusSet) {
            statusSet.add(obj);
        }
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("add over");
    }

    public synchronized void remove(String obj) {
        System.out.println("remove start");
        statusSet.remove(obj);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("remove over");
    }

}
