package com.beangou.year2017.month03.day0328;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by liutongbin on 2017/3/28.
 */
public class LoopMap {

    @Test
    public void loop() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");

        Iterator<String> iterator = map.values().iterator();
        while(iterator.hasNext()) {
            String value = iterator.next();
            if (value.equals("3")) {
                iterator.remove();
            }
        }

        System.out.println("map=" + map);

    }

}
