package com.beangou.year2018.month03.day06;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author 小彬
 * @version V1.0 2018/4/21 下午8:49
 * @since V1.0
 */
public class TestHashTable {

    @Test
    public void see() {

        Map<String, Integer> map = new HashMap<>();
        map.put(null, 22);
        System.out.println("map=" + map);

        Map<String, Integer> table = new Hashtable<>();
        table.put(null, 22);
        System.out.println("table=" + table);
    }

}
