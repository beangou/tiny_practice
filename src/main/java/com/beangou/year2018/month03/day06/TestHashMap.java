package com.beangou.year2018.month03.day06;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author 小彬
 * @version V1.0 2018/3/6 上午12:26
 * @since V1.0
 */
public class TestHashMap {

    @Test
    public void iterate() {
        HashMap map = new HashMap();
        map.entrySet();
    }

    @Test
    public void see() {

        long i = 100000000000000L;

        System.out.println("a = " + (1 << 1));

        HashMap<String, Integer> map = new HashMap();

        for (Integer value : map.values()) {
            System.out.println("value=" + value);
        }

        map.keySet();

        map.put("555", 99);
        map.put("222", 99);

        HashMap<String, Integer> map2 = new HashMap();

        map2.put("555", 99);
        map2.put("3333", 99);

        map2.putAll(map);
        System.out.println("map2=" + map2);

        System.out.println("value=" + map2.get("222"));

        System.out.println("sss=" + (2 ^ 3));

        System.out.println("null == null :" + (null == null));

    }



}
