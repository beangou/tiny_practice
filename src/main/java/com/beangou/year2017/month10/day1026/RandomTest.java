package com.beangou.year2017.month10.day1026;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 小彬
 * @version V1.0 2017/10/26 下午4:27
 * @since V1.0
 */
public class RandomTest {

    @Test
    public void getSomeEleFromList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        System.out.println("list=" + list);
    }

}
