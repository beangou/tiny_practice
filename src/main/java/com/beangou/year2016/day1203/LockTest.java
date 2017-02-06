package com.beangou.year2016.day1203;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liutb on 2016/12/3.
 *
 * @since 1.0.0
 */
public class LockTest {

    public static void main(String[] args) {
        Bank bank = new Bank(100, 1000);
        Transfer transfer = new Transfer(bank);
        for (int i = 0; i < 1000; i++) {
            new Thread(transfer).start();
        }
    }
}

class Transfer implements Runnable {
    private Bank bank;

    public Transfer(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while(true) {
            int from = (int)(Math.random()*bank.getNum());
            int to = (int)(Math.random()*bank.getNum());
            int transferAmount = (int)(Math.random()*bank.getInitAmount());
//          bank.unsafeTransfer(from, to, transferAmount);
//          bank.safeTransfer(from, to, transferAmount);
            bank.safeTransfer2(from, to, transferAmount);
            try {
                Thread.sleep((int)(3000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Bank {
    private int num;

    ReentrantLock lock = new ReentrantLock();

    public int getInitAmount() {
        return initAmount;
    }

    private int initAmount;

    public int getNum() {
        return num;
    }

    private int[] accounts;

    public Bank(int num, int amount) {
        this.num = num;
        accounts = new int[num];
        this.initAmount = amount;
        for (int i = 0; i < num; i++) {
            accounts[i] = amount;
        }
    }

    void safeTransfer(int from, int to, int amount) {
        lock.lock();
//        this.intr
        try {
            // 转账操作
            System.out.println("from " + from + " to " + to + ", transefer amount=" + amount);
            accounts[from] -= amount;
            accounts[to] += amount;
            System.out.println("after transfer: from is=" + accounts[from] + "; to is=" + accounts[to]);
            showSum();
        } finally {
            lock.unlock();
        }
    }

    synchronized void safeTransfer2(int from, int to, int amount) {
        // 转账操作
        System.out.println("from " + from + " to " + to + ", transefer amount=" + amount);
        accounts[from] -= amount;
        accounts[to] += amount;
        System.out.println("after transfer: from is=" + accounts[from] + "; to is=" + accounts[to]);
        showSum();
    }

    void unsafeTransfer(int from, int to, int amount) {
        // 转账操作
        System.out.println("from " + from + " to " + to + ", transefer amount=" + amount);
        accounts[from] -= amount;
        accounts[to] += amount;
        System.out.println("after transfer: from is=" + accounts[from] + "; to is=" + accounts[to]);
        showSum();
//        notify();
//        notifyAll();
    }

    public void showSum() {
        int sum = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sum += accounts[i];
            sb.append("," + accounts[i]);
        }
        if(sum != 100000) {
            System.out.println(sb);
            System.out.println("bank sum=" + sum);
        }
    }
}