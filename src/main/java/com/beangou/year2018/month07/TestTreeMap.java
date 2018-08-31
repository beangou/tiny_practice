package com.beangou.year2018.month07;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @author 小彬
 * @version V1.0 2018/7/21 下午11:05
 * @since V1.0
 */
public class TestTreeMap {

    @Test
    public void see() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "999");
        treeMap.put(2, "222");
        treeMap.put(3, "333");
        treeMap.put(4, "000");
        treeMap.put(5, "777");
        for (String value : treeMap.values()) {
            System.out.println("valu=" + value);
        }
    }

}
