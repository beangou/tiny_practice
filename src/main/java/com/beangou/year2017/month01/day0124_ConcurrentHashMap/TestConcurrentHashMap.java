package com.beangou.year2017.month01.day0124_ConcurrentHashMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liutb on 2017/1/24.
 *
 * @since 1.0.0
 */
public class TestConcurrentHashMap {


    @Test
    public void testRemove() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);

        System.out.println("map =" + map);
        map.remove("1");
        System.out.println("map =" + map);
        map.remove("2");
        System.out.println("map =" + map);
        map.remove("3");
        System.out.println("map =" + map);
        System.out.println("size =" + map.size());

    }

    @Test
    public void testHash() {
        Object obj = new Object();
        System.out.println(obj.hashCode());
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("aaa", "bbb");
        System.out.println(map.putIfAbsent("sss", "bbbb"));
        System.out.println(map.hashCode());
    }

    @Test
    public void testShift() {
        int size = 1;
        size <<= 1;
        System.out.println(size);
        int newSize = 0;
        System.out.println(1 << 0);
    }

    @Test
    public void testHashTable() {
        HashMap map = new HashMap();
        map.put(null, null);
        System.out.println(map);
        Hashtable hashtable = new Hashtable();
        hashtable.put(null, null);

    }



}

