package com.beangou.year2018.month07;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author 小彬
 * @version V1.0 2018/7/21 上午10:26
 * @since V1.0
 */
public class TestHashSet {

    @Test
    public void see() throws InstantiationException, IllegalAccessException {
        String instance = String.class.newInstance();
        Long a = null;
        System.out.println("a=" + a);
        HashSet<Integer> set = new HashSet<>(8);
        set.add(22);
        set.contains(5);
    }

}
