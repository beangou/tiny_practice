package com.beangou.year2018.month04.day27;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1. LinkedHashMap继承了HashMap，并且实现了Map
 * 2. 既然HashMap已经实现了Map，为何LinkedHashMap还要实现Map
 * ANSWER: 自己实现Map相应的接口，而不是继承HashMap已经实现的方法
 * @author 小彬
 * @version V1.0 2018/4/27 上午12:05
 * @since V1.0
 */
public class TestLinkedHashMap {

    @Test
    public void add() {
//        incur 承担 spare
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("aaa", 33);
        map.put("bbb", 33);
        map.put("ccc", 33);
        map.put("ddd", 33);
        map.put("eee", 33);
        map.put("fff", 33);
        map.put("ggg", 33);
        map.put("hhh", 33);
        System.out.println("map=" + map);
        Integer value = map.get("fff");
        System.out.println("value=" + value);
        System.out.println("map=" + map);

        for (String key : map.keySet()) {
            System.out.println("key:" + key);
        }

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("aaa", 33);
        map2.put("bbb", 33);
        map2.put("ccc", 33);
        map2.put("ddd", 33);
        map2.put("eee", 33);
        map2.put("fff", 33);
        map2.put("ggg", 33);
        map2.put("hhh", 33);
        System.out.println("map=" + map2);




        Map<String, Integer> map3 = new LinkedHashMap<>(map2);
        System.out.println("map3=" + map3);
//        map.replace("333", 22, 33);
    }

}
