package com.beangou.year2017.day0317;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutongbin on 2017/3/17.
 */
public class MyArithmetic {

    /**
     * 随机从一个数组里面，随机取出n个元素
     */
    @Test
    public void selectFromArrayByRandom() {
        int n = 5;
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");

        for (int i = 0; i < 5; i++) {
            int index = RandomUtils.nextInt(0, list.size());
            System.out.println("element=" + list.get(index));
            list.remove(index);
        }

        System.out.println("list=" + list);
    }

}

