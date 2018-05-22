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
    public void see() {

        System.out.println("a = " + (1 << 1));

        HashMap<String, Integer> map = new HashMap();

        for (Integer value : map.values()) {
            System.out.println("value=" + value);
        }

        map.put("11", 99);

        System.out.println("sss=" + (2 ^ 3));

        System.out.println("null == null :" + (null == null));

    }



}
