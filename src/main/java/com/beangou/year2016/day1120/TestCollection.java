package com.beangou.year2016.day1120;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutb on 2016/11/20.
 *
 * @since 1.0.0
 */
public class TestCollection {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("6");

        // ½»¼¯
//        boolean b = list1.retainAll(list2);
        list1.removeAll(list2);
        // ²î¼¯
        for(String str: list1)
            System.out.println(str);
    }
}
