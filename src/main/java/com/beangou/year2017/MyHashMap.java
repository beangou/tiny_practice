package com.beangou.year2017;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by liutb on 2017/1/22.
 *
 * @since 1.0.0
 */
public class MyHashMap {
    public static void main(String[] args) throws InterruptedException {
        HashMap<String, Object> map = new HashMap<>(2);
        map.toString();
        System.out.println(map);
//        new (new MyHashMap()).MyStaticClass();
//        new MyHashMap().MyStaticClass;
        new Thread(new MyThread(map)).start();
        new Thread(new MyThread(map)).start();
        new Thread(new MyThread(map)).start();
        new Thread(new MyThread(map)).start();
        new Thread(new MyThread(map)).start();


        final HashMap<String, String> map2 = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map2.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();

    }

    static class MyStaticClass {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

class MyThread implements Runnable {
    private Map<String, Object> map;

    public MyThread(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public void run() {
        while(true) {
            map.put(String.valueOf(10*Math.random()), "222");
            System.out.println(map); // 异常可能会在此抛出，因为会调用map的toString方法，使用map的迭代器
            map.toString();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}