package com.beangou.year2017.month12.day03;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author 小彬
 * @version V1.0 2017/12/3 下午10:37
 * @since V1.0
 */
public class TestMap {

    @Test
    public void see() {
        Map<String, Integer> map = new HashMap<>();
        int a = map.get("sss");
        System.out.println("sss=" + a);
    }

    @Test
    public void module() {
        System.out.println("result=" + (7&1));
        System.out.println("result=" + 7%2);
        System.out.println("result=" + (7&3));
        System.out.println("result=" + 7%4);
        System.out.println("result=" + 7%5);
        System.out.println("result=" + (7&4));
        System.out.println("result=" + (7&7));
        System.out.println("result=" + (7%8));
    }

    @Test
    public void myKey() {
        String str1 = new String("xxx");
        String str2 = new String("xxx");
        Map<String, Object> map = new IdentityHashMap<>(2);
        str1.hashCode();
        map.put(str1, "1111");
        map.put(str2, "2222");
        map.put(null, "sss");
        System.out.println("aa=" + map.get(null));
        System.out.println("map= " + map);
        System.out.println("result=" + (str1.hashCode() == str2.hashCode()));
        System.out.println("result=" + (str1 == str2));
        System.out.println("value=" + map.get(str1));
        System.out.println("value=" + map.get(str2));
        System.out.println("value=" + map.get("xxx"));
    }

    @Test
    public void myMap() throws InterruptedException {
        Key key = new Key();
        Map<Key, Integer> map = new HashMap<>();
        map.put(key, 1);
        System.out.println("key=" + key);
        key = null;
        for (Key key1 : map.keySet()) {
//            System.out.println("key == key1 : " + (key == key1)); // true 即保存的是对象的引用
            System.out.println("key1=" + key1 + ", key=" + key); // key1还存在， key 为null
        }

        new Thread(() -> myWait()).start();
        Thread.sleep(5000L);
        new Thread(() -> myNotify()).start();

    }

    public void myNotify() {
        synchronized (this) {
            System.out.println("start to notify");
            notify();
            System.out.println("notify over");
        }
    }

    public void myWait() {
        synchronized (this) {
            try {
                System.out.println("start to wait");
                wait();
                System.out.println("wait over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Key {

}
